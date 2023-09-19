package JavaDB;

import java.sql.*;

public class databaseConnect {
    public static void main(String[] args) {
        
        String database = "jdbc:mariadb://192.168.1.3:3306/javadb_movies";
        String user = "javadb";
        String pass = "password";

        String query = "INSERT INTO movie (name, rating, studio, director) VALUES ('up', 20, 'Pixar', 'A. Genius')";

        Statement stmt = null;

        try {
            Connection conn = DriverManager.getConnection(database, user, pass);
            stmt = conn.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException err) {
            System.out.println("ERROR " + err.getMessage());
        } 


        query = "SELECT * FROM movie";

           try {
            Connection conn = DriverManager.getConnection(database, user, pass);
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(query);
            while (results.next()){
                System.out.println("movie " + results.getString("name") + " was directed by " + results.getString("director") + " it is rated as " + results.getInt("rating") + " it was produced by " + results.getString("Studio"));
            }
        } catch (SQLException err) {
            System.out.println("ERROR " + err.getMessage());
        } 
        


    }
}
