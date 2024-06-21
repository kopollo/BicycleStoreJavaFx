package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Client;
import models.Database;
import services.ClientORM;


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
//        String url = "jdbc:mysql://localhost/bicycle_store";
//        String username = "root";
//        String password = "";
        String url = "jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_2651_bicycle_store";
        String username = "std_2651_bicycle_store";
        String password = "std_2651_bicycle_store";

        Database database = new Database(url, username, password);
        Connection conn = database.open();
        ClientORM orm = new ClientORM(conn);
        ArrayList<Client> clients = orm.getAll();
        for(Client x: clients) {
            System.out.println(x.getName());
        }


        database.close();
//        database db = new database();
//        db.test();
    }
}