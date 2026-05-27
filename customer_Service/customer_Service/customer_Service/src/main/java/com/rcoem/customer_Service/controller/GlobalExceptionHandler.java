package com.rcoem.customer_Service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rcoem.customer_Service.exception.CustomerNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleInvalidCustomer(CustomerNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage() , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgNotValid(MethodArgumentNotValidException e)
	{
		return new ResponseEntity<String>(e.getMessage() , HttpStatus.BAD_REQUEST);
	}
}
