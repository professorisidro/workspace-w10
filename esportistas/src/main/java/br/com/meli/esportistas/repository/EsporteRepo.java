package br.com.meli.esportistas.repository;

import java.util.ArrayList;

import br.com.meli.esportistas.model.Esporte;

public class EsporteRepo {
	
	public ArrayList<Esporte> database;
	
	public EsporteRepo() {
		database = new ArrayList<Esporte>() {{
			add(new Esporte("Futebol","iniciante"));
			add(new Esporte("Natacao","iniciante"));
			add(new Esporte("Basquete","intermediario"));
			add(new Esporte("Volei","intermediario"));
		}};
	}
	
	public ArrayList<Esporte> recuperarTodos(){
		return database;
	}
	
	public Esporte recuperarPeloNome(String nome) {		
		return database.stream().filter(e -> e.getNome().contains(nome)).findFirst().orElse(null);
	}

}
