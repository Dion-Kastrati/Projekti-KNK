package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.UserService;
import services.interfaces.UserServiceInterface;

import java.io.IOException;


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
    private void onActionLogin(ActionEvent e){
        String username = this.usernameID.getText();
        String password = this.passwordID.getText();

        System.out.printf("Username: %s, Password: %s", username, password);
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
