package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
        name = "Directors"
)
public class Director {
    private int id_movie;
    private String name;

    public Director(int id_movie, String name) {
        this.id_movie = id_movie;
        this.name = name;
    }

    public int getId_movie() {
        return id_movie;
    }

    public void setId_movie(int id_movie) {
        this.id_movie = id_movie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id_movie=" + id_movie +
                ", name='" + name + '\'' +
                '}';
    }
}
