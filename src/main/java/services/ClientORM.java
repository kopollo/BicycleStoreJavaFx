package services;

import models.Client;

import java.sql.*;
import java.util.ArrayList;

public class ClientORM {
    private Connection connection;

    public ClientORM(Connection connection) {
        this.connection = connection;
    }

    public void save(Client client) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO clients (passport, name, address) VALUES (?, ?, ?)");
        statement.setString(1, client.getPassport());
        statement.setString(2, client.getName());
        statement.setString(3, client.getAddress());
        statement.executeUpdate();
    }

    public Client getById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM clients WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Client(
                    resultSet.getInt("id"),
                    resultSet.getString("passport"),
                    resultSet.getString("name"),
                    resultSet.getString("address")
            );
        }
        return null;
    }

    public ArrayList<Client> getAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM clients");
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Client> clients = new ArrayList<>();
        while (resultSet.next()) {
            clients.add(new Client(
                    resultSet.getInt("id"),
                    resultSet.getString("passport"),
                    resultSet.getString("name"),
                    resultSet.getString("address")
            ));
        }
        return clients;
    }

    public void update(Client client) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE clients SET passport = ?, name = ?, address = ? WHERE id = ?");
        statement.setString(1, client.getPassport());
        statement.setString(2, client.getName());
        statement.setString(3, client.getAddress());
        statement.setInt(4, client.getId());
        statement.executeUpdate();
    }

    public void delete(Client client) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM clients WHERE id = ?");
        statement.setInt(1, client.getId());
        statement.executeUpdate();
    }
}