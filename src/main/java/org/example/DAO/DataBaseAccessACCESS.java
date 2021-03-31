package org.example.DAO;

import org.example.Model.Joke;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Nghia Dao
 * 30.03.2021
 */
public class DataBaseAccessACCESS implements DataBaseAccess {

    public DataBaseAccessACCESS() {

    }


    @Override
    public void getAllJokes(ArrayList<Joke> jokes) {
        try {
            System.out.println("HELLO WORLDO ACSESS VERSION");
            String connectionUrl = "jdbc:ucanaccess://src/JokeDB.accdb"; //
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement stmt = connection.createStatement();
            ResultSet entries = stmt.executeQuery("SELECT * FROM joke");

            while (entries.next()) {
                jokes.add(JokeFillerACCESS.createJokeObject(entries));
            }
            // alle verwendeten Objekte schliessen
            entries.close();
            stmt.close();
            connection.close();


        } catch (
                SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void addNewEntity() throws IOException {
        try {
            int id = 6;
            String connectionUrl = "jdbc:ucanaccess://src/JokeDB.accdb";
            Connection connection = DriverManager.getConnection(connectionUrl);

            //Ab hier ergänzen

            System.out.println("Datei hinzufügen für ACCESS");
            Scanner jokein = new Scanner(System.in);
            System.out.println("Enter Joke");
            String jokeinS = jokein.nextLine();
            Scanner datein = new Scanner(System.in);
            System.out.println("Enter Date");
            String dateinS = datein.nextLine();
            Scanner ratingin = new Scanner(System.in);
            System.out.println("Enter Rating");
            String ratinginS = ratingin.nextLine();
            String sql = "INSERT INTO joke(jokeid, content, date, rating) VALUES(?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id );
            id++;
            stmt.setString(2, jokeinS);
            stmt.setString(3, dateinS);
            stmt.setString(4, ratinginS);

            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted > 0 ? "" : "A new joke was inserted sucsessfully");


            // alle verwendeten Objekte schliessen
            stmt.close();
            connection.close();

            System.out.println("Joke wurde erstellt");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

