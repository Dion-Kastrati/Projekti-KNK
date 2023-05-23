package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

        try {
            User user = UserAuthService.register(emri, mbiemri, email, username, password);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        System.out.printf("Emri: %s Username: %s, Password: %s",emri, username, password);
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
        }
    }


}
