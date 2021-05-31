package com.example.bookapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @GetMapping("/")
    public String demoPage() {
        return "Welcome to my BookyApp";
    }

}