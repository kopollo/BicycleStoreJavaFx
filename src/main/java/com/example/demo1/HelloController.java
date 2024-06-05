package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private Button btn1;

    @FXML
    private Text tes;

    @FXML
    void printCat(ActionEvent event) {
        tes.setText("TEXTXTTXDT");
        System.out.println(event.getSource());
    }

}
