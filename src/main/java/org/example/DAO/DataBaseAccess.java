package org.example.DAO;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import org.example.Model.Joke;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author Nghia Dao
 * 30.03.2021
 */
public interface DataBaseAccess {
    void getAllJokes(ArrayList<Joke> jokes) throws FileNotFoundException;
    void addNewEntity() throws IOException, MysqlDataTruncation;
}
