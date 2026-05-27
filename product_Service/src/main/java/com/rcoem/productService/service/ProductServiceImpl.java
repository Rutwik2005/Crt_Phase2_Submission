package com.rcoem.productService.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcoem.productService.entity.Product;
import com.rcoem.productService.exception.ProductNotFoundException;
import com.rcoem.productService.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repo;

	@Override
	public Product save(Product p) {
		return repo.save(p);
	}

	@Override
	public Product findByCode(int code) throws ProductNotFoundException {
		return repo.findById(code).orElseThrow(() -> new ProductNotFoundException("product not found with code : "+code));
	}

	@Override
	public List<Product> listAll() {
		return repo.findAll();
	}

	@Override
	public List<Product> findByPriceBetween(double min, double max) {
		return repo.findByPriceBetween(min, max);
		
	}
}
