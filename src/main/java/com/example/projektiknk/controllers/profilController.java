package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;

import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.User;
import repository.UserRepository;
import services.Perkthimet;
import services.UserAuthService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class profilController implements Initializable {
    @FXML
    private ImageView imageID;
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
    private Label emri_label;
    @FXML
    private Label emri_labelID;
    @FXML
    private Label mbiemri_label;
    @FXML
    private Label lokacioni_label;
    @FXML
    private Label dhenat_ID;
    @FXML
    private Label email_label;
    private UserAuthService authService;

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
            stage.setResizable(false);
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
            stage.setResizable(false);
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
            stage.setResizable(false);
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
            stage.setResizable(false);
            stage.setTitle("User Profile");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendToGjuha(ActionEvent event){
        try {
            // Load the ChangePass.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/gjuha.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) gjuha_ID.getScene().getWindow();
            stage.setResizable(false);
            stage.setTitle("User Profile");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendToLogin(ActionEvent event){
        try {
            // Load the login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/login.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) logout_ID.getScene().getWindow();
            stage.setResizable(false);
            stage.setTitle("User Profile");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() throws SQLException {
        authService= new UserAuthService();
        translate();
        loggedin();
    }
    public void loggedin() throws SQLException {
        User currentUser = authService.getCurrentUser();
        if (currentUser != null) {
            // Retrieve user data from the database based on the logged-in user
            // For example, assuming you have a method called getUserData(username) in your UserRepository:
            User userData = UserRepository.getByUsername(currentUser.getUsername());

            // Populate the labels with the retrieved user data
            if (userData != null) {
                emri_labelID.setText(userData.getEmri());
                mbiemri_label.setText(userData.getMbiemri());
                email_label.setText(userData.getEmail());
            }
        }
    }
    public void translate(){
        ResourceBundle translate = ResourceBundle.getBundle("translations.content", Locale.getDefault());

        homeID.setText(translate.getString("homeID"));
        oraretID.setText(translate.getString("oraretID"));
        profilID.setText(translate.getString("profilID"));
        emri_label.setText(translate.getString("emri_label"));
        mbiemri_label.setText(translate.getString("mbiemri_label"));
        email_label.setText(translate.getString("email_label"));
        fjalkalimiBtn_ID.setText(translate.getString("fjalkalimiBtn_ID"));
        logout_ID.setText(translate.getString("logout_ID"));
        ProfilID.setText(translate.getString("ProfilID"));
        gjuha_ID.setText(translate.getString("gjuha_ID"));
        lokacioni_label.setText(translate.getString("lokacioni_label"));
        dhenat_ID.setText(translate.getString("dhenat_ID"));
    }
}
