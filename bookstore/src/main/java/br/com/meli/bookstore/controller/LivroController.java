package br.com.meli.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.bookstore.model.Livro;
import br.com.meli.bookstore.repo.LivroRepo;

@RestController
public class LivroController {
	
	@Autowired
	private LivroRepo repo;
	
	
	@PostMapping("/livros")
	public Livro addNewLivro(@RequestBody Livro livro) {
		return repo.save(livro);
	}
	
	@GetMapping("/livros")
	public List<Livro> getAllLivros(){
		return repo.findAll();
	}
	

}
