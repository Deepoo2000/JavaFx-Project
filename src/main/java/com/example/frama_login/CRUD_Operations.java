package com.example.frama_login;

import java.sql.*;

public class CRUD_Operations {

    public DB_ConnectionSingleton db_connectionSingleton = DB_ConnectionSingleton.getDb_connectionSingleton();
    public Connection connection = this.db_connectionSingleton.openConnectionSingleton();

    public CRUD_Operations() {
    }

    public int Insert(String f_name ,String f_username, String f_password,String f_email,String f_birthday)
            throws SQLException, ClassNotFoundException {
        Statement statement = this.connection.createStatement();
        int result = statement.executeUpdate("insert into storedata set " +
                "name = "     + "'" + f_name     + "'," +
                        "username = " + "'" + f_username + "'," +
                        "password = " + "'" + f_password + "'," +
                        "email = "    + "'" + f_email    + "'," +
                        "birthday = " + "'" + f_birthday + "';");
        if(SearchEmail(f_email) > 0 && result > 0)return 1;
        return 0;
    }
    public int Search(String f_email,String f_password)throws SQLException {
        Statement statement = this.connection.createStatement();
        //int result = statement.executeUpdate("select * from storedata where email = " + "'" + f_email + "';");
        ResultSet result = statement.executeQuery("select * from storedata where email = " + "'" + f_email
                + "' and " + "password = " + "'" + f_password + "';" );
        // select * from storedata
        if(result.next()) return 1;
        return 0;
    }
    public int SearchEmail(String f_email)throws SQLException {
        Statement statement = this.connection.createStatement();
        //int result = statement.executeUpdate("select * from storedata where email = " + "'" + f_email + "';");
        ResultSet result = statement.executeQuery("select * from storedata where email = " + "'" +
                f_email +  "';" );
        // select * from storedata
        if(result.next()) return 1;
        return 0;
    }
    public void Delete(String f_name)
            throws SQLException, ClassNotFoundException {
        Statement statement = this.connection.createStatement();
        String sql ="delete from storedata where " +
                "name = "     + "'" + f_name     + "';";
        statement.executeUpdate(sql);

    }
    public void Update(String f_name ,String f_username, String f_password,String f_email,String f_birthday)
            throws SQLException {
        Statement statement = this.connection.createStatement();
        String sql ="update storedata set " +
                "name = "     + "'" + f_name     + "'," +
                "username = " + "'" + f_username + "'," +
                "password = " + "'" + f_password + "'," +
                "birthday = " + "'" + f_birthday + "'"  +
                "where email = " + "'" + f_email + "';";
        statement.executeUpdate(sql);
    }


}
