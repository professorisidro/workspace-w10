package br.com.meli.esportistas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.esportistas.dto.PessoaDTO;
import br.com.meli.esportistas.model.Pessoa;
import br.com.meli.esportistas.repository.PessoaRepo;

@RestController
public class PessoaController {
	
	private PessoaRepo repo;
	
	public PessoaController() {
		this.repo = new PessoaRepo();
	}

	
	@GetMapping("/findSportsPersons")
	public List<PessoaDTO> recuperarEsportistas(){
		return this.repo.recuperarTudoCustomizado();
	}
	
	@GetMapping("/findSportsPersonsOriginal")
	public List<Pessoa> recuperarEsportistasNormal(){
		return this.repo.listarTodos();
	}
}
