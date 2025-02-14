package br.com.meli.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.hospital.model.Paciente;
import br.com.meli.hospital.service.IPacienteService;

@RestController
public class PacienteController {
	
	@Autowired
	private IPacienteService service;
	
	@PostMapping("/pacientes")
	public Paciente addNew(@RequestBody Paciente paciente) {
		return service.save(paciente);
	}
	
	@GetMapping("/pacientes")
	public List<Paciente> getAll(){
		return service.findAll();
	}
	
	@GetMapping("/pacientes/{id}")
	public Paciente getById(@PathVariable Integer id) {
		return service.findById(id);
	}

}
