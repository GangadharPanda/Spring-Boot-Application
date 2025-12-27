package com.example.demo.prep.multipleDB;


import com.example.demo.prep.multipleDB.h2DB.entities.UserDetail;
import com.example.demo.prep.multipleDB.h2DB.repositories.UserDetailRepository;
import com.example.demo.prep.multipleDB.mysqlDB.entities.MySqlUser;
import com.example.demo.prep.multipleDB.mysqlDB.repositories.MySqlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrokenMultiDbService {

    @Autowired
    private MySqlUserRepository mysqlRepo;
    @Autowired private UserDetailRepository h2Repo;

    // Notice: No TransactionManager specified yet,
    // or using the default which only covers MySQL.
    @Transactional(value = "mysqlTransactionManager")
    public void saveWithFailure(MySqlUser user, UserDetail detail) throws Exception {

        System.out.println("1. Saving User to MySQL...");
        mysqlRepo.save(user);

        System.out.println("2. Attempting to save Detail to H2...");

        // SIMULATE A CRASH HERE
        // This is a CHECKED exception
        if (true) {
            throw new Exception("I am a Checked Exception! Spring will ignore me and COMMIT.");
        }

        h2Repo.save(detail);
    }

    @Transactional(value = "chainedTransactionManager")
    public void saveTogether(MySqlUser user, UserDetail detail) {
        mysqlRepo.save(user); // Step 1
        h2Repo.save(detail);  // Step 2

        throw new RuntimeException("Forced crash to test Chained Rollback");
    }
}
