package br.com.meli.hospital.service;

import java.util.List;

import br.com.meli.hospital.model.Paciente;

public interface IPacienteService {
	public Paciente save(Paciente p);
	public List<Paciente> findAll();
	public Paciente findById(Integer id);

}
