package com.rcoem.orderService.service;

import java.util.List;

import com.rcoem.orderService.entity.Order;
import com.rcoem.orderService.vo.OrderVO;

public interface OrderService {
	
	OrderVO save(Order order);
	
	OrderVO findByNo(int ordNo);
	
	List<OrderVO> findByCustId(int cid);
}
