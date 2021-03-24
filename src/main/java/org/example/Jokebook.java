package org.example;

import java.sql.*;
import java.util.ArrayList;

public class Jokebook {
    private ArrayList<Joke> jokes;

    public Jokebook() {
        super();
        this.jokes = new ArrayList<>();
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

            while(entries.next()) { jokes.add(JokeFiller.createJokeObject(entries));
            }
            printJokes();

            // alle verwendeten Objekte schliessen
            entries.close();
            stmt.close();
            connection.close();


        } catch(ClassNotFoundException e) {e.printStackTrace();
        } catch(
                SQLException e) {e.printStackTrace();
        }


    }



    public  void printJokes(){
        for(Joke a : jokes){
            a.print();
            System.out.println();
        }
    }
}
