package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;
import services.UserService;
import services.interfaces.UserServiceInterface;

import java.io.IOException;
import java.sql.SQLException;


public class LoginController {
    @FXML
    private Button cancelID;
    @FXML
    private Button loginID;
    @FXML
    private Button signup_ID;
    //services
    private UserServiceInterface userService;

    @FXML
    private TextField usernameID;
    @FXML
    private PasswordField passwordID;
    @FXML
    private Button guest_ID;
    @FXML
    private Button homeID;

     public LoginController() {
        userService = new UserService(); // Replace UserService with the actual implementation class name
    }
    @FXML
    private void onActionLogin(ActionEvent e)  {
        String username = this.usernameID.getText();
        String password = this.passwordID.getText();

        // Input validation checks
        if (username.isEmpty() || password.isEmpty()) {
            showErrorMessage("Please enter your username and password.");
            return;
        }

        try {
            User loginUser = userService.login(username, password);

            if (loginUser != null) {
                // Load the login.fxml file
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/home.fxml"));

                // Create a new scene with the loaded FXML file
                Scene scene = new Scene(root);

                Stage stage = (Stage) loginID.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else {
                // Username doesn't exist or password is incorrect, show an error message
                showErrorMessage("Invalid username or password. Please try again.");
            }
        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
            showErrorMessage("An error occurred during login. Please try again.");
        }
    }
    

    @FXML
    private void onActionCancel(ActionEvent e){
         this.usernameID.clear();
         this.passwordID.clear();
    }


    @FXML
    public void onActionSignup(ActionEvent event) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/signup.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) signup_ID.getScene().getWindow();
            stage.setTitle("Sign up");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public void onActionGuest(ActionEvent actionEvent) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/normalUserHome.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) guest_ID.getScene().getWindow();
            stage.setTitle("Guest - Oraret");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

