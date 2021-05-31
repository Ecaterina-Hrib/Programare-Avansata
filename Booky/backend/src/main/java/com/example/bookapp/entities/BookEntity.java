package com.example.bookapp.entities;

import javax.persistence.*;
import java.util.Comparator;

@Entity
@Table(name = "BOOKS", schema = "STUDENT")
public class BookEntity implements Comparable<BookEntity>{
    @Id
    private Integer id;
    private String title;
    private String author;
    @Id
    @Column(name = "ID_BOOK")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Basic
    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public int compareTo(BookEntity book) {
        return Comparator.comparing(BookEntity::getTitle)
                .thenComparing(BookEntity::getAuthor)
                .compare(this, book);
    }
}
