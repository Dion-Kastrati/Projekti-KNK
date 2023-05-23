package com.example.projektiknk.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class homeController {
    public Button homeID;
    public Button oraretID;
    public Button opsionetID;
    public Button kontaktID;
    public Button profilID;
    public Button shikoOraret;
    public Button dergoAnkese;

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
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("kontakti.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    public void sendToProfili(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("profil.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    public void shikoOraretPrejHome(MouseEvent mouseEvent) {
    }

    public void onClickAnkesa(MouseEvent mouseEvent) {
    }
}
