package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
//import models.Perkthimet;
import models.User;
import services.UserAuthService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class SignupController implements Initializable{

    @FXML
    public Button login_ID;
    @FXML
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
    @FXML
    private Button shqip_ID;
    @FXML
    private Button english_ID;
    @FXML
    private Label emri_label;
    @FXML
    private Label mbiemri_label;
    @FXML
    private Label email_label;
    @FXML
    private Label username_label;
    @FXML
    private Label password_label;
    @FXML
    private Label alreadymember_label;

    @FXML
    private void enClick(ActionEvent e){
        Locale.setDefault(new Locale("en"));
        this.translate();
    }
    @FXML
    private void sqClick(ActionEvent e){
        Locale.setDefault(new Locale("sq"));
        this.translate();
    }
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
                stage.setTitle("User Home");
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
            stage.setTitle("Login");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Locale locale =Locale.getDefault();
    }
    public void translate(){
        Locale currentLocale = Locale.getDefault();
        ResourceBundle translate = ResourceBundle.getBundle("translations.content", currentLocale);

        signupID.setText(translate.getString("signupID"));
        emri_label.setText(translate.getString("emri_label"));
        mbiemri_label.setText(translate.getString("mbiemri_label"));
        email_label.setText(translate.getString("email_label"));
        username_label.setText(translate.getString("username_label"));
        password_label.setText(translate.getString("password_label"));
        emriID.setPromptText(translate.getString("emriID"));
        mbiemriID.setPromptText(translate.getString("mbiemriID"));
        emailID.setPromptText(translate.getString("emailID"));
        usernameID.setPromptText(translate.getString("usernameID"));
        passwordID.setPromptText(translate.getString("passwordID"));
        shqip_ID.setText(translate.getString("shqip_ID"));
        english_ID.setText(translate.getString("english_ID"));
        alreadymember_label.setText(translate.getString("alreadymember_label"));
        login_ID.setText(translate.getString("login_ID"));
    }

}
