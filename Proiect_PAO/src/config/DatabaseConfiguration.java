package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
    private final Connection databaseConnection;

    public DatabaseConfiguration(){
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/liceu";
            String user = "root";
            String password = "proiectjava";
            databaseConnection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        return databaseConnection;
    }
}
