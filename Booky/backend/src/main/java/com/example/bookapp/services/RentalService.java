package com.example.bookapp.services;

import com.example.bookapp.entities.RentalEntity;
import com.example.bookapp.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RentalService {
    @Autowired
    RentalRepository rentalRepository;
    public List<RentalEntity> allRentals(){
       return  rentalRepository.findAll();
    }
    public RentalEntity rentAnItem(Integer id ,Integer itemId,Integer clientId){
        if (rentalRepository.findAllByItemIdOrderByRentedDateAsc(itemId).size()<4) {
            RentalEntity checkRental = rentalRepository.findAllByItemIdOrderByRentedDateAsc(itemId)
                    .get(rentalRepository.findAllByItemIdOrderByRentedDateAsc(itemId).size() - 1);
            if (checkRental.getReturnedDate() == null) {
                new RentalEntity().setId(id);
            }
        }
         RentalEntity   rental = new RentalEntity();
            rental.setId(id);
            rental.setItemId(itemId);
            rental.setClientId(clientId);
            rental.setRentedDate(new Date());

            rental = rentalRepository.save(rental);
            return rental;
    }
public RentalEntity returnAnItem(Integer itemId){
    if (!rentalRepository.findAllByItemIdOrderByRentedDateAsc(itemId).isEmpty()) {
        RentalEntity checkRental = rentalRepository.findAllByItemIdOrderByRentedDateAsc(itemId)
                .get(rentalRepository.findAllByItemIdOrderByRentedDateAsc(itemId).size() - 1);
        if (checkRental.getReturnedDate() == null) {
            checkRental.setReturnedDate(new Date());
            checkRental = rentalRepository.save(checkRental);
            return checkRental;
        }
    }
    return new RentalEntity();
}
}
