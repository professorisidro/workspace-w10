package br.com.meli.hospital.service;

import java.util.List;

import br.com.meli.hospital.documents.Prontuario;

public interface IProntuarioService {
	public Prontuario save(Prontuario prontuario);

	public List<Prontuario> findAll();

	public Prontuario findById(Integer id);

	public List<Prontuario> findByHistoricoContaining(String key);
}
