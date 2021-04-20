package org.example.controller;

import org.example.databases.Database;
import org.example.repo.GenreRepository;
import org.example.repo.MovieRepository;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public class GenresController {
    Database database = Database.getInstance();
    Connection conn;
    GenreRepository repository;

    public GenresController(String name) throws SQLException, FileNotFoundException, ClassNotFoundException {
        this.conn=this.database.getConnection();
        this.findByName(name);
    }
    public GenresController(int ID, String name) throws SQLException, FileNotFoundException, ClassNotFoundException {
        this.conn = this.database.getConnection();
        this.create(ID,name);
    }
    public void create(int ID, String name) throws SQLException {
        this.repository.create(ID,name);
    }

    public void findByName(String name) throws SQLException {
        this.repository.findByName(name);
    }
}
