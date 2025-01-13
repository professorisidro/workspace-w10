package br.com.meli.multilayer.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meli.multilayer.model.Veiculo;

@Repository
public class VeiculoRepo {
	private List<Veiculo> database;
	
	public VeiculoRepo() {
		System.out.println("Inicializando Repositorio de Veiculos");
		this.database = new ArrayList<Veiculo>();
	}
	
	
	public Veiculo save(Veiculo v) {
		this.database.add(v);
		return v;
	}
	
	public List<Veiculo> findAll(){
		return this.database;
	}
	
	public List<Veiculo> findByMarca(String marca){
		return database.stream().filter(v -> v.getMarca().equalsIgnoreCase(marca)).toList();
	}
	
	public Double somarPrecosPorMarca(String marca){
		return database.stream().filter(v -> v.getMarca().equalsIgnoreCase(marca)).mapToDouble(Veiculo::getPreco).sum();
	}

}
