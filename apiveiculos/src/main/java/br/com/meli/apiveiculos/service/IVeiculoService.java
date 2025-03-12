package br.com.meli.apiveiculos.service;

import br.com.meli.apiveiculos.dto.VeiculoDTO;
import br.com.meli.apiveiculos.model.Veiculo;

public interface IVeiculoService {
	
	public Veiculo save(VeiculoDTO veiculoDto);

}
