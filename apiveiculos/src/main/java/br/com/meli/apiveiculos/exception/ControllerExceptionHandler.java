package br.com.meli.apiveiculos.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<?> validateConflict(ConflictException ex){
		return ResponseEntity.status(409).body(new ErroDTO(ex.getMessage()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> validateDTO(MethodArgumentNotValidException ex){
		return ResponseEntity.status(400).body(new ErroDTO(ex.getMessage()));
	}
}
