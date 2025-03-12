package br.com.meli.authproject.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.meli.authproject.model.Usuario;

public interface UsuarioRepo extends CrudRepository<Usuario, Integer>{
	public Usuario findByLogin(String login);

}
