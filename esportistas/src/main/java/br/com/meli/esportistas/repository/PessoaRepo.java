package br.com.meli.esportistas.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.meli.esportistas.dto.PessoaDTO;
import br.com.meli.esportistas.model.Esporte;
import br.com.meli.esportistas.model.Pessoa;

public class PessoaRepo {
	
	private ArrayList<Pessoa> database;
	
	public PessoaRepo() {
		database = new ArrayList() {{ 
			add(new Pessoa("Professor","Isidro",46,new Esporte("Futebol","iniciante")));
			add(new Pessoa("Jose","Almeida",23,new Esporte("Natacao","iniciante")));
			add(new Pessoa("Pedro","Fonseca", 35, new Esporte("Volei", "intermediario")));
			
		}};
		
	}
	
	public ArrayList<Pessoa> listarTodos(){
		return database;
	}
	
	public List<PessoaDTO> recuperarTudoCustomizado(){
		return database.stream().map(p -> new PessoaDTO(p.getNome(), p.getSobrenome(), p.getEsporte().getNome())).toList();
		
	}
}
