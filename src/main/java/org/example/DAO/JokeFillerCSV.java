package org.example.DAO;

import org.example.Model.Joke;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeFillerCSV {
    private int id;
    private String text;
    private String date;
    private int rating;

       public JokeFillerCSV (){

        }
        public JokeFillerCSV(int id,String text, String date, int rating){
           this.id = id;
           this.text = text;
           this.date = date;
           this.rating = rating;


    }
}
