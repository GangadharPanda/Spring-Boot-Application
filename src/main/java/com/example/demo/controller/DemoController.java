package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Order;

@RestController
public class DemoController {

	@GetMapping("/orders")
	public List<Order> getOrders() {
		Order order1 = new Order(1, 1000d);
		Order order2 = new Order(2, 2000d);
		Order order3 = new Order(3, 3000d);
		Order order4 = new Order(4, 4000d);
		Order order5 = new Order(5, 5000d);
		Order order6 = new Order(6, 6000d);
		Order order7 = new Order(7, 7000d);
		List<Order> orders = new ArrayList<Order>();
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
		orders.add(order5);
		orders.add(order6);
		orders.add(order7);
		return orders;
	}

}
