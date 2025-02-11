package br.com.meli.testes.repo;

import java.util.List;

import br.com.meli.testes.model.Produto;

public interface IProdutoRepo {

	public Produto saveProduct(Produto p);
	public Produto findProductById(Integer id);
	public List<Produto> findAllProducts();
}
