package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Session;
import models.User;
import services.UserService;
import services.interfaces.UserServiceInterface;
import services.Perkthimet;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private Button cancelID;
    @FXML
    private Button loginID;
    @FXML
    private Button signup_ID;
    @FXML
    private Button guest_ID;
    ;
    @FXML
    private TextField usernameID;
    @FXML
    private PasswordField passwordID;
    @FXML
    private Text or_label;
    @FXML
    private Label notmember_label;
    @FXML
    private Label username_label;
    @FXML
    private Label password_label;
    private UserServiceInterface userService;
    private static String selectedLanguage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        translate();
    }
    public LoginController() {
        userService = new UserService(); // Replace UserService with the actual implementation class name
    }

    @FXML
    private void onActionLogin(ActionEvent e) {
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
                Session.getInstance().setCurrentUser(loginUser); // Set the current username in the Session
                // Load the login.fxml file
                Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/home.fxml"));

                // Create a new scene with the loaded FXML file
                Scene scene = new Scene(root);

                Stage stage = (Stage) loginID.getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
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
    private void onActionCancel(ActionEvent e) {
        this.usernameID.clear();
        this.passwordID.clear();
    }

    @FXML
    private void enClick(ActionEvent e) {
        selectedLanguage = "en";
        Locale.setDefault(new Locale(selectedLanguage));
        translate();
    }

    @FXML
    private void sqClick(ActionEvent e) {
        selectedLanguage = "sq";
        Locale.setDefault(new Locale(selectedLanguage));
        translate();
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

    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



    public void translate() {
        ResourceBundle translate = ResourceBundle.getBundle("translations.content", Locale.getDefault());

        username_label.setText(translate.getString("username_label"));
        password_label.setText(translate.getString("password_label"));
        or_label.setText(translate.getString("or_label"));
        notmember_label.setText(translate.getString("notmember_label"));
        guest_ID.setText(translate.getString("guest_ID"));
        cancelID.setText(translate.getString("cancelID"));
        loginID.setText(translate.getString("loginID"));
        signup_ID.setText(translate.getString("signup_ID"));
        usernameID.setPromptText(translate.getString("usernameID"));
        passwordID.setPromptText(translate.getString("passwordID"));
    }
}

