package br.com.meli.authproject.security;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.meli.authproject.dto.TokenDTO;
import br.com.meli.authproject.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

public class TokenUtil {
	
	private static final String EMISSOR = "MELI_W10";
	private static final String SECRET  = "0123456789012345678901234567890123456789";
	private static final long   EXPIRATION = 3*60*60*1000;
	
	public static TokenDTO encode(Usuario user) {
		try {
			Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
			String jwtToken = Jwts.builder()
							      .subject(user.getName())
							      .issuer(EMISSOR)
							      .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
							      .claim("ROLE", "ROLE_"+user.getRole())
							      .signWith(key)
							      .compact();
			return new TokenDTO(jwtToken);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static Authentication decode(HttpServletRequest request) {
		try {
			String token = request.getHeader("Authorization");
			if (token != null) {
				token = token.replace("Bearer ", "");
				SecretKey secretKey = Keys.hmacShaKeyFor(SECRET.getBytes());
				JwtParser parser = Jwts.parser().verifyWith(secretKey).build();
				Claims claims = (Claims)parser.parse(token).getPayload();
				
				String subject = claims.getSubject();
				String emissor = claims.getIssuer();
				Date exp = claims.getExpiration();
				String role = claims.get("ROLE").toString();
				
				if (subject != null && emissor.equals(EMISSOR) && exp.after(new Date(System.currentTimeMillis()))) {
					Authentication auth = new UsernamePasswordAuthenticationToken(subject, null, Collections.singletonList(new SimpleGrantedAuthority(role)));
					return auth;
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
