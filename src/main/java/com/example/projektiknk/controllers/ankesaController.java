package com.example.projektiknk.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ankesaController {
    @FXML
    private  Button profilID;
    @FXML
    private  Button gjuhaID;
    @FXML
    private  Button oraretID;
    @FXML
    private  Button homeID;
    @FXML
    private TextArea pershkrimiTxt;
    @FXML
    private ComboBox zgjedhja;
    @FXML
    private Button dergoBtn;

    public void sendToHome(MouseEvent mouseEvent) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/home.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) homeID.getScene().getWindow();
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToOraret(MouseEvent mouseEvent) {
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

    public void sendToGjuha(MouseEvent mouseEvent) {
  /*      try {
            // Load the ChangePass.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/gjuha.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) gjuha_ID.getScene().getWindow();
            stage.setTitle("User Profile");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }

    public void sendToProfili(MouseEvent mouseEvent) {
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

    public void onclickDergo(MouseEvent mouseEvent) {
    }
}
