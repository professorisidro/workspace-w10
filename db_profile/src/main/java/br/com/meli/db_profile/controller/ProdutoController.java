package br.com.meli.db_profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.db_profile.model.Produto;
import br.com.meli.db_profile.repo.IProductRepo;

@RestController
public class ProdutoController {
	
	@Autowired
	private IProductRepo repo;
	
	@GetMapping("/produtos")
	public List<Produto> recuperarTodos(){
		return repo.findAll();
	}

}
