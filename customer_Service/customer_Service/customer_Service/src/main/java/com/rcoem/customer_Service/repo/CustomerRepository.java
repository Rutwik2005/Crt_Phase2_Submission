package com.rcoem.customer_Service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcoem.customer_Service.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer , Integer> {
	Customer findByMobile(String mobile); 
}
