package br.com.meli.authproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.meli.authproject.dto.LoginDTO;
import br.com.meli.authproject.dto.TokenDTO;
import br.com.meli.authproject.model.Usuario;
import br.com.meli.authproject.repo.UsuarioRepo;
import br.com.meli.authproject.security.TokenUtil;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private UsuarioRepo repo;

	@Override
	public Usuario addNew(Usuario u) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		u.setPassword(encoder.encode(u.getPassword()));
		return repo.save(u);
	}

	@Override
	public TokenDTO login(LoginDTO dto) {
		// TODO Auto-generated method stub
		Usuario res = repo.findByLogin(dto.login());
		if (res != null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(dto.senha(), res.getPassword())) {
				return TokenUtil.encode(res);
			}
		}
		return null;
	}

}
