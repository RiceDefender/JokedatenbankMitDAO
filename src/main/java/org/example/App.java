package org.example;

import org.example.Model.Jokebook;

import java.io.IOException;

/**
 * @Author Nghia Dao
 * 30.03.2021
 */
public class App
{
    public static void main( String[] args ) throws IOException{

        ///2021-03-30 19:42:30 Die Datenbankform wird gebraucht(Die Form wie es in ACCESS steht funktioniert nicht)
        DAOFactory factory = new DAOFactory();
        //factory.addJoke();
        Jokebook joke = new Jokebook(factory.getDB("access"));
        joke.printJokes();

        DAOFactory factory1 = new DAOFactory();
        Jokebook joke1 = new Jokebook(factory1.getDB("MDB"));
        joke1.printJokes();

        DAOFactory factory2 = new DAOFactory();
        factory2.deleteJoke();
        factory2.updateJoke();
        Jokebook joke2 = new Jokebook(factory2.getDB("SQL"));
        joke2.printJokes();

        /*
        DAOFactory factory3 = new DAOFactory();
        Jokebook joke3 = new Jokebook(factory3.getDB("CSV"));
        joke2.printJokes();
        */

    }
}
