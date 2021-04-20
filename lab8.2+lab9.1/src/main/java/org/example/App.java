package org.example;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.example.databases.Database;
import org.example.repo.*;
import org.example.databases.Dataset;


/**
 * <p></p>
 *
 */
public class App
{
    public static void main( String[] args ) throws SQLException, FileNotFoundException, ClassNotFoundException {
        Database database = Database.getInstance();
        Connection conn = database.getConnection();
      String query =
                "select *"+ " from "+"Movies";



        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String original_name = rs.getString("original_title");
            String release = rs.getString("release_date");
            String country = rs.getString("country");
            String language = rs.getString("language");
            int duration = rs.getInt("duration");
            int score = rs.getInt("score");
            System.out.println(id + ", " + name + ", " + release+ ", " + duration + ", " +score);
        }

        MovieRepository search= new MovieRepository("Adventures of Tarzan");

      //GenreController genre =  new GenreController(2,"Horror");

    Dataset data = new Dataset();
        System.out.println("Read Data \n");
        //aici includ in baza de date datele din fisierul csv
  //data.readDataLineByLine("C:\\Users\\Khety\\IdeaProjects\\Lab8\\movies.csv");
    }
    }

