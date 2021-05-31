package com.example.bookapp.services;
import com.example.bookapp.entities.BookEntity;
import com.example.bookapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<BookEntity> getAllBooks() {
        List<BookEntity> books = bookRepository.findAll();
        if (books.size() > 0) {
            Collections.sort(books);
            return books;
        } else {
            return new ArrayList<>();
        }
    }
    public BookEntity updateBook(Integer id, String title, String author) {
        BookEntity updatedBook = bookRepository.getOne(id);
        updatedBook.setTitle(title);
        updatedBook.setAuthor(author);
        updatedBook = bookRepository.save(updatedBook);
        return updatedBook;
    }
    public BookEntity addBook(BookEntity book, String title, String author) {
        book.setTitle(title);
        book.setAuthor(author);
        book = bookRepository.save(book);
        return book;
    }
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
    public List<BookEntity> getBookById(String id) {
        List<BookEntity> newBookList = bookRepository.findAll();
        List<BookEntity> matchesList = new LinkedList<>();
        for (BookEntity book : newBookList) {
            if (book.getId().toString().toLowerCase().contains(id.toLowerCase())) {
                matchesList.add(book);
            }
        }
        return matchesList;
    }
    public List<BookEntity> getBookByTitle(String title) {
        List<BookEntity> newBookList = bookRepository.findAll();
        List<BookEntity> matchesList = new LinkedList<>();
        for (BookEntity book : newBookList) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matchesList.add(book);
            }
        }
        return matchesList;
    }
    public List<BookEntity> getBookByAuthor(String author) {
        List<BookEntity> newBookList = bookRepository.findAll();
        List<BookEntity> matchesList = new LinkedList<>();
        for (BookEntity book : newBookList) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                matchesList.add(book);
            }
        }
        return matchesList;
    }

}
