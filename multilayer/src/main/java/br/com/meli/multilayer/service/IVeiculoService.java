package br.com.meli.multilayer.service;

import java.util.List;

import br.com.meli.multilayer.model.Veiculo;

public interface IVeiculoService {
	public Veiculo adicionarNovo(Veiculo v);
	public List<Veiculo> recuperarPorMarca(String marca);
	public Double totalizarPorMarca(String marca);
	public List<Veiculo> recuperarTodos();
}
