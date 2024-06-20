package services;

import models.Bicycle;

import java.sql.*;

public class BicycleORM {
    private Connection connection;

    public BicycleORM(Connection connection) {
        this.connection = connection;
    }

    public void save(Bicycle bicycle) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO bicycles (bicycle_model_id) VALUES (?)",
                Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, bicycle.getBicycleModelId());
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            bicycle.setId(generatedKeys.getInt(1));
        }
    }

    public Bicycle getById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM bicycles WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Bicycle(
                    resultSet.getInt("id"),
                    resultSet.getInt("bicycle_model_id")
            );
        }
        return null;
    }

    public void update(Bicycle bicycle) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE bicycles SET bicycle_model_id = ? WHERE id = ?");
        statement.setInt(1, bicycle.getBicycleModelId());
        statement.setInt(2, bicycle.getId());
        statement.executeUpdate();
    }

    public void delete(Bicycle bicycle) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM bicycles WHERE id = ?");
        statement.setInt(1, bicycle.getId());
        statement.executeUpdate();
    }
}