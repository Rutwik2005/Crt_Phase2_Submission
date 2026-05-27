package com.rcoem.productService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rcoem.productService.exception.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleInvalidCustomer(ProductNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage() , HttpStatus.NOT_FOUND);
	}
}
