package org.example.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static Connection instance;
    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String username = "postgres";
    private static final String password = "formation";

    private DatabaseManager () throws SQLException {
        instance = DriverManager.getConnection(url,username,password);
    }


    public static Connection getConnection() throws SQLException {
        if(instance == null){
            new DatabaseManager();
        }
        return instance;
    }
}
