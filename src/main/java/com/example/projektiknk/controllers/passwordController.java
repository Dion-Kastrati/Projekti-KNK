package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import models.Session;
import models.User;
import services.ConnectionUtil;
import services.Perkthimet;
import services.UserAuthService;
import services.UserService;

import java.io.IOException;
import java.io.PipedReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    private PasswordField oldPass_fieldID;
    @FXML
    private PasswordField newPass_fieldID;
    @FXML
    private PasswordField confirmPass_fieldID;
    @FXML
    private Label confirmPass_ID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Retrieve the User object representing the current user
        User currentUser = Session.getInstance().getCurrentUser();  // Replace this with your logic to get the current user

        // Set the current user in the session
        Session session = Session.getInstance();
        session.setCurrentUser(currentUser);

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

    public void sendToProfili(ActionEvent event) {
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

    public void sendToPassword(ActionEvent event) {
        try {
            // Load the signup.fxml file
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

    public void sendToGjuha(ActionEvent event) {
        try {
            // Load the signup.fxml file
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

    @FXML
    public void sendToLogin(ActionEvent event) {
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

    @FXML
    public void updatePassword1(ActionEvent event) {
        // Get the values entered by the user
        String oldPassword = oldPass_fieldID.getText();
        String newPassword = newPass_fieldID.getText();
        String confirmPassword = confirmPass_fieldID.getText();

        // Perform validation checks
        if (oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            // Display an error message if any of the fields are empty
            showErrorMessage("Please fill in all fields.");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            // Display an error message if the new password and confirm password do not match
            showErrorMessage("New password and confirm password do not match.");
            return;
        }
        // Retrieve the current user from the session
        User currentUser = Session.getInstance().getCurrentUser();
        UserService passwordUpdate= new UserService();
        // Perform the password change logic here (e.g., update the password in the database)
        boolean passwordChanged =passwordUpdate.updatePassword(currentUser, oldPassword, newPassword);

        if (passwordChanged) {
            // Password change was successful

            // Display a success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Password Change");
            alert.setHeaderText(null);
            alert.setContentText("Your password has been changed successfully.");
            alert.showAndWait();

            // Clear the fields after a successful password change
            oldPass_fieldID.setText("");
            newPass_fieldID.setText("");
            confirmPass_fieldID.setText("");
        } else {
            // Password change failed

            // Display an error message
            showErrorMessage("Failed to change password. Please try again.");
        }
    }

    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Password Change Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    public void updatePassword(ActionEvent event) {
        // Get the values entered by the user
        String oldPassword = oldPass_fieldID.getText();
        String newPassword = newPass_fieldID.getText();
        String confirmPassword = confirmPass_fieldID.getText();
        // Password validation
        if (newPassword.length() < 8) {
            showErrorMessage("Password should be at least 8 characters long.");
            return;
        }

        // Perform validation checks
        if (oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            // Display an error message if any of the fields are empty
            showErrorMessage("Please fill in all fields.");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            // Display an error message if the new password and confirm password do not match
            showErrorMessage("New password and confirm password do not match.");
            return;
        }
        // Retrieve the current user from the session
        User currentUser = Session.getInstance().getCurrentUser();

        // Perform the password change logic here (e.g., update the password in the database)
        UserService service=new UserService();
        boolean passwordChanged = service.updatePassword(currentUser, oldPassword, newPassword);

        if (passwordChanged) {
            // Password change was successful

            // Display a success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Password Change");
            alert.setHeaderText(null);
            alert.setContentText("Your password has been changed successfully.");
            alert.showAndWait();

            // Clear the fields after a successful password change
            oldPass_fieldID.setText("");
            newPass_fieldID.setText("");
            confirmPass_fieldID.setText("");
        } else {
            // Password change failed

            // Display an error message
            showErrorMessage("Failed to change password. Please try again.");
        }
    }

    public void translate() {
        ResourceBundle translate = ResourceBundle.getBundle("translations.content", Locale.getDefault());

        homeID.setText(translate.getString("homeID"));
        oraretID.setText(translate.getString("oraretID"));
        profilID.setText(translate.getString("profilID"));
        passwordID.setText(translate.getString("passwordID"));
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

