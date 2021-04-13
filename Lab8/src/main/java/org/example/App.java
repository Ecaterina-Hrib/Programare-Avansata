package org.example;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.example.databases.Database;
import org.example.classes.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Database database = Database.getInstance();
        Connection conn = database.getConnection();
        String query =
                "select * " + "from " + " Movies";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String release = rs.getString("release_date");
            String duration = rs.getString("duration");
            String score = rs.getString("score");
            System.out.println(id + ", " + name + ", " + release+ ", " + duration + ", " +score);
        }

        new Movie("Des Rocs","12","12/12/2012","200","98/100");
        new Genre("3","Drama");
    }
    }
}
