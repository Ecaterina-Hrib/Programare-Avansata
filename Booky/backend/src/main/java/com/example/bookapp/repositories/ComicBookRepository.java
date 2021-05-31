package com.example.bookapp.repositories;

import com.example.bookapp.entities.ComicBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComicBookRepository extends JpaRepository<ComicBookEntity, Integer> {
    List<ComicBookEntity> findAll();
}
