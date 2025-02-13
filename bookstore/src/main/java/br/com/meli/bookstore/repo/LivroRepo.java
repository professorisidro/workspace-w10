package br.com.meli.bookstore.repo;

import org.springframework.data.repository.ListCrudRepository;

import br.com.meli.bookstore.model.Livro;

public interface LivroRepo extends ListCrudRepository<Livro, Integer>{

}
