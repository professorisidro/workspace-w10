package br.com.meli.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.bookstore.dto.AutorStats;
import br.com.meli.bookstore.model.Autor;
import br.com.meli.bookstore.repo.AutorRepo;

@RestController
public class AutorController {
	
	@Autowired
	private AutorRepo repo;
	
	@PostMapping("/autor")
	public Autor addNewAutor(@RequestBody Autor autor) {
		return repo.save(autor);
	}
	
	@GetMapping("/autor/stats/{id}")
	public AutorStats recuperarEstatisticas(@PathVariable Integer id) {
		Optional<Autor> autor = repo.findById(id);
		if (autor.isPresent()) {
			return new AutorStats(autor.get().getId(), autor.get().getNome(),autor.get().getLivros().size());
		}
		return null;
	}
	
	@GetMapping("/autor")
	public List<Autor> getAllAutores(){
		return repo.findAll();
	}
	
	@DeleteMapping("/autor/{id}")
	public String deleteAutor(@PathVariable Integer id) {
		repo.deleteById(id);
		return "deletado";
	}

}
