package br.com.meli.apiveiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.apiveiculos.dto.VeiculoDTO;
import br.com.meli.apiveiculos.exception.ConflictException;
import br.com.meli.apiveiculos.model.Veiculo;
import br.com.meli.apiveiculos.repo.IVeiculoRepo;

@Service
public class VeiculoServiceImpl implements IVeiculoService{
	
	@Autowired
	private IVeiculoRepo repo;

	@Override
	public Veiculo save(VeiculoDTO veiculoDto) {
		// TODO Auto-generated method stub
		System.out.println("Recebido = "+veiculoDto);
		if (repo.findById(veiculoDto.id()).isPresent()) {
			throw new ConflictException("ID "+veiculoDto.id()+" ja existe na base");
		}
		return repo.save(convertDtoToVeiculo(veiculoDto));
	}
	
	private Veiculo convertDtoToVeiculo(VeiculoDTO dto) {
		Veiculo v = new Veiculo();
		v.setId(dto.id());
		v.setMarca(dto.marca());
		v.setModelo(dto.modelo());
		v.setAno(dto.ano());
		v.setCor(dto.cor());
		v.setPreco(dto.preco());
		return v;
	}

}
