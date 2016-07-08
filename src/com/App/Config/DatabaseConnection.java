package com.App.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by forteeninches on 8/07/16.
 */
public class DatabaseConnection {

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/dwitcard";
    private String username = "root";
    private String password = "";
    private Connection connection = null;

    public DatabaseConnection(){

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully Connected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn(){
        return connection;
    }
}
