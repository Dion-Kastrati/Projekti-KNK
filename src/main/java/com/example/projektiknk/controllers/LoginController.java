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
import services.UserService;
import services.interfaces.UserServiceInterface;

import java.io.IOException;
import java.sql.SQLException;


public class LoginController {
    public Button loginID;
    public Button signup_ID;
    //services
    private UserServiceInterface userService;

    @FXML
    private TextField usernameID;
    @FXML
    private PasswordField passwordID;
    @FXML
    private Button loginId;

    @FXML
    private void onActionLogin(ActionEvent e) throws IOException, SQLException {
        String username = this.usernameID.getText();
        String password = this.passwordID.getText();

        UserServiceInterface userService = new UserService(); // Replace UserService with the actual implementation class name

        // Check if the username exists and the password is correct
        User loginUser = userService.login(username, password);

        if (loginUser != null) {
            // Load the home.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/home.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) loginID.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            // Username doesn't exist or password is incorrect, show an error message or perform an action accordingly
            System.out.println("Invalid username or password. Please try again.");
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
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
