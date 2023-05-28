package com.example.projektiknk.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Oraret;
import services.ConnectionUtil;
import services.Perkthimet;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalTime;

import java.util.ResourceBundle;

import static repository.NormalUserRepository.*;

public class normalUserController implements Initializable {
    @FXML
    private Button gjejLinjat;
    @FXML
    private TableView<Oraret> tblOraret;
    @FXML
    private TableColumn<Oraret, String> kompaniaColumn;
    @FXML
    private TableColumn<Oraret, LocalTime> nisjaColumn;
    @FXML
    private TableColumn<Oraret, LocalTime> arritjaColumn;
    @FXML
    private TableColumn<Oraret, Integer> biletaColumn;
    @FXML
    private Pagination oraretPagination;
    @FXML
    private Label ngaLable;
    @FXML
    private ComboBox<String> comboNisja;
    @FXML
    private Label deriLable;
    @FXML
    private ComboBox<String> comboDestinacioni;
    @FXML
    private Button loginID;
    @FXML
    private Button signupID;
    private Perkthimet perkthimet;

    public void setData(ObservableList<Oraret> oraretList) {
        tblOraret.setItems(oraretList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         try {
            ObservableList<String> vendNisja = vendNisja();
            comboNisja.setItems(vendNisja);
//            comboNisja.setOnAction(this::onActionShfaqLinjat);
            ObservableList<String> destinacioni = destinacioni();
            comboDestinacioni.setItems(destinacioni);
//            comboDestinacioni.setOnAction(this::onActionShfaqLinjat);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    private void onActionShfaqLinjat(ActionEvent e) throws SQLException {

            // Pass the comboNisja value to a variable
            String selectedValue = comboNisja.getValue().toString();
            System.out.println("Selected Value: " + selectedValue);

            // Pass the comboDestinacioni value to a variable
            String selectedValueDest = comboDestinacioni.getValue().toString();
            System.out.println("Selected Value Dest: " + selectedValueDest);

            // Call the method getByPrejDeri and pass the selected values as parameters
            getOrarinPrejDeri(selectedValue, selectedValueDest);
        }


        public void sendToLogin(ActionEvent actionEvent) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/login.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) loginID.getScene().getWindow();
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
            stage.setTitle("Sign up");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
