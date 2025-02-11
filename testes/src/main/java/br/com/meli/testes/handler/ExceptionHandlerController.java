package br.com.meli.testes.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(MalformedProductException.class)
	public ResponseEntity<?> handleMalfomedProduct(MalformedProductException e){
		return ResponseEntity.badRequest().build();
	}
	
	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<?> handleConflic(ConflictException e){
		return ResponseEntity.status(409).build();
	}
}
