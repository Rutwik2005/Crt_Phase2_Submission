package com.rcoem.customer_Service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id @Column(name="cid")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(value = 100 , message = "Customer ID must be greater than 100")
	private int custId;
	@Column(name="cname", length=30) 
	@Size(min = 5 , message ="Customer name must be min 5 characters")
	private String custName;
	@Column(unique = true, length=14)
	@Size(min = 10 ,message = "Mobile no must be 10 digits")
	private String mobile;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
