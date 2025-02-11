package br.com.meli.h2demo.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.meli.h2demo.model.Product;

public interface IProdutoRepo extends CrudRepository<Product, Integer>{

}
