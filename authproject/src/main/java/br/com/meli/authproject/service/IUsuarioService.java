package br.com.meli.authproject.service;

import br.com.meli.authproject.dto.LoginDTO;
import br.com.meli.authproject.dto.TokenDTO;
import br.com.meli.authproject.model.Usuario;

public interface IUsuarioService {
	public Usuario addNew(Usuario u);
	public TokenDTO login(LoginDTO dto);
}
