package org.example.Model;

import java.security.Principal;
import java.sql.*;

/**
 * @Author Nghia Dao
 * 30.03.2021
 */
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

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public int getRating() {
        return rating;
    }
}
