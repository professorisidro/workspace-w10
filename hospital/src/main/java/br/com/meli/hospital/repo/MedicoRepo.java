package br.com.meli.hospital.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.meli.hospital.model.Medico;

public interface MedicoRepo extends CrudRepository<Medico, Integer> {

}
