package br.com.meli.numerosromanos.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConverterExceptionHandler {
	
	@ExceptionHandler(OutOfRangeException.class)
	public ResponseEntity<?> handleOutOfRange(Exception ex){
		return ResponseEntity.badRequest().build();
	}

}
