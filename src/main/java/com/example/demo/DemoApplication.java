package com.example.demo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

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

    @Bean
    public CommandLineRunner connectionCheck(DataSource dataSource) {
        return args -> {
            System.out.println("--- Checking Database Connection ---");
            try (Connection connection = dataSource.getConnection()) {
                if (connection != null) {
                    System.out.println("✅ SUCCESS: Connected to MySQL!");
                    System.out.println("Database Name: " + connection.getMetaData().getDatabaseProductName());
                }
            } catch (Exception e) {
                System.out.println("❌ FAILURE: Could not connect to MySQL.");
                System.out.println("Error: " + e.getMessage());
                throw new RuntimeException("❌ FAILURE: Could not connect to MySQL.");
            }
        };
    }

}
