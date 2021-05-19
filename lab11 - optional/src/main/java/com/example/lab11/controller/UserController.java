package com.example.lab11.controller;

import com.example.lab11.entity.UserEntity;
import com.example.lab11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<UserEntity> getUserList() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public UserEntity putUserName(@PathVariable long id, @RequestParam String name) {
        return userService.changeName(id, name);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/username/{name}")
    public String loginStatus(@PathVariable String name ) {
        return userService.login(name);
    }
}
