package br.com.meli.testes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.testes.model.Produto;
import br.com.meli.testes.services.IProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private IProdutoService service;
	
	@PostMapping("/produtos")
	public ResponseEntity<?> addNewProduct(@RequestBody Produto p){
		return ResponseEntity.status(201).body(service.save(p));
	}
}
