package com.example.bookapp.repositories;

import com.example.bookapp.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {
    List<BookEntity> findAll();
    <Book extends BookEntity> Book save(Book entity);
    BookEntity getByAuthor(String author);
    BookEntity getById(Long id);
    List<BookEntity> getByIdOrderById(Long id);
    void deleteById(Integer id);
    void deleteBookEntitiesByAuthor(String author);
    void deleteBookEntityByTitle(String title);
}
