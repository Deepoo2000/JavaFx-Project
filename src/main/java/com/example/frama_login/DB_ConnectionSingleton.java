package com.example.frama_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB_ConnectionSingleton {
    public static Statement statement =null;
    public static DB_ConnectionSingleton db_connectionSingleton = null;

    public static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/facebook";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String password = "root";

    private DB_ConnectionSingleton() {

    }

    // to take one object from connection
    public static DB_ConnectionSingleton getDb_connectionSingleton()
    {
        if(db_connectionSingleton == null)
            db_connectionSingleton = new DB_ConnectionSingleton();
        return db_connectionSingleton;
    }
    // open connection
    public Connection openConnectionSingleton()  {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    //close connection
    public void closeConnectionSingleton() throws SQLException {
        try {
            connection.close();
        }
        catch (SQLException s){
            System.out.println("Error...");
        }

    }

    public static DB_ConnectionSingleton  StatmentInstance(){
        if(statement == null)statement = (Statement) new DB_ConnectionSingleton();
        return (DB_ConnectionSingleton) statement;
    }
}
