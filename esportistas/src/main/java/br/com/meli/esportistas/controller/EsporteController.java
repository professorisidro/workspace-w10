package br.com.meli.esportistas.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.esportistas.model.Esporte;
import br.com.meli.esportistas.repository.EsporteRepo;

@RestController
public class EsporteController {
	
	private EsporteRepo repo;
	
	public EsporteController() {
		repo = new EsporteRepo();
	}
	
	@GetMapping("/findSports")
	public ArrayList<Esporte> findSports(){
		return repo.recuperarTodos();
	}
	
	@GetMapping("/findSports/{name}")
	public ResponseEntity<Esporte> findByName(@PathVariable String name) {
		Esporte e = repo.recuperarPeloNome(name);
		if (e != null) {
			return ResponseEntity.ok(e);
		}
		return ResponseEntity.notFound().build();
	}
}
