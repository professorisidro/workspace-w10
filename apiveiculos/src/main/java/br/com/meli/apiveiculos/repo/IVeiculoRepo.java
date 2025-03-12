package br.com.meli.apiveiculos.repo;

import org.springframework.data.repository.ListCrudRepository;

import br.com.meli.apiveiculos.model.Veiculo;

public interface IVeiculoRepo extends ListCrudRepository<Veiculo, Integer> {

}
