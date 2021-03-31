package org.example.DAO;

import org.example.Model.Joke;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author Nghia Dao
 * 30.03.2021
 */
public class JokeFillerACCESS {
    private static void fillJoke(Joke joke, ResultSet entry) throws SQLException {
        joke.setupJoke(
                entry.getInt("jokeid"),
                entry.getString("content"),
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
