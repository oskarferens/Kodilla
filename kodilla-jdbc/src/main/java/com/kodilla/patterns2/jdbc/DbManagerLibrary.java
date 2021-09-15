package com.kodilla.patterns2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManagerLibrary {

    private Connection conn;                                          // [1]
    private static DbManagerLibrary dbManagerInstance;                       // [2]

    private DbManagerLibrary() throws SQLException {                         // [3]
        Properties connectionProps = new Properties();                 // [4]
        connectionProps.put("user", "new_user");                   // [5]   ----
        connectionProps.put("password", "Abcdefghijk41");           // [6]----------
        conn = DriverManager.getConnection(                            // [7]
                "jdbc:mysql://localhost:3306/new_user?serverTimezone=Europe/Warsaw" +  // [8]---------------
                        "&useSSL=False",                                             // [9]
                connectionProps);                                              // [10]
    }                                                                 // [11]

    public static DbManagerLibrary getInstance() throws SQLException {       // [12]
        if (dbManagerInstance == null) {                               // [13]
            dbManagerInstance = new DbManagerLibrary();                        // [14]
        }                                                              // [15]
        return dbManagerInstance;                                      // [16]
    }                                                                 // [17]

    public Connection getConnection() {                               // [18]
        return conn;                                                   // [19]
    }
}
