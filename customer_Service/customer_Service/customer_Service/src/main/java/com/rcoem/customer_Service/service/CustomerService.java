package com.rcoem.customer_Service.service;

import com.rcoem.customer_Service.entity.Customer;
import com.rcoem.customer_Service.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
	
	Customer save(Customer c);
	
	Customer findById(int cid) throws CustomerNotFoundException;
	
	List<Customer> listAll();
	
	Customer findByMobile(String mobile) throws CustomerNotFoundException;

}
