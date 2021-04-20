package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
        name = "Movies"
)
public class Movie {
    private int id;
    private String name;
    private String original_name;
    private String release_date;
    private String country;
    private String language;
    private int duration;
    private int score;


    public Movie(int id, String name, String original_name, String release_date, String country, String language, int duration, int score) {
        this.id = id;
        this.name = name;
        this.original_name = original_name;
        this.release_date = release_date;
        this.country = country;
        this.language = language;
        this.duration = duration;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", original_name='" + original_name + '\'' +
                ", release_date='" + release_date + '\'' +
                ", country='" + country + '\'' +
                ", language='" + language + '\'' +
                ", duration=" + duration +
                ", score=" + score +
                '}';
    }
}
