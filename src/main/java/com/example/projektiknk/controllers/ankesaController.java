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
import models.Ankesa;
import services.AnkesaService;

import java.io.IOException;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ankesaController  implements Initializable {

    @FXML
    private Text ankesaText_ID;
    @FXML
    private  Button loginID;
    @FXML
    private  Button signupID;
    @FXML
    private  Button dergoAnkese;
    @FXML
    private  Button guest_ID;
    @FXML
    private TextArea pershkrimiTxt_ID;
    @FXML
    private TextField email_ID;
    @FXML
    private Button dergoBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        translate();
    }


    public void sendToLogin(ActionEvent actionEvent) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/login.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) loginID.getScene().getWindow();
            stage.setResizable(false);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToSignup(ActionEvent actionEvent) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/signup.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) signupID.getScene().getWindow();
            stage.setResizable(false);
            stage.setTitle("Sign up");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClickAnkesa(ActionEvent event) {

        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/dergoAnkesa.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) dergoAnkese.getScene().getWindow();
            stage.setResizable(false);
            stage.setTitle("Ankesa");
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
            stage.setResizable(false);
            stage.setTitle("Guest - Oraret");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onActionDergo(ActionEvent event){
        String email=email_ID.getText();
        String pershkrimiTxt=pershkrimiTxt_ID.getText();
        // Input validation checks
        if (email.isEmpty() || pershkrimiTxt.isEmpty() ) {
            showErrorMessage("Please fill in all the fields.");
            return;
        }
        // Email validation
        if (!isValidEmail(email)) {
            showErrorMessage("Invalid email address.");
            return;
        }
        Ankesa ankesa= AnkesaService.register(email,pershkrimiTxt);
        if(ankesa != null){
            showInformationMessage("Ankesa u dergua me sukses!");
        }
    }

    public void translate(){
        ResourceBundle translate = ResourceBundle.getBundle("translations.content", Locale.getDefault());


    }
    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void showInformationMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
}
