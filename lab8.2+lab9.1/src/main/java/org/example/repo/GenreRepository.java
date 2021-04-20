package org.example.repo;

import org.example.databases.Database;
import org.example.entity.Genre;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenreRepository {

    Database database = Database.getInstance();
    Connection conn = database.getConnection();
    Genre genre;
    public GenreRepository(String name) throws SQLException, FileNotFoundException, ClassNotFoundException {
        findByName(name);
    }
    public GenreRepository(int id, String name) throws SQLException, FileNotFoundException, ClassNotFoundException {
        create(id, name);
        genre = new Genre(id,name);
    }
    public void create(int id, String name) throws SQLException {
        try {
            String query = String.format("insert into Genres(id,name) values('%d', '%s')", id, name);
            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);}
        catch (Exception e) {

        }

    }
    public void findByName(String name) throws SQLException {
        String query = String.format("select * from  Genres  where NAME LIKE '%s'", name);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String id = rs.getString("id"); //rs.getInt(1)
            String nume = rs.getString("name");
            System.out.println(id + ", " + nume );
        }

    }

}
