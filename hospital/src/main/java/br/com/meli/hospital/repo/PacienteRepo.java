package br.com.meli.hospital.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.meli.hospital.model.Paciente;

public interface PacienteRepo extends CrudRepository<Paciente, Integer>{
	
}
