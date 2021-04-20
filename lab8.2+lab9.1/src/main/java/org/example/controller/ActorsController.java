package org.example.controller;

import org.example.databases.Database;
import org.example.repo.ActorRepository;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
// Controllers pentru functii din repository pentru manage de entity
public class ActorsController {
    Database database = Database.getInstance();
    Connection conn;
    ActorRepository repository;

    public ActorsController(String name) throws SQLException, FileNotFoundException, ClassNotFoundException {
        this.conn=this.database.getConnection();
        this.findByName(name);
    }
    public ActorsController(int ID, String name) throws SQLException, FileNotFoundException, ClassNotFoundException {
        this.conn = this.database.getConnection();
        this.create(ID,name);
    }

    public ActorsController() throws SQLException, FileNotFoundException, ClassNotFoundException {
    }

    public void create(int ID, String name) throws SQLException {
        this.repository.create(ID,name);
    }

    public void findByName(String name) throws SQLException {
        this.repository.findByName(name);
    }
}
