package com.example.bookapp.controllers;

import com.example.bookapp.entities.BookEntity;
import com.example.bookapp.entities.RentalEntity;
import com.example.bookapp.entities.UserEntity;
import com.example.bookapp.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/rentals")
public class RentalController {
    @Autowired
    RentalService rentalService;
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<RentalEntity>> getUserList() {
        List<RentalEntity> rentals = rentalService.allRentals();
        return new ResponseEntity<>(rentals, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/rent/{id}/{itemId}/{clientId}", method = RequestMethod.POST)
    public ResponseEntity<RentalEntity> rentItem(@PathVariable String id,@PathVariable String itemId, @PathVariable String clientId) {
        RentalEntity newRental = rentalService.rentAnItem(Integer.parseInt(id),Integer.parseInt(itemId), Integer.parseInt(clientId));
        return new ResponseEntity<>(newRental, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path = "/return/{itemId}", method = RequestMethod.POST)
    public ResponseEntity<RentalEntity> returnItem(@PathVariable String itemId) {
        RentalEntity updatedRental = rentalService.returnAnItem(Integer.parseInt(itemId));
        return new ResponseEntity<>(updatedRental, new HttpHeaders(), HttpStatus.OK);
    }
}
