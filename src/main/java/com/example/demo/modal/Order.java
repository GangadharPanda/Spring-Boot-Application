package com.example.demo.modal;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
	Integer orderId;
	Double amountDouble;

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
