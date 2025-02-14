package br.com.meli.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.hospital.model.Paciente;
import br.com.meli.hospital.repo.PacienteRepo;

@Service
public class PacienteServiceImpl implements IPacienteService{
	
	@Autowired
	private PacienteRepo repo;

	@Override
	public Paciente save(Paciente p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}

	@Override
	public List<Paciente> findAll() {
		// TODO Auto-generated method stub
		return (List<Paciente>)repo.findAll();
	}

	@Override
	public Paciente findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}
	
	

}
