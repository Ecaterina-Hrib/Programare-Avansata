package com.example.bookapp.entities;

import javax.persistence.*;
import java.util.Comparator;

@Entity
@Table(name = "COMIC_BOOKS", schema = "STUDENT")
public class ComicBookEntity implements Comparable<ComicBookEntity> {

    private Integer id;
    private String series;
    private Integer number;

    @Id
    @Column(name = "ID_BOOK")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column(name = "SERIES")
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
    @Basic
    @Column(name = "NUMBER_SERIES")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public int compareTo(ComicBookEntity comicBook) {
        return Comparator.comparing(ComicBookEntity::getSeries)
                .thenComparing(ComicBookEntity::getNumber)
                .compare(this, comicBook);
    }
}
