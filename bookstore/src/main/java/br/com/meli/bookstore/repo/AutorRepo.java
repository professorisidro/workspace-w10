package br.com.meli.bookstore.repo;

import org.springframework.data.repository.ListCrudRepository;

import br.com.meli.bookstore.model.Autor;

public interface AutorRepo extends ListCrudRepository<Autor, Integer>{

}
