package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GjuhaController implements Initializable {

    @FXML
    private Button homeID;
    @FXML
    private Button oraretID;
    @FXML
    private Button opsionetID;
    @FXML
    private Button kontaktID;
    @FXML
    private Button profilID;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //Kjo metode sherben qe me i ekzekutu funksionet qka nuk jane onclick
    }

    public void sendToHome(ActionEvent event)  {
        try{  // Load the signup.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/home.fxml"));

        // Create a new scene with the loaded FXML file
        Scene scene = new Scene(root);

        // Get the current stage (window) and set the new scene
        Stage stage = (Stage) homeID.getScene().getWindow();
        stage.setTitle("User Home");
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void sendToOraret(ActionEvent event) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/oraret.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) oraretID.getScene().getWindow();
            stage.setTitle("Oraret");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToGjuha(ActionEvent event) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/gjuha.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) opsionetID.getScene().getWindow();
            stage.setTitle("Zgjedh gjuhen");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToProfili(ActionEvent event) throws IOException {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/profil.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) profilID.getScene().getWindow();
            stage.setTitle("User Profile");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void translateToAlbanian(MouseEvent mouseEvent) {

    }

    public void translateToEnglish(MouseEvent mouseEvent) {
    }
}
