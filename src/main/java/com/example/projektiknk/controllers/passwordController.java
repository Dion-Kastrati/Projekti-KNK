package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class passwordController {
        @FXML
        private Button homeID;
        @FXML
        private Button oraretID;
        @FXML
        private Button fjalkalimiBtn_ID;
        @FXML
        private Button profilID;
        @FXML
        private Button logout_ID;

        public void sendToHome(ActionEvent event) {
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

        public void sendToProfili(ActionEvent event){
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
        public void sendToPassword(ActionEvent event){
            try {
                // Load the signup.fxml file
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/ChangePass.fxml"));

                // Create a new scene with the loaded FXML file
                Scene scene = new Scene(root);

                // Get the current stage (window) and set the new scene
                Stage stage = (Stage) fjalkalimiBtn_ID.getScene().getWindow();
                stage.setTitle("User Profile");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @FXML
        public void sendToLogin(ActionEvent event){
            try {
                // Load the signup.fxml file
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/signup.fxml"));

                // Create a new scene with the loaded FXML file
                Scene scene = new Scene(root);

                // Get the current stage (window) and set the new scene
                Stage stage = (Stage) logout_ID.getScene().getWindow();
                stage.setTitle("User Profile");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}

