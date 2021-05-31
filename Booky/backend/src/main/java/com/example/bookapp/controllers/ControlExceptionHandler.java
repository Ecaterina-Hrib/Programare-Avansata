package com.example.bookapp.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.http.HttpResponse;

@RestControllerAdvice
public class ControlExceptionHandler {
//    @ExceptionHandler(value={Exception.class})
//    @ResponseStatus (value = HttpStatus.NOT_FOUND)
    public ResponseEntity<String> resourceNotFoundException()
    {
        return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(value={Exception.class})
//    @ResponseStatus (value = HttpStatus.NOT_FOUND)
    public ResponseEntity<String> notEnoughResources()
    {
        return new ResponseEntity<>("Not enough resources for your request", HttpStatus.BAD_REQUEST);
    }
}
