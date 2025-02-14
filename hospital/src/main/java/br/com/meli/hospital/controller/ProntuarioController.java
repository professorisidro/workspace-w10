package br.com.meli.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.hospital.documents.Prontuario;
import br.com.meli.hospital.service.IProntuarioService;

@RestController
public class ProntuarioController {
	
	@Autowired
	private IProntuarioService service;
	
	
	@PostMapping("/prontuarios")
	public Prontuario addNew(@RequestBody Prontuario pront) {
		return service.save(pront);
	}
	
	@GetMapping("/prontuarios/{id}")
	public Prontuario getAll(@PathVariable Integer id){
		return service.findById(id);
	}

}
