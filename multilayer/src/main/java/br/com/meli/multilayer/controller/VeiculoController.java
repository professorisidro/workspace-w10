package br.com.meli.multilayer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.multilayer.model.Veiculo;
import br.com.meli.multilayer.service.IVeiculoService;
import br.com.meli.multilayer.validator.VeiculoValidator;

@RestController
public class VeiculoController {
	
	@Autowired
	@Qualifier("padrao")
	private IVeiculoService service;
	
	@PostMapping("/veiculos")
	public ResponseEntity<Veiculo> addNew(@RequestBody Veiculo v) {
		if (VeiculoValidator.isValid(v)) {
			return ResponseEntity.status(201).body(service.adicionarNovo(v));
		}
		return ResponseEntity.badRequest().build();
	}
	
	
	@GetMapping("/veiculos")
	public List<Veiculo> recuperarTodos(){
		return service.recuperarTodos();
		
	}

}
