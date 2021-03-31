package org.example;


import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import org.example.DAO.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author Nghia Dao
 * 30.03.2021
 */
public class DAOFactory {


    public DataBaseAccess getDB(String db) {
        if (db.equals("access")) {
            return new DataBaseAccessACCESS();
        } else if (db.equals("MDB")) {
            return new DataBaseAccessMDB();
        }
        else if (db.equals("CSV")){
            return new DataBaseAccessCSV();
        }
        else//else if(db.equals("SQL"))
            return new DataBaseAccessSQL();
    }

    public void addJoke() {
        DataBaseAccessACCESS accessJokeadd = new DataBaseAccessACCESS();
        DataBaseAccessSQL sqlJokeadd = new DataBaseAccessSQL();
        DataBaseAccessMDB mdbJokeadd = new DataBaseAccessMDB();
        try {
            accessJokeadd.addNewEntity();
        } catch (Exception e) {
            System.out.println("Es wurde keine Datei in access hinzugefügt");
        }
        try {
            sqlJokeadd.addNewEntity();
        } catch (MysqlDataTruncation f) {
            System.out.println("Es wurde keine Datei in SQL hinzugefügt/Daten wurden falsch eingefügt");
        } catch (Exception e) {
            System.out.println("Es wurde keine Datei in SQL hinzugefügt");
        }
        try {
            mdbJokeadd.addNewEntity();
        } catch (Exception e) {
            System.out.println("Es wurde keine Datei in MDB hinzugefügt/Daten wurden falsch eingefügt");
        }
    }

    public void updateJoke() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:6603/joke";
            Connection connection = DriverManager.getConnection(connectionUrl, "root", "1234");
            String sql = "UPDATE joke SET text = ?, rating = ?, date = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            System.out.println("Datei Updaten für SQL");
            Scanner jokein = new Scanner(System.in);
            System.out.println("Enter ID");
            int id = jokein.nextInt();
            Scanner content = new Scanner(System.in);
            System.out.println("Enter Joke");
            String jokeinS = content.nextLine();
            Scanner datein = new Scanner(System.in);
            System.out.println("Enter Date");
            String dateinS = datein.nextLine();
            Scanner ratingin = new Scanner(System.in);
            System.out.println("Enter Rating");
            int ratinginI = ratingin.nextInt();
            stmt.setInt(4, id);
            stmt.setString(1, jokeinS);
            stmt.setString(3, dateinS);
            stmt.setInt(2, ratinginI);
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) System.out.println("A Joke Updated in SQL");
            stmt.close();
            connection.close();
        }

        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    public void deleteJoke() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:6603/joke";
            Connection connection = DriverManager.getConnection(connectionUrl, "root", "1234");
            String sql = "DELETE FROM joke WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            System.out.println("Datei Löschen für SQL");
            Scanner jokein = new Scanner(System.in);
            System.out.println("Enter ID");
            int id = jokein.nextInt();
            stmt.setInt(1, id);
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) System.out.println("A Joke deleted in SQL");
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


}
