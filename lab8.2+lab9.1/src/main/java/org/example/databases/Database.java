package org.example.databases;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance;
    private Connection connection;

    private Database() {

        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user= "student";
        String password="STUDENT";

        this.connection = DriverManager.getConnection(url,user,password);}
        catch(Exception e){
            System.out.println("couldn't get db"+e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Database getInstance() throws SQLException, FileNotFoundException, ClassNotFoundException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new Database();
        }
        return instance;
    }
}

