package com.example.Transaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InputSearchException.class)
	public ResponseEntity<String> inputexcption(Exception ex){
		return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> NotFound(Exception ex){
		return new ResponseEntity<String>("Not found", HttpStatus.NOT_FOUND);
	}
}
