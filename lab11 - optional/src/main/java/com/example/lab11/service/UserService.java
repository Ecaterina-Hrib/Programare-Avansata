package com.example.lab11.service;

import com.example.lab11.entity.UserEntity;
import com.example.lab11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity addUser(UserEntity user) {
        userRepository.save(user);
        return user;
    }

    public UserEntity changeName(long id, String nume) {
        UserEntity user = userRepository.getUserByIdUser(id);
        user.setName(nume);
        userRepository.save(user);
        return user;
    }

    public void deleteUser(long id) {
        UserEntity user = userRepository.getUserByIdUser(id);
        userRepository.deleteUserByIdUser(user.getIdUser());
    }

    public String login(String name) {
        if (userRepository.existsByName(name)) {
            return "Logged in succesfully";
        } else {
        return "The user doesn't exist";}

    }
}
