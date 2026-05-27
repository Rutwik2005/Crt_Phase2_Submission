package com.rcoem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @GetMapping("/customerFallback")
    public ResponseEntity<String> customerFallback() {
		String msg= "Customer service is currently unavailable. Please try again later.";
		return new ResponseEntity<String>(msg, HttpStatus.GATEWAY_TIMEOUT);	
	}
}
