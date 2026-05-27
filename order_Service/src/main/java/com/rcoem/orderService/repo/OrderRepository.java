package com.rcoem.orderService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcoem.orderService.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	
	List<Order> findByCustId(int cid);
}
