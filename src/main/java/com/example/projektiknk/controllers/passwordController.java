package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import services.Perkthimet;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class passwordController implements Initializable {
        @FXML
        private Button homeID;
        @FXML
        private Button oraretID;
        @FXML
        private Button fjalkalimiBtn_ID;
        @FXML
        private Button profilID;
    @FXML
    private Button ProfilID;
        @FXML
        private Button gjuha_ID;
        @FXML
        private Button logout_ID;
    @FXML
    private Button perditesoBtn_ID;
    @FXML
    private Label passwordID;
    @FXML
    private Label oldPass_ID;
    @FXML
    private Label newPass_ID;
    @FXML
    private Label confirmPass_ID;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
       translate();
    }
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
    public void sendToGjuha(ActionEvent event){
        try {
            // Load the signup.fxml file
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
    }
        @FXML
        public void sendToLogin(ActionEvent event){
            try {
                // Load the login.fxml file
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/login.fxml"));

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
    public void translate(){
        ResourceBundle translate = ResourceBundle.getBundle("translations.content", Locale.getDefault());

        homeID.setText(translate.getString("homeID"));
        oraretID.setText(translate.getString("oraretID"));
        profilID.setText(translate.getString("profilID"));
        passwordID.setText(translate.getString("emri_label"));
        oldPass_ID.setText(translate.getString("oldPass_ID"));
        newPass_ID.setText(translate.getString("newPass_ID"));
        confirmPass_ID.setText(translate.getString("confirmPass_ID"));
        fjalkalimiBtn_ID.setText(translate.getString("fjalkalimiBtn_ID"));
        logout_ID.setText(translate.getString("logout_ID"));
        ProfilID.setText(translate.getString("ProfilID"));
        gjuha_ID.setText(translate.getString("gjuha_ID"));
        perditesoBtn_ID.setText(translate.getString("perditesoBtn_ID"));

    }
}

