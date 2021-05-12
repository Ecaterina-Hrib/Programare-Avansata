package com.example.lab11.service;

import com.example.lab11.entity.UserEntity;
import com.example.lab11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
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
}
