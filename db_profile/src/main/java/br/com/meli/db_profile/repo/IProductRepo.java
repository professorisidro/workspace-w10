package br.com.meli.db_profile.repo;

import org.springframework.data.repository.ListCrudRepository;

import br.com.meli.db_profile.model.Produto;

public interface IProductRepo extends ListCrudRepository<Produto, Integer>{
	
	

}
