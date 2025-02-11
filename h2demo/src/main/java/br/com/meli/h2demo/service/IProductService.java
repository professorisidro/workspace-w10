package br.com.meli.h2demo.service;

import java.util.List;

import br.com.meli.h2demo.model.Product;

public interface IProductService {
	public Product addProduct(Product p);
	public Product updateProduct(Product p);
	public List<Product> findAllProducts();
	public Product findProductById(Integer id);

}
