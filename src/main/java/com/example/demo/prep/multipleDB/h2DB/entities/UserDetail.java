package com.example.demo.prep.multipleDB.h2DB.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_details") // Hibernate will auto-create this table in H2
@Getter
@Setter
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailId;

    // This links to the ID stored in MySQL
    private Long userId;

    private String bio;

    private String userType; // e.g., "PREMIUM", "GUEST"

    // Default constructor for JPA
    public UserDetail() {}

    public UserDetail(Long userId, String bio, String userType) {
        this.userId = userId;
        this.bio = bio;
        this.userType = userType;
    }
}
