package br.com.meli.authproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
	
	@GetMapping("/auth")
	public String sayAuthHello() {
		return "Hello authenticated world";
	}
	
	@GetMapping("/buyer")
	public String sayHelloToBuyer() {
		return "Hello world - Buyer";
	}
	
	@GetMapping("/seller")
	public String sayHelloToSeller() {
		return "Hello world - Seller";
	}
	
	@GetMapping("/repr")
	public String sayHelloToRepresentant() {
		return "Hello world - Representant";
	}

}
