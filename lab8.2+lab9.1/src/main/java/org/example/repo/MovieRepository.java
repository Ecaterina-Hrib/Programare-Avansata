package org.example.repo;

import org.example.databases.Database;
import org.example.entity.Movie;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Repository se ocupa cu manage la o tabela legat de un entity si aici se fac operatiiunile sql pe baza de date
public class MovieRepository {
    Database database = Database.getInstance();
    Connection conn = database.getConnection();
    Movie movie;

    public MovieRepository() throws SQLException, FileNotFoundException, ClassNotFoundException {
    }

    public MovieRepository(String name) throws SQLException, FileNotFoundException, ClassNotFoundException {
        findByName(name);
    }

    public MovieRepository(int ID, String name, String original_name, String release, String country, String language, int duration, int score) throws SQLException, FileNotFoundException, ClassNotFoundException {
        create(ID,name,original_name,release,country,language,duration,score);
        movie = new Movie(ID,name,original_name,release,country,language,duration,score);
    }
    public void create(int ID, String name, String original_name, String release, String country, String language, int duration, int score) throws SQLException {
        try {
            String query = String.format("insert into Movies(id,name,original_title,release_date,country,language,duration,score) values('%d','%s', '%s','%s','%s','%s','%d','%d')",ID,name,original_name,release,country,language,duration,score);
            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);}
        catch (Exception e) {

        }

    }
    public void findByName(String name) throws SQLException {
        String query = String.format("select * from  Movies  where name LIKE '%s'", name);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id"); //rs.getInt(1)
            String nume = rs.getString("name");
            String original_nume = rs.getString("original_title");
            String release = rs.getString("release_date");
            String country = rs.getString("country");
            String language = rs.getString("language");
            int duration = rs.getInt("duration");
            int score = rs.getInt("score");
            movie = new Movie(id,nume,original_nume,release,country,language,duration,score);

            System.out.println(id + ", " + nume);
        }

    }
}
