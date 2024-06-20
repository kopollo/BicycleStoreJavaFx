package services;

import models.Shop;

import java.sql.*;

public class ShopORM {
    private Connection connection;

    public ShopORM(Connection connection) {
        this.connection = connection;
    }

    public void save(Shop shop) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO shops (name, address) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, shop.getName());
        statement.setString(2, shop.getAddress());
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            shop.setId(generatedKeys.getInt(1));
        }
    }

    public Shop getById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM shops WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            return new Shop(
                    id,
                    name,
                    address
            );
        }
        return null;
    }

    public void update(Shop shop) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE shops SET name = ?, address = ? WHERE id = ?");
        statement.setString(1, shop.getName());
        statement.setString(2, shop.getAddress());
        statement.setInt(3, shop.getId());
        statement.executeUpdate();
    }

    public void delete(Shop shop) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM shops WHERE id = ?");
        statement.setInt(1, shop.getId());
        statement.executeUpdate();
    }
}
