package com.example.demo.prep.multipleDB.mysqlDB.repositories;

import com.example.demo.prep.multipleDB.mysqlDB.entities.MySqlUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySqlUserRepository extends JpaRepository<MySqlUser, Long> {

}
