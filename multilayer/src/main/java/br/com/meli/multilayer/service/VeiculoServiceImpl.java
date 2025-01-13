package br.com.meli.multilayer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.meli.multilayer.model.Veiculo;
import br.com.meli.multilayer.repo.VeiculoRepo;

@Service
@Qualifier("padrao")
public class VeiculoServiceImpl implements IVeiculoService{
		
	private VeiculoRepo repo;
	
	public VeiculoServiceImpl(VeiculoRepo repo) {
		System.out.println("Inicializando Service");
		this.repo = repo;
	}

	@Override
	public Veiculo adicionarNovo(Veiculo v) {
		// TODO Auto-generated method stub
		return repo.save(v);
	}

	@Override
	public List<Veiculo> recuperarPorMarca(String marca) {
		// TODO Auto-generated method stub
		return repo.findByMarca(marca);
	}

	@Override
	public Double totalizarPorMarca(String marca) {
		// TODO Auto-generated method stub
		return repo.somarPrecosPorMarca(marca);
	}

	@Override
	public List<Veiculo> recuperarTodos() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	

}
