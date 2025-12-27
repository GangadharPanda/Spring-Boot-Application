package com.example.demo.prep.multipleDB.h2DB.repositories;

import com.example.demo.prep.multipleDB.h2DB.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    // Custom query to find details by the MySQL User ID
    Optional<UserDetail> findByUserId(Long userId);
}
