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
import services.UserAuthService;

import java.io.IOException;
import java.sql.SQLException;

public class SignupController {
    public Button login_ID;
    public Button signupID;
    @FXML
    private TextField emriID;
    @FXML
    private TextField mbiemriID;
    @FXML
    private TextField emailID;
    @FXML
    private TextField usernameID;
    @FXML
    private PasswordField passwordID;

    public void signupClick(ActionEvent event) {
        String emri = emriID.getText();
        String mbiemri = mbiemriID.getText();
        String email = emailID.getText();
        String username = usernameID.getText();
        String password = passwordID.getText();
        // Input validation checks
        if (emri.isEmpty() || mbiemri.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            showErrorMessage("Please fill in all the fields.");
            return;
        }

        try {
            User user = UserAuthService.register(emri, mbiemri, email, username, password);
            if (user != null) {
                System.out.println("Signup successful! Data stored in the database.");
                // Load the home.fxml file
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/home.fxml"));

                // Create a new scene with the loaded FXML file
                Scene scene = new Scene(root);

                // Get the current stage (window) and set the new scene
                Stage stage = (Stage) signupID.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else {
                showErrorMessage("Signup failed! Unable to store data in the database.");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            showErrorMessage("An error occurred during signup. Please try again later.");
        } catch (IOException e) {
            e.printStackTrace();
            showErrorMessage("An error occurred. Please try again later.");
        }

    }
    @FXML
    private void onActionLogin(ActionEvent event) {
        try {
            // Load the login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/login.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) login_ID.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showErrorMessage("An error occurred. Please try again later.");
        }
    }
    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
