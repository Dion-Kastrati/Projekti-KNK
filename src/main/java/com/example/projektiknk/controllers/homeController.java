package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.Perkthimet;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class homeController implements Initializable {
    @FXML
    private Button homeID;
    @FXML
    private Button oraretID;
    @FXML
    private Button profilID;
    @FXML
    private Button shikoOraret;
    @FXML
    private Button dergoAnkese;
    @FXML
    private Text textHome_ID;

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
            stage.setTitle("User Profile");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shikoOraretPrejHome(ActionEvent event) {

        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/oraret.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) oraretID.getScene().getWindow();
            stage.setTitle("Oraret");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClickAnkesa(ActionEvent event) {
        
    }
    public void translate(){
        ResourceBundle translate = ResourceBundle.getBundle("translations.content", Locale.getDefault());

        homeID.setText(translate.getString("homeID"));
        oraretID.setText(translate.getString("oraretID"));
        profilID.setText(translate.getString("profilID"));
        shikoOraret.setText(translate.getString("shikoOraret"));
        dergoAnkese.setText(translate.getString("dergoAnkese"));
        textHome_ID.setText(translate.getString("textHome_ID"));

    }
}
