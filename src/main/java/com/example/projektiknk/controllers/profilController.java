package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import services.Perkthimet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class profilController implements Initializable {
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
    private Button logout_ID;
    @FXML
    private Button gjuha_ID;
    @FXML
    private Button perditesoBtn_ID;
    @FXML
    private Label emri_label;
    @FXML
    private Label mbiemri_label;
    @FXML
    private Label lokacioni_label;
    @FXML
    private Label dhenat_ID;
    @FXML
    private Label email_label;
    private Perkthimet perkthimet;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        perkthimet=new Perkthimet();
        perkthimet.translate(homeID, oraretID, profilID, emri_label,mbiemri_label,email_label, fjalkalimiBtn_ID,
                logout_ID, ProfilID, gjuha_ID,lokacioni_label,perditesoBtn_ID,dhenat_ID);
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
            // Load the ChangePass.fxml file
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
    public void sendToLogin(ActionEvent event){
        try {
            // Load the signup.fxml file
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
}
