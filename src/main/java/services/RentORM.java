package services;

import models.Rent;

import java.sql.*;

public class RentORM {
    private Connection connection;

    public RentORM(Connection connection) {
        this.connection = connection;
    }

    public void save(Rent rent) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO rents (client_id, bicycle_id, shop_id, take_date, return_date) VALUES (?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, rent.getClientId());
        statement.setInt(2, rent.getBicycleId());
        statement.setInt(3, rent.getShopId());
        statement.setDate(4, rent.getTakeDate());
        statement.setDate(5, rent.getReturnDate());
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            rent.setId(generatedKeys.getInt(1));
        }
    }

    public Rent getById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM rents WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int clientId = resultSet.getInt("client_id");
            int bicycleId = resultSet.getInt("bicycle_id");
            int shopId = resultSet.getInt("shop_id");
            Date takeDate = resultSet.getDate("take_date");
            Date returnDate = resultSet.getDate("return_date");
            return new Rent(
                    resultSet.getInt("id"),
                    clientId,
                    bicycleId,
                    shopId,
                    takeDate,
                    returnDate
            );
        }
        return null;
    }

    public void update(Rent rent) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE rents SET client_id = ?, bicycle_id = ?, shop_id = ?, take_date = ?, return_date = ? WHERE id = ?");
        statement.setInt(1, rent.getClientId());
        statement.setInt(2, rent.getBicycleId());
        statement.setInt(3, rent.getShopId());
        statement.setDate(4, rent.getTakeDate());
        statement.setDate(5, rent.getReturnDate());
        statement.setInt(6, rent.getId());
        statement.executeUpdate();
    }

    public void delete(Rent rent) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM rents WHERE id = ?");
        statement.setInt(1, rent.getId());
        statement.executeUpdate();
    }
}