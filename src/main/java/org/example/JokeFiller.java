package org.example;

import org.example.Joke;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeFiller {
    private static void fillJoke(Joke joke, ResultSet entry) throws SQLException {
        joke.setupJoke(
                entry.getInt("id"),
                entry.getString("text"),
                entry.getDate("date"),
                entry.getInt("rating")
        );
    }

    public static Joke createJokeObject(ResultSet entry) throws SQLException {
        Joke joke1 = new Joke();
        fillJoke(joke1, entry);
        return joke1;

    }
}