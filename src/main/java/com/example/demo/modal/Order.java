package com.example.demo.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Order {
	private Integer orderId;
	private Double amountDouble;
}
