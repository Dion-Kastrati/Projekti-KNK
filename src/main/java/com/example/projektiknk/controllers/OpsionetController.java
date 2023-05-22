package com.example.projektiknk.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class OpsionetController implements Initializable {

    public Button homeID;
    public Button oraretID;
    public Button opsionetID;
    public Button kontaktID;
    public Button profilID;

    public void sendToHome(MouseEvent mouseEvent) {

    }

    public void sendToOraret(MouseEvent mouseEvent) {
    }

    public void sendToOpsionet(MouseEvent mouseEvent) {
    }

    public void sendToKontakti(MouseEvent mouseEvent) {
    }

    public void sendToProfili(MouseEvent mouseEvent) {
    }

    @FXML
    private ChoiceBox<String> myChoiceBox;

    private String[] gjuha={"Shqip","Anglisht"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        myChoiceBox.getItems().addAll(gjuha);
    }

    public void translateToAlbanian(MouseEvent mouseEvent) {
    }

    public void translateToEnglish(MouseEvent mouseEvent) {
    }
}
