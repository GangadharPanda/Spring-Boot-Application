package com.example.demo.prep.singleDB.primarydb.repositories;

import com.example.demo.prep.singleDB.primarydb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
