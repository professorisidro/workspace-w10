package br.com.meli.morsedecoder.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.morsedecoder.messages.MorseRequest;
import br.com.meli.morsedecoder.messages.MorseResponse;
import br.com.meli.morsedecoder.service.MorseDecoder;

@RestController
public class MorseController {
	

	
	@PostMapping("/decode")
	public MorseResponse decodeMorsePhrase(@RequestBody MorseRequest morseRequest) {
		return new MorseResponse(MorseDecoder.decodePhrase(morseRequest.morseCode()));
	}

}
