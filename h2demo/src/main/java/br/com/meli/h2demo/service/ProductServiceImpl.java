package br.com.meli.h2demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.h2demo.model.Product;
import br.com.meli.h2demo.repo.IProdutoRepo;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProdutoRepo repo;
	
	@Override
	public Product addProduct(Product p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}

	@Override
	public Product updateProduct(Product p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}
	

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>)repo.findAll();
	}

	@Override
	public Product findProductById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

}
