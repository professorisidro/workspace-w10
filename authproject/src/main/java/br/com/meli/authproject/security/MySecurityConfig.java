package br.com.meli.authproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception	{
		
		http.csrf( (csrf)-> {
			csrf.disable();  		// desabilitei a telinha de login
		})
		.authorizeHttpRequests( (auth) -> {
			auth.requestMatchers(new AntPathRequestMatcher("/hello", "GET")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/usuarios", "POST")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/login","POST")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/buyer","GET")).hasRole("BUYER")
				.requestMatchers(new AntPathRequestMatcher("/seller","GET")).hasRole("SELLER")
				.requestMatchers(new AntPathRequestMatcher("/repr","GET")).hasRole("REPRESENTANT")
			    .anyRequest().authenticated();
		})
		.addFilterBefore(new AuthFilter(), UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
		
	}

}
