package br.com.meli.testes.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meli.testes.model.Produto;

@Repository
public class ProductRepo implements IProdutoRepo{

	private List<Produto> database;
	
	public ProductRepo() {
		this.database = new ArrayList<Produto>();
	}

	@Override
	public Produto saveProduct(Produto p) {
		System.out.println("SAVE - Invocando a implementacao do Repo");
		
		// TODO Auto-generated method stub
		this.database.add(p);
		return p;
	}

	@Override
	public Produto findProductById(Integer id) {
		System.out.println("FINDBYID - Invocando a implementação do Repo");
		// TODO Auto-generated method stub
		return database.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public List<Produto> findAllProducts() {
		// TODO Auto-generated method stub
		System.out.println("FINDALL - Invocando a implementação do Repo");
		return this.database;
	}
}
