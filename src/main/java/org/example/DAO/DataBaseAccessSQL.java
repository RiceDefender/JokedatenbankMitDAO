package org.example.DAO;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import org.example.Model.Joke;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBaseAccessSQL implements DataBaseAccess {
    /**
     * @Author Nghia Dao
     * 30.03.2021
     */

    public DataBaseAccessSQL(){

    }
    @Override
    public void getAllJokes(ArrayList<Joke> jokes) {
        try{
            System.out.println("HELLO WORLDO");
            // Driver class für MySql-Datenbankladen
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Verbindung zur Datenbank herstellen
            String connectionUrl= "jdbc:mysql://localhost:6603/joke";
            Connection connection= DriverManager.getConnection(connectionUrl, "root", "1234");
            // Sql Befehl aufbauen und ausführen
            Statement stmt= connection.createStatement();
            ResultSet entries= stmt.executeQuery("SELECT * FROM joke");
            // alle Datensätze aus dem ResultSet auslesen und
            // (Schritt 1) in einer ArrayList ablegen

            while(entries.next()) { jokes.add(JokeFillerSQL.createJokeObject(entries));
            }
            // alle verwendeten Objekte schliessen
            entries.close();
            stmt.close();
            connection.close();


        } catch(ClassNotFoundException e) {e.printStackTrace();
        } catch(
                SQLException e) {e.printStackTrace();
        }
    }
    public void addNewEntity() throws MysqlDataTruncation, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:6603/joke";
            Connection connection = DriverManager.getConnection(connectionUrl, "root", "1234");

            //Ab hier ergänzen

            System.out.println("Datei hinzufügen für SQL");
            Scanner jokein = new Scanner(System.in);
            System.out.println("Enter Joke");
            String jokeinS = jokein.nextLine();
            Scanner datein = new Scanner(System.in);
            System.out.println("Enter Date");
            String dateinS = datein.nextLine();
            Scanner ratingin = new Scanner(System.in);
            System.out.println("Enter Rating");
            int ratinginS = ratingin.nextInt();
            String sql ="INSERT INTO joke(text, date, rating) VALUES(?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, jokeinS);
            stmt.setString(2, dateinS);
            stmt.setInt(3, ratinginS);

            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted > 0 ? "" : "A new joke was inserted sucsessfully");


            // alle verwendeten Objekte schliessen
            stmt.close();
            connection.close();

            System.out.println("Joke wurde erstellt");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


