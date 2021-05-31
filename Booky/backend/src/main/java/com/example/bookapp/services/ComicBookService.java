package com.example.bookapp.services;

import com.example.bookapp.entities.ComicBookEntity;
import com.example.bookapp.repositories.ComicBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class ComicBookService {
    @Autowired
    ComicBookRepository comicBookRepository;
    public List<ComicBookEntity> getAllComicBooks() {
        List<ComicBookEntity> comicBooks = comicBookRepository.findAll();
        if (comicBooks.size() > 0) {
            Collections.sort(comicBooks);
            return comicBooks;
        } else {
            return new ArrayList<>();
        }
    }
    public ComicBookEntity updateComicBook(Integer id, String series, Integer number) {
        ComicBookEntity updatedComicBook = comicBookRepository.getOne(id);
        updatedComicBook.setSeries(series);
        updatedComicBook.setNumber(number);
        updatedComicBook = comicBookRepository.save(updatedComicBook);
        return updatedComicBook;
    }
    public void deleteComicBook(Integer id) {
        comicBookRepository.deleteById(id);
    }

    public List<ComicBookEntity> getComicBookById(String id) {
        List<ComicBookEntity> newComicBookList = comicBookRepository.findAll();
        List<ComicBookEntity> matchesList = new LinkedList<>();
        for (ComicBookEntity comicBook : newComicBookList) {
            if (comicBook.getId().toString().toLowerCase().contains(id.toLowerCase())) {
                matchesList.add(comicBook);
            }
        }
        return matchesList;
    }
    public List<ComicBookEntity> getComicBookBySeries(String series) {
        List<ComicBookEntity> newComicBookList = comicBookRepository.findAll();
        List<ComicBookEntity> matchesList = new LinkedList<>();
        for (ComicBookEntity comicBook : newComicBookList) {
            if (comicBook.getSeries().toLowerCase().contains(series.toLowerCase())) {
                matchesList.add(comicBook);
            }
        }
        return matchesList;
    }
    public List<ComicBookEntity> getComicBookByNumber(String number) {
        List<ComicBookEntity> newComicBookList = comicBookRepository.findAll();
        List<ComicBookEntity> matchesList = new LinkedList<>();
        for (ComicBookEntity comicBook : newComicBookList) {
            if (comicBook.getNumber().toString().toLowerCase().contains(number.toLowerCase())) {
                matchesList.add(comicBook);
            }
        }
        return matchesList;
    }
    public ComicBookEntity addComicBook(ComicBookEntity comicBook, String series, Integer number) {
        comicBook.setSeries(series);
        comicBook.setNumber(number);
        comicBook = comicBookRepository.save(comicBook);
        return comicBook;
    }




}
