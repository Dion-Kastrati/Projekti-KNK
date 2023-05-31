package com.example.projektiknk.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Ankesa;
import models.Oraret;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import static repository.AnkesaRepository.fetchAnkesat;
import static repository.NormalUserRepository.*;

public class menaxhoAnkesa implements Initializable{
        @FXML
        private TableView<Ankesa> tblAnkesaID;
        @FXML
        private TableColumn<Ankesa, String> emailCol_ID;
        @FXML
        private TableColumn<Ankesa, String> ankesaCol_ID;
        @FXML
        private Button homeID;
        @FXML
        private Button oraretID;
        @FXML
        private Button profilID;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle){
            translate();
            emailCol_ID.setCellValueFactory(cellData -> cellData.getValue().emailcolProperty());
            ankesaCol_ID.setCellValueFactory(cellData -> cellData.getValue().aneksacolProperty());

            // Fetch data from the database and populate the TableView
            ObservableList<Ankesa> ankesaList = fetchAnkesat();
            tblAnkesaID.setItems(ankesaList);
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



        public void translate(){
            ResourceBundle translate = ResourceBundle.getBundle("translations.content", Locale.getDefault());

            homeID.setText(translate.getString("homeID"));
            oraretID.setText(translate.getString("oraretID"));
            profilID.setText(translate.getString("profilID"));


        }
}


