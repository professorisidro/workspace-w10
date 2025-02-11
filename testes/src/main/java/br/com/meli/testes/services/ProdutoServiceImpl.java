package br.com.meli.testes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.testes.handler.ConflictException;
import br.com.meli.testes.handler.MalformedProductException;
import br.com.meli.testes.model.Produto;
import br.com.meli.testes.repo.IProdutoRepo;

@Service
public class ProdutoServiceImpl implements IProdutoService{

	@Autowired
	private IProdutoRepo repository;

	@Override
	public Produto save(Produto p) {
		// TODO Auto-generated method stub
		if (p.getId() == null || p.getPreco() == null || p.getNome()== null || p.getPreco() < 0) {
			throw new MalformedProductException("Produto  nao pode ter dados vazios");
		}
		if (repository.findProductById(p.getId()) != null) {
			throw new ConflictException("ID ja existente");
		}
		return this.repository.saveProduct(p);
	}

	@Override
	public Produto findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findProductById(id);
	}

	@Override
	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return repository.findAllProducts();
	}
	
	
}
