package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import models.Database;
import models.User;
import services.UserDAO;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
//        launch();
//        System.out.println("xXXXXX");
        String url = "jdbc:mysql://localhost/bicycle_store";
        String username = "root";
        String password = "";

        Database database = new Database(url, username, password);
        UserDAO userDAO = new UserDAO(database.open());

//        // добавление пользователя
//        User user = new User(0, "1234567890", "John Smith", "123 Main St", "password", "admin");
//        userDAO.addUser(user);

        // чтение пользователя
        User userById = userDAO.getUserById(1);
        System.out.println(userById.getName());

//        // обновление пользователя
//        user.setAddress("456 Main St");
//        userDAO.updateUser(user);
//
//        // удаление пользователя
//        userDAO.deleteUser(1);

        database.close();
//        database db = new database();
//        db.test();
    }
}