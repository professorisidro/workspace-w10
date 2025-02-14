package br.com.meli.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.hospital.documents.Prontuario;
import br.com.meli.hospital.repo.ProntuarioRepo;

@Service
public class ProntuarioServiceImpl implements IProntuarioService{

	@Autowired
	private ProntuarioRepo repo;

	@Override
	public Prontuario save(Prontuario prontuario) {
		// TODO Auto-generated method stub
		return repo.save(prontuario);
	}

	@Override
	public List<Prontuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Prontuario>)repo.findAll();
	}

	@Override
	public Prontuario findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Prontuario> findByHistoricoContaining(String key) {
		// TODO Auto-generated method stub
		return repo.findByHistoricoContaining(key);
	}
	
	
	
}
