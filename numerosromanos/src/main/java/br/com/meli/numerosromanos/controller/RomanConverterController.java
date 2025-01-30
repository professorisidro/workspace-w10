package br.com.meli.numerosromanos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.numerosromanos.service.Conversor;

@RestController
public class RomanConverterController {

	
	@Autowired
	private Conversor conversor;
	
	@GetMapping("/convert/{number}")
	public ResponseEntity<?> convertToRoman(@PathVariable Integer number){
		return ResponseEntity.ok(conversor.convertToRoman(number));
	}
}
