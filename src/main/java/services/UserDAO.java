package services;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User getUserById(int id) throws SQLException {
        String query = "SELECT * FROM users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String passport = resultSet.getString("passport");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");

            return new User(id, passport, name, address, password, role);
        }

        return null;
    }

    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO users (passport, name, address, password, role) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getPassport());
        statement.setString(2, user.getName());
        statement.setString(3, user.getAddress());
        statement.setString(4, user.getPassword());
        statement.setString(5, user.getRole());
        statement.execute();
    }

//    public void updateUser(User user) throws SQLException {
//        String query = "UPDATE users SET passport = ?, name = ?, address = ?, password = ?, role = ? WHERE id = ?";
//        PreparedStatement statement = connection.prepareStatement(query);
//        statement.setString(1, user.getPassport());
//        statement.setString(2, user.getName());
//        statement.setString(3, user.getAddress());
//        statement.setString(4, user.getPassword());
//        statement.setString(5, user.getRole());
//        statement.setInt(6, user.getId());
//        statement.executeUpdate();
//    }

    public void deleteUser(int id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.execute();
    }
}
