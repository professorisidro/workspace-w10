package br.com.meli.testes.services;

import java.util.List;

import br.com.meli.testes.model.Produto;

public interface IProdutoService {
	
	public Produto save(Produto p);
	public Produto findById(Integer id);
	public List<Produto> findAll();

}
