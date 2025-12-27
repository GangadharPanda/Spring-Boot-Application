package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.modal.UserDTO;
import com.example.demo.prep.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Order;

@RestController
public class DemoController {

    @Autowired
    UserService userService;

    @GetMapping("/orders")
    public List<Order> getOrders() {
        Order order1 = new Order(1, 100d);
        Order order2 = new Order(2, 200d);
        Order order3 = new Order(3, 300d);
        Order order4 = new Order(4, 4000d);
        Order order5 = new Order(5, 500d);
        Order order6 = new Order(6, 600d);
        Order order7 = new Order(7, 700d);

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

    @GetMapping("/getUsers")
    public List<UserDTO> getUsers() {
        return userService.getAllPrimaryUser();
    }

}
