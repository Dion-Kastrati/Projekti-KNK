package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class OpsionetController implements Initializable {

    @FXML
    private ChoiceBox<String> myChoiceBox;

    private String[] gjuha={"Shqip","Anglisht","Gjermanisht"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        myChoiceBox.getItems().addAll(gjuha);
    }
}
