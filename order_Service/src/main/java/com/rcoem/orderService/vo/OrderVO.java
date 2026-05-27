package com.rcoem.orderService.vo;

import java.time.LocalDate;

import com.rcoem.orderService.entity.Order;



public class OrderVO {
	
	private int order;
	private LocalDate ordDate;
	private double amount;
	
	private CustomerVO customer;
	private ProductVO item;
	
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public LocalDate getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(LocalDate ordDate) {
		this.ordDate = ordDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public CustomerVO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}
	public ProductVO getItem() {
		return item;
	}
	public void setItem(ProductVO item) {
		this.item = item;
	}
	
	public static final OrderVO transform(Order order)
	{
		OrderVO vo = new OrderVO();
		vo.setOrder(order.getOrder());
		vo.setOrdDate(order.getOrdDate());
		vo.setAmount(order.getAmount());
		return vo;
	}
	
}
