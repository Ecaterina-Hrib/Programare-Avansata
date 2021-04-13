package org.example.classes;

import org.example.databases.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Genre {

    Database database = Database.getInstance();
    Connection conn = database.getConnection();
    public Genre(String name) throws SQLException {
        findByName(name);
    }
    public Genre(String id, String name) throws SQLException {
        create(id, name);
    }
    void create(String id, String name) throws SQLException {
        try {
            String query = String.format("insert into Genres(id_genre,name) values('%s', '%s')", id, name);
            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);}
        catch (Exception e) {

        }

    }
    void findByName(String name) throws SQLException {
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
