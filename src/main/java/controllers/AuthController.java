package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class AuthController {

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
