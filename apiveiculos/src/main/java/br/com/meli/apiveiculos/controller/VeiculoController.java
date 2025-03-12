package br.com.meli.apiveiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.apiveiculos.dto.VeiculoDTO;
import br.com.meli.apiveiculos.model.Endereco;
import br.com.meli.apiveiculos.model.Veiculo;
import br.com.meli.apiveiculos.service.CEPService;
import br.com.meli.apiveiculos.service.IVeiculoService;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
public class VeiculoController {
	@Autowired
	private IVeiculoService service;
	
	@Autowired
	private CEPService cepService;
	
	@PostMapping("/veiculos")
	public ResponseEntity<Veiculo> addNew(@RequestBody @Valid VeiculoDTO dto){
		return ResponseEntity.ok(service.save(dto));
	}
	
	@GetMapping("/cep/{cep}")
	public Endereco getEndereco(@PathVariable String cep) {
		return cepService.consultarCEP(cep);  
	}

	
	@GetMapping("/cepasync/{cep}")
	public Mono<Endereco> getEnderecoAsync(@PathVariable String cep) {
		return cepService.consultarCepAssinc(cep);  
	}
	
	

}
