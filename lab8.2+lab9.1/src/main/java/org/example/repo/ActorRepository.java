package org.example.repo;

import org.example.databases.Database;
import org.example.entity.Actor;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Repository se ocupa cu manage la o tabela legat de un entity si aici se fac operatiiunile sql pe baza de date
public class ActorRepository {
    Database database = Database.getInstance();
    Connection conn = database.getConnection();
    Actor actor;
    public ActorRepository(String name) throws SQLException, FileNotFoundException, ClassNotFoundException {
        findByName(name);
    }
    public ActorRepository(int ID, String name) throws SQLException, FileNotFoundException, ClassNotFoundException {
        create(ID,name);
        actor = new Actor(ID,name);
    }
    public void create(int ID, String name) throws SQLException {
        try {
            String query = String.format("insert into Actors(id_movie,name) values('%d','%s')",ID,name);
            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);}
        catch (Exception e) {

        }

    }
    public void findByName(String name) throws SQLException {
        String query = String.format("select * from  Actors where NAME LIKE '%s'", name);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id"); //rs.getInt(1)
            String nume = rs.getString("name");
            System.out.println(id + ", " + nume);
        }

    }
}
