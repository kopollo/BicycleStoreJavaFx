package services;

import models.BicycleModel;

import java.sql.*;

public class BicycleModelORM {
    private Connection connection;

    public BicycleModelORM(Connection connection) {
        this.connection = connection;
    }

    public void save(BicycleModel bicycleModel) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO bicycle_models (name, num_of_gears, type) VALUES (?, ?, ?)");
        statement.setString(1, bicycleModel.getName());
        statement.setInt(2, bicycleModel.getNumOfGears());
        statement.setString(3, bicycleModel.getType());
        statement.executeUpdate();
    }

    public BicycleModel getById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM bicycle_models WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new BicycleModel(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("num_of_gears"),
                    resultSet.getString("type")
            );
        }
        return null;
    }

    public void update(BicycleModel bicycleModel) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE bicycle_models SET name = ?, num_of_gears = ?, type = ? WHERE id = ?");
        statement.setString(1, bicycleModel.getName());
        statement.setInt(2, bicycleModel.getNumOfGears());
        statement.setString(3, bicycleModel.getType());
        statement.setInt(4, bicycleModel.getId());
        statement.executeUpdate();
    }

    public void delete(BicycleModel bicycleModel) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM bicycle_models WHERE id = ?");
        statement.setInt(1, bicycleModel.getId());
        statement.executeUpdate();
    }
}