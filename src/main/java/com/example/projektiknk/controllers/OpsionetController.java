package com.example.projektiknk.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OpsionetController implements Initializable {

    public Button homeID;
    public Button oraretID;
    public Button opsionetID;
    public Button kontaktID;
    public Button profilID;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //Kjo metode sherben qe me i ekzekutu funksionet qka nuk jane onclick
    }

    public void sendToHome(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("home.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    public void sendToOraret(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("oraret.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    public void sendToOpsionet(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("gjuha.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    public void sendToKontakti(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("views/kontakti.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    public void sendToProfili(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("views/profil.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    public void translateToAlbanian(MouseEvent mouseEvent) {

    }

    public void translateToEnglish(MouseEvent mouseEvent) {
    }
}
