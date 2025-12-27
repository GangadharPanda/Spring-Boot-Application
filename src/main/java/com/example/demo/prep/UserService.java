package com.example.demo.prep;

import com.example.demo.modal.UserDTO;
import com.example.demo.prep.primarydb.entities.User;
import com.example.demo.prep.primarydb.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
