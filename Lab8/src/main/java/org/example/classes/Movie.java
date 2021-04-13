package org.example.classes;

import org.example.databases.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Movie {
    Database database = Database.getInstance();
    Connection conn = database.getConnection();
    public Movie(String name) throws SQLException {
        findByName(name);
    }

    public Movie(String name, String ID,String release,String duration,String score) throws SQLException {
        create(ID,name,release,duration,score);
    }
    void create(String ID, String name, String release_date,String duration,String score) throws SQLException {
        try {
            String query = String.format("insert into Movies(id,name,relese_date,duration,score) values('%s', '%s')",ID,name,release_date,duration,score);
            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);}
        catch (Exception e) {

        }

    }
    void findByName(String name) throws SQLException {
        String query = String.format("select * from  Movies  where NAME LIKE '%s'", name);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id"); //rs.getInt(1)
            String nume = rs.getString("name");
            String country = rs.getString("country");
            System.out.println(id + ", " + nume + ", " + country);
        }

    }
}
