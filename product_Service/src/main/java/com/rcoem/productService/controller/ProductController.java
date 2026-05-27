package com.rcoem.productService.controller;
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

import com.rcoem.productService.entity.Product;
import com.rcoem.productService.service.ProductService;


@CrossOrigin
@RestController
@RequestMapping("/v1/api/products")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product p)
	{
		Product resp = service.save(p);
		return new ResponseEntity<Product>(resp, HttpStatus.CREATED);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<Product> findByCode(@PathVariable int code)
	{
		Product resp =  service.findByCode(code);
		return new ResponseEntity<Product>(resp, HttpStatus.FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> list()
	{
		List<Product> list = service.listAll();
		return new ResponseEntity<List<Product>>(list, HttpStatus.FOUND);
	}
	
	@GetMapping("/v1/api/products/search/price")
	public ResponseEntity<List<Product>> listByPice(@RequestParam double min , @RequestParam double max)
	{
		List<Product> list = service.findByPriceBetween(min,max);
		return new ResponseEntity<List<Product>>(list, HttpStatus.FOUND);
	}
}
