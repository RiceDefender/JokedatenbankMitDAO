package org.example.Model;

import org.example.DAO.DataBaseAccessSQL;
import org.example.DAOFactory;
import org.example.DAO.DataBaseAccess;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @Author Nghia Dao
 * 30.03.2021
 */

public class Jokebook extends DAOFactory {
    private ArrayList<Joke> jokes;
    private DataBaseAccessSQL sql;
    public Jokebook(DataBaseAccess dao) throws FileNotFoundException {
        super();
        this.jokes = new ArrayList<>();
        dao.getAllJokes(jokes);
    }


    public  void printJokes(){
        for(Joke a : jokes){
            a.print();
            System.out.println();
        }
    }
}
