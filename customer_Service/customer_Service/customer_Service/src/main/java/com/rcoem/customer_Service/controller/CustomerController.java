package com.rcoem.customer_Service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rcoem.customer_Service.entity.Customer;
import com.rcoem.customer_Service.service.CustomerService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/v1/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody @Valid Customer c)//reqBody: json to java
	{
		Customer resp = service.save(c);
		return new ResponseEntity<Customer>(resp, HttpStatus.CREATED);
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<Customer> findById(@PathVariable int cid)
	{
		Customer resp =  service.findById(cid);
		return new ResponseEntity<Customer>(resp, HttpStatus.FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> listAll()
	{
		List<Customer> list = service.listAll();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.FOUND);
	}
	
	@GetMapping("/mobile/{mobile}")
	public ResponseEntity<Customer> findByMobile(@RequestParam String mobile)
	{
		Customer resp = service.findByMobile(mobile);
		return new ResponseEntity<Customer>(resp, HttpStatus.FOUND);
	}
}
