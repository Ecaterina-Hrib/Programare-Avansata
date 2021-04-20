package org.example.controller;

import org.example.databases.Database;
import org.example.repo.DirectorRepository;
import org.example.repo.GenreRepository;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public class DirectorsController {
    Database database = Database.getInstance();
    Connection conn;
    DirectorRepository repository;

    public DirectorsController(String name) throws SQLException, FileNotFoundException, ClassNotFoundException {
        this.conn=this.database.getConnection();
        this.findByName(name);
    }
    public DirectorsController(int ID, String name) throws SQLException, FileNotFoundException, ClassNotFoundException {
        this.conn = this.database.getConnection();
        this.create(ID,name);
    }

    public DirectorsController() throws SQLException, FileNotFoundException, ClassNotFoundException {
    }

    public void create(int ID, String name) throws SQLException {
        this.repository.create(ID,name);
    }

    public void findByName(String name) throws SQLException {
        this.repository.findByName(name);
    }
}
