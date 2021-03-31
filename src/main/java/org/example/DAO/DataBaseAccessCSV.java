package org.example.DAO;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import org.example.Model.Joke;
import org.hsqldb.types.TimestampData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.*;
import java.util.Scanner;

public class DataBaseAccessCSV implements DataBaseAccess{
    private Object TimestampData;

    @Override
    public void getAllJokes(ArrayList<Joke> jokes)  {
        try {
            int counter = 0;
            int save1 = 0;
            String save2 = "";
            //Date save3 = new Date(2018-02-24) 17:48:00);
            Scanner scan = new Scanner(new File("D:\\BBW\\Modul 151\\JokedatenbankMitDAO\\src\\Joke.csv"));
            scan.useDelimiter(",");
            while (scan.hasNext()) {
                if (counter % 4 == 4) {
                    //okeFillerCSV jokecsv = new JokeFillerCSV(save1, save2, save3, scan.nextInt());

                    //jokes.add(new Joke().setupJoke(save1,save2,save3, scan.nextInt())));
                } else if (counter % 4 == 0) {
                    save1 = scan.nextInt();
                } else if (counter % 4 == 1) {
                    save2 = scan.nextLine();
                } else if (counter % 4 == 2) {
                    //save3 = scan.();
                }
            }
            scan.close();
        }
        catch (FileNotFoundException e){

        }
    }

    @Override
    public void addNewEntity() throws IOException, MysqlDataTruncation {

    }
}
