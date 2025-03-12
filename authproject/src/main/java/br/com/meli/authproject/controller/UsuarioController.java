package br.com.meli.authproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.authproject.dto.LoginDTO;
import br.com.meli.authproject.dto.TokenDTO;
import br.com.meli.authproject.model.Usuario;
import br.com.meli.authproject.service.IUsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@PostMapping("/usuarios")
	public Usuario addNewUsuario(@RequestBody Usuario novo) {
		return service.addNew(novo);
	}
	
	
	@PostMapping("/login")
	public TokenDTO loginUser(@RequestBody LoginDTO dados) {
		return service.login(dados);
	}
	
	

}
