package com.rcoem.customer_Service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcoem.customer_Service.entity.Customer;
import com.rcoem.customer_Service.exception.CustomerNotFoundException;
import com.rcoem.customer_Service.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository repo;

	@Override
	public Customer save(Customer c) {
		return repo.save(c);
	}

	@Override
	public Customer findById(int cid) throws CustomerNotFoundException {
		return repo.findById(cid).orElseThrow(() -> new CustomerNotFoundException("Customer not found with the ID: " + cid));
	}

	@Override
	public List<Customer> listAll() {
		return repo.findAll();
	}

	@Override
	public Customer findByMobile(String mobile) throws CustomerNotFoundException {
		Customer c = repo.findByMobile(mobile);
		
		if(c==null)
		{
			throw new CustomerNotFoundException("Customer not found with mobile no: " + mobile);
		}
		return c;
	}
}
