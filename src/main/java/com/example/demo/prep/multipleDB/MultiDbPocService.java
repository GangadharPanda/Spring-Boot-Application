package com.example.demo.prep.multipleDB;

import com.example.demo.prep.multipleDB.h2DB.entities.UserDetail;
import com.example.demo.prep.multipleDB.h2DB.repositories.UserDetailRepository;
import com.example.demo.prep.multipleDB.mysqlDB.entities.MySqlUser;
import com.example.demo.prep.multipleDB.mysqlDB.repositories.MySqlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiDbPocService {

    @Autowired(required = false)
    private MySqlUserRepository userRepository;

    @Autowired(required = false)
    private UserDetailRepository userDetailRepository;

    public void runInsertPoc() {
        System.out.println("🚀 Starting Multi-DB Insert POC...");

        // 1. Insert into MySQL
        if (userRepository != null) {
            MySqlUser mysqlUser = new MySqlUser();
            mysqlUser.setId(101L);
            mysqlUser.setName("Gemini_User");
            userRepository.save(mysqlUser);
            System.out.println("✅ Data saved to MySQL (Primary)");
        }

        // 2. Insert into H2
        if (userDetailRepository != null) {
            UserDetail h2Detail = new UserDetail();
            h2Detail.setUserId(101L); // Linking to MySQL ID
            h2Detail.setBio("This data lives only in memory (H2)!");
            userDetailRepository.save(h2Detail);
            System.out.println("✅ Data saved to H2 (Secondary)");
        }
    }
}
