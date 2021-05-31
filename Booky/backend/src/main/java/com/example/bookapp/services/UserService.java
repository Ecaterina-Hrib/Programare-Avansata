package com.example.bookapp.services;

import com.example.bookapp.entities.UserEntity;
import com.example.bookapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
