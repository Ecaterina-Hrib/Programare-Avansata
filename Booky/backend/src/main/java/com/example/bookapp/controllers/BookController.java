package com.example.bookapp.controllers;
import com.example.bookapp.entities.BookEntity;
import com.example.bookapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<BookEntity>> getBooks() {
        List<BookEntity> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<BookEntity>> getBookById(@PathVariable String id) {
        List<BookEntity> books = bookService.getBookById(id);
        return new ResponseEntity<>(books, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path = "/title/{title}", method = RequestMethod.GET)
    public ResponseEntity<List<BookEntity>> getBookByTitle(@PathVariable String title) {
        List<BookEntity> books = bookService.getBookByTitle(title);
        return new ResponseEntity<>(books, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/author/{author}", method = RequestMethod.GET)
    public ResponseEntity<List<BookEntity>> getBookByAuthor(@PathVariable String author) {
        List<BookEntity> books = bookService.getBookByAuthor(author);
        return new ResponseEntity<>(books, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity book) {
        BookEntity newBook = bookService.addBook(book, book.getTitle(), book.getAuthor());
        return new ResponseEntity<>(newBook, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BookEntity> updateBook(@PathVariable String id, @RequestBody BookEntity book) {
        BookEntity updatedBook = bookService.updateBook(Integer.parseInt(id), book.getTitle(), book.getAuthor());
        return new ResponseEntity<>(updatedBook, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<BookEntity> deleteBook(@PathVariable String id) {
        bookService.deleteBook(Integer.parseInt(id));
        return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.OK);
    }
}
