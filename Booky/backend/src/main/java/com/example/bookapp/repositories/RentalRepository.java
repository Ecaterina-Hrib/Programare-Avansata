package com.example.bookapp.repositories;

import com.example.bookapp.entities.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  RentalRepository extends JpaRepository<RentalEntity,Integer> {
    List<RentalEntity> findAllByItemIdOrderByRentedDateAsc(Integer itemId);
    List<RentalEntity> findAll();
    List<RentalEntity> findAllByClientId(Long ClientId);

}
