package com.example.bookapp.controllers;

import com.example.bookapp.entities.ComicBookEntity;
import com.example.bookapp.services.ComicBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comicBooks")
public class ComicBookController {
    @Autowired
    private ComicBookService comicBookService;
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<ComicBookEntity>> getComicBooks() {
        List<ComicBookEntity> comicBooks = comicBookService.getAllComicBooks();
        return new ResponseEntity<>(comicBooks, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ComicBookEntity>> getComicBookById(@PathVariable String id) {
        List<ComicBookEntity> comicBooks = comicBookService.getComicBookById(id);
        return new ResponseEntity<>(comicBooks, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/series/{series}", method = RequestMethod.GET)
    public ResponseEntity<List<ComicBookEntity>> getComicBookBySeries(@PathVariable String series) {
        List<ComicBookEntity> comicBooks = comicBookService.getComicBookBySeries(series);
        return new ResponseEntity<>(comicBooks, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path = "/number/{number}", method = RequestMethod.GET)
    public ResponseEntity<List<ComicBookEntity>> getComicBookByNumber(@PathVariable String number) {
        List<ComicBookEntity> comicBooks = comicBookService.getComicBookByNumber(number);
        return new ResponseEntity<>(comicBooks, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<ComicBookEntity> createComicBook(@RequestBody ComicBookEntity comicBook) {
        ComicBookEntity newComicBook = comicBookService.addComicBook(comicBook, comicBook.getSeries(), comicBook.getNumber());
        return new ResponseEntity<>(newComicBook, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ComicBookEntity> updateComicBook(@PathVariable String id, @RequestBody ComicBookEntity comicBook) {
        ComicBookEntity updatedComicBook = comicBookService.updateComicBook(Integer.parseInt(id), comicBook.getSeries(), comicBook.getNumber());
        return new ResponseEntity<>(updatedComicBook, new HttpHeaders(), HttpStatus.OK);
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ComicBookEntity> deleteComicBook(@PathVariable String id) {
        comicBookService.deleteComicBook(Integer.parseInt(id));
        return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.OK);
    }

}
