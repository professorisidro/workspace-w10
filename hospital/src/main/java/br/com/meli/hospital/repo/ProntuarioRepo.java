package br.com.meli.hospital.repo;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import br.com.meli.hospital.documents.Prontuario;

public interface ProntuarioRepo extends ElasticsearchRepository<Prontuario, Integer>{
	public List<Prontuario> findByHistoricoContaining(String key);
}
