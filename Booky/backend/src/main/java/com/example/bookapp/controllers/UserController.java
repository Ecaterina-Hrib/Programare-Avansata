package com.example.bookapp.controllers;

import com.example.bookapp.entities.BookEntity;
import com.example.bookapp.entities.UserEntity;
import com.example.bookapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<UserEntity>> getUserList() {
        List< UserEntity> users=  userService.getAllUsers();
        return new ResponseEntity<>(users, new HttpHeaders(), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity userE = userService.addUser(user);
        return new ResponseEntity<>(userE, new HttpHeaders(), HttpStatus.OK);
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
