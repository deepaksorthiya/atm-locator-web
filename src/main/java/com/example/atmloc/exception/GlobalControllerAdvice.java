package com.example.atmloc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(value = { ResourceNotFoundExcetion.class })
	public ResponseEntity<?> handleResourceNotFoundExcetion(ResourceNotFoundExcetion e) {
		return new ResponseEntity<>(e.getMessage(), null, HttpStatus.NOT_FOUND);
	}
}
