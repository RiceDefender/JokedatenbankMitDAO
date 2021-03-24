package org.example;

import java.security.Principal;
import java.sql.*;

public class Joke {
    private int id;
    private String text;
    private Date date;
    private int rating;
    public Joke() {
        super();
    }
    public void setupJoke(int id, String text, Date date, int rating){
        this.id = id;
        this.text = text;
        this.date = date;
        this.rating = rating;


    }
    public void print(){
        System.out.println("Joke id: " + id + " Date: " + date + " Rating: " + rating + "\n" + text);

    }
}
