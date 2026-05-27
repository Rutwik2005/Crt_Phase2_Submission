package com.rcoem.productService.service;

import com.rcoem.productService.entity.Product;
import com.rcoem.productService.exception.ProductNotFoundException;
import java.util.List;

public interface ProductService {

Product save(Product p);
	
	Product findByCode(int code) throws ProductNotFoundException;
	
	List<Product> listAll();
	
	List<Product> findByPriceBetween(double min , double max);

}
