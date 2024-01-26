package com.example.demo.modal;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Order {
	private Integer orderId;
	private Double amountDouble;
	private String xValue;
	

	public String getxValue() {
		return xValue;
	}

	public void setxValue(String xValue) {
		this.xValue = xValue;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getAmountDouble() {
		return amountDouble;
	}

	public void setAmountDouble(Double amountDouble) {
		this.amountDouble = amountDouble;
	}

	public Order(int orderId, double amountDouble) {
		this.orderId = orderId;
		this.amountDouble = amountDouble;
	}
}
