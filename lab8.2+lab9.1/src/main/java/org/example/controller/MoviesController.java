package org.example.controller;

import org.example.databases.Database;
import org.example.repo.MovieRepository;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public class MoviesController {
    Database database = Database.getInstance();
    Connection conn=this.database.getConnection();
    MovieRepository repository=new MovieRepository();

    public MoviesController(String name) throws SQLException, FileNotFoundException, ClassNotFoundException {
    this.findByName(name);
    }
    public MoviesController(int ID, String name, String original_name, String release, String country, String language, int duration, int score) throws SQLException, FileNotFoundException, ClassNotFoundException {
        this.create(ID,name,original_name,release,country,language,duration,score);
    }
    public void create(int ID, String name, String original_name, String release, String country, String language, int duration, int score) throws SQLException {
        this.repository.create(ID,name,original_name,release,country,language,duration,score);
    }

    public void findByName(String name) throws SQLException {
        this.repository.findByName(name);
    }
}
