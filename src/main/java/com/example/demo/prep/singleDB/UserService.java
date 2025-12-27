package com.example.demo.prep.singleDB;

import com.example.demo.modal.UserDTO;
import com.example.demo.prep.singleDB.primarydb.entities.User;
import com.example.demo.prep.singleDB.primarydb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired(required = false)
    UserRepository userRepository;

    public List<UserDTO> getAllPrimaryUser() {
        return toDTOs(userRepository.findAll());
    }

    private List<UserDTO> toDTOs(List<User> all) {
        List<UserDTO> results = new ArrayList<>(all.size());
        for (User user : all) {
            UserDTO result = new UserDTO(user.getId(), user.getName());
            results.add(result);
        }
        return results;
    }
}
