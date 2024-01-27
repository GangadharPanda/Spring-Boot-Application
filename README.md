# How to create Spring Boot application 

1. Go to https://start.spring.io/
2. Select language Java
3. Select Spring Boot Snapshot(3.2.2)
4. Let the Project Metadata as it is
5. Select Java Version
6. Select following maven dependencies
   a. Spring Web
   b. Lombok
   c. Spring Configuration Processor
7. Generate
---
8. Download Eclipse for JAVA EE Developer(I was facing this error <b>"This compilation unit is not on the build path of a Java project."</b> because I was using non Java EE Eclipse).
9. Unzip downloaded project and import existing maven project.
10. Select this project(not the main class) and <b>Run As Java Application</b>.
11. Go to Lombok repository C:\Users\USER\.m2\repository\org\projectlombok and run java -jar lombok-1.16.18.jar in command line
11. It should be all set now.


---
## How to define the first rest API?
 Annotations required :  
 
 @RestController 
 @GetMapping("/hello") (i.e , it will call the API localhost:8080/hello)
 
 ```JAVA 
 package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public List<String> sayHello() {

		List<String> as = new ArrayList<>();
		as.add("Hi");
		as.add("Hello");
		as.add("How are you");
		return as;
	}

}
 
 ```
 
 We can even keep the main class unchanged and define a new class for our API.
 
 ```java
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

}
```



