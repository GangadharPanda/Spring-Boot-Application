package com.example.demo.prep.primarydb.repositories;

import com.example.demo.prep.primarydb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
