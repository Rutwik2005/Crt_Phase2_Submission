package com.rcoem.orderService.controller;
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
import org.springframework.web.bind.annotation.RestController;

import com.rcoem.orderService.entity.Order;
import com.rcoem.orderService.service.OrderService;
import com.rcoem.orderService.vo.OrderVO;


@CrossOrigin
@RestController
@RequestMapping("/v1/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PostMapping
	public ResponseEntity<OrderVO> save(@RequestBody Order order)
	{
		OrderVO resp = service.save(order);
		return new ResponseEntity<OrderVO>(resp , HttpStatus.CREATED);
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<OrderVO> findByNo(@PathVariable int no)
	{
		OrderVO resp = service.findByNo(no);
		return new ResponseEntity<OrderVO>(resp , HttpStatus.FOUND);
	}
	
	@GetMapping("/customer/{cid}")
	public ResponseEntity<List<OrderVO>> findByCustId(@PathVariable int cid)
	{
		List<OrderVO> resp = service.findByCustId(cid);
		return new ResponseEntity<List<OrderVO>>(resp , HttpStatus.FOUND);
	}
}
