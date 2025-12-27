package com.example.demo.prep.singleDB.primarydb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


/**
 * NOTE: Using 'catalog' instead of 'schema' for MySQL cross-database mapping.
 * In MySQL, databases are treated as catalogs. This allows the application
 * to access 'SECONDARY_DB' while the main connection is on 'PRIMARY_DB'.
 * <p>
 * This is the case when we want to use multiple schema from MySQL
 */

@Entity
//@Table(name = "primary_user", catalog = "primary_db")
@Table(name = "secondary_user", catalog = "secondary_db")
@Getter
@Setter
public class User {

    @Id
    private Long id;
    private String name;
}
