package com.example.demo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.prep.multipleDB.MultiDbPocService;
import com.example.demo.prep.multipleDB.h2DB.repositories.UserDetailRepository;
import com.example.demo.prep.multipleDB.mysqlDB.repositories.MySqlUserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
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

    @Order(1)
    @Bean
    public CommandLineRunner connectionCheck(
            @Qualifier("mysqlDataSource") DataSource mysqlDataSource,
            @Qualifier("h2DataSource") DataSource h2DataSource) {

        return args -> {
            System.out.println("\n--- 🛡️ Starting Multi-DB Connection Check ---");

            // 1. Check MySQL
            checkConnection(mysqlDataSource, "MySQL (Primary)");

            // 2. Check H2
            checkConnection(h2DataSource, "H2 (Secondary/In-Memory)");

            System.out.println("--- 🛡️ Connection Check Complete ---\n");
        };
    }

    private void checkConnection(DataSource dataSource, String dbName) {
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                System.out.println("✅ SUCCESS: Connected to " + dbName + "!");
                System.out.println("   URL: " + connection.getMetaData().getURL());
            }
        } catch (Exception e) {
            System.out.println("❌ FAILURE: Could not connect to " + dbName);
            System.out.println("   Error: " + e.getMessage());
        }
    }

    @Bean
    @Order(2)
    public CommandLineRunner runPoc(MultiDbPocService pocService) {
        return args -> {
            pocService.runInsertPoc();
        };
    }

    @Bean
    @Order(3) // Ensures this runs AFTER the insert runner
    public CommandLineRunner validateData(
            MySqlUserRepository mysqlRepo,
            UserDetailRepository h2Repo) {

        return args -> {
            System.out.println("\n--- 🔍 VALIDATING DATA IN BOTH DATABASES ---");

            // Validate MySQL
            System.out.println("Checking MySQL (Primary DB)...");
            mysqlRepo.findAll().forEach(user ->
                    System.out.println("   [MySQL] Found User: ID=" + user.getId() + ", Name=" + user.getName())
            );

            // Validate H2
            System.out.println("Checking H2 (Secondary DB)...");
            h2Repo.findAll().forEach(detail ->
                    System.out.println("   [H2] Found Detail: ID=" + detail.getDetailId() +
                            ", For UserID=" + detail.getUserId() +
                            ", Bio=" + detail.getBio())
            );

            System.out.println("--- 🔍 VALIDATION COMPLETE ---\n");
        };
    }
}

