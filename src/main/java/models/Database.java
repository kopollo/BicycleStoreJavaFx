package models;

import java.sql.*;

public class Database {
    private final Connection connection;

    public Database(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public Connection open() {
        return connection;
    }

    public void close() throws SQLException {
        connection.close();
    }
}
