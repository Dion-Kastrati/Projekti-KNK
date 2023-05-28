package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
<<<<<<< Updated upstream
=======
import javafx.fxml.Initializable;
>>>>>>> Stashed changes
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
<<<<<<< Updated upstream

import java.io.IOException;
=======
>>>>>>> Stashed changes

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ankesaController  implements Initializable {
    @FXML
    private  Button profilID;
    @FXML
    private  Button oraretID;
    @FXML
    private  Button homeID;
    @FXML
    private TextArea pershkrimiTxt;
    @FXML
    private ComboBox zgjedhja;
    @FXML
    private Button dergoBtn;
<<<<<<< Updated upstream

    public void sendToHome(MouseEvent mouseEvent) {
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

    public void sendToOraret(MouseEvent mouseEvent) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/oraret.fxml"));
=======
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        translate();
    }

    public void sendToHome(ActionEvent event) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/home.fxml"));
>>>>>>> Stashed changes

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
<<<<<<< Updated upstream
            Stage stage = (Stage) oraretID.getScene().getWindow();
            stage.setTitle("Oraret");
=======
            Stage stage = (Stage) homeID.getScene().getWindow();
            stage.setTitle("Home");
>>>>>>> Stashed changes
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

<<<<<<< Updated upstream
    public void sendToGjuha(MouseEvent mouseEvent) {
  /*      try {
            // Load the ChangePass.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/gjuha.fxml"));
=======
    public void sendToOraret(ActionEvent event) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/oraret.fxml"));
>>>>>>> Stashed changes

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
<<<<<<< Updated upstream
            Stage stage = (Stage) gjuha_ID.getScene().getWindow();
            stage.setTitle("User Profile");
=======
            Stage stage = (Stage) oraretID.getScene().getWindow();
            stage.setTitle("Oraret");
>>>>>>> Stashed changes
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< Updated upstream
*/
    }

    public void sendToProfili(MouseEvent mouseEvent) {
=======
    }

    public void sendToProfili(ActionEvent event) {
>>>>>>> Stashed changes
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

    public void translate(){
        ResourceBundle translate = ResourceBundle.getBundle("translations.content", Locale.getDefault());

        homeID.setText(translate.getString("homeID"));
        oraretID.setText(translate.getString("oraretID"));
        profilID.setText(translate.getString("profilID"));

    }
}
