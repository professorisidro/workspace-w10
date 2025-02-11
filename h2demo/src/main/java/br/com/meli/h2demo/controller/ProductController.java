package br.com.meli.h2demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.h2demo.model.Product;
import br.com.meli.h2demo.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@PostMapping("/products")
	public ResponseEntity<Product> addNewProduct(@RequestBody Product p){
		Product res = service.addProduct(p);
		if (res != null) {
			return ResponseEntity.status(201).body(res);
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product p){
		if (p.getId() == null) {
			p.setId(id);
		}
		Product res = service.updateProduct(p);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> findAll(){
		return ResponseEntity.ok(service.findAllProducts());
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id){
		Product res = service.findProductById(id);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
}
