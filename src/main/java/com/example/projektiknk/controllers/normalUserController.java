package com.example.projektiknk.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Oraret;

import java.io.IOException;
import java.net.URL;
import java.sql.*;

import java.util.ResourceBundle;

import static repository.NormalUserRepository.*;

public class normalUserController implements Initializable {
    @FXML
    private Label ngaLable_ID;
    @FXML
    private Label deriLable_ID;
    @FXML
    private Button gjejLinjat_ID;
    @FXML
    private Button dergoAnkese;

    @FXML
    private ComboBox<String> comboDestinacioni_ID;
    @FXML
    private ComboBox<String> comboNisja_ID;
    @FXML
    private Button gjejLinjat;
    @FXML
    private TableView<Oraret> tblOraret;
    @FXML
    private TableColumn<Oraret, String> kompaniaColumn_ID;
    @FXML
    private TableColumn<Oraret, String> nisjaColumn_ID;
    @FXML
    private TableColumn<Oraret, String> arritjaColumn_ID;
    @FXML
    private TableColumn<Oraret, Double> biletaColumn_ID;
    @FXML
    private Pagination oraretPagination;
    private final static int rowPerPage=5;
    @FXML
    private Label ngaLable;
    @FXML
    private Label deriLable;
    @FXML
    private Button loginID;
    @FXML
    private Button signupID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        kompaniaColumn_ID.setCellValueFactory(cellData -> cellData.getValue().companyNameProperty());
        nisjaColumn_ID.setCellValueFactory(cellData -> cellData.getValue().kohaNisjesProperty());
        arritjaColumn_ID.setCellValueFactory(cellData -> cellData.getValue().kohaArritjesProperty());
        biletaColumn_ID.setCellValueFactory(cellData -> cellData.getValue().cmimiBiletesProperty().asObject());

        // Fetch data from the database and populate the TableView
        ObservableList<Oraret> oraretList = fetchDataFromDatabase();
        tblOraret.setItems(oraretList);

        try {

            ObservableList<String> prejLista = from();
            ObservableList<String> deriLista = to();
            comboNisja_ID.setItems(prejLista);
            comboDestinacioni_ID.setItems(deriLista);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        oraretPagination.setPageFactory(this::createPage);
    }

    @FXML
    private void onActionShfaqLinjat(ActionEvent event) throws SQLException {
        try {
            // Pass the comboNisja value to a variable
            String selectedValue = comboNisja_ID.getValue().toString();
//            System.out.println("Selected Value: " + selectedValue);

            // Pass the comboDestinacioni value to a variable
            String selectedValueDest = comboDestinacioni_ID.getValue().toString();
//            System.out.println("Selected Value Dest: " + selectedValueDest);


            kompaniaColumn_ID.setCellValueFactory(cellData -> cellData.getValue().companyNameProperty());
            nisjaColumn_ID.setCellValueFactory(cellData -> cellData.getValue().kohaNisjesProperty());
            arritjaColumn_ID.setCellValueFactory(cellData -> cellData.getValue().kohaArritjesProperty());
            biletaColumn_ID.setCellValueFactory(cellData -> cellData.getValue().cmimiBiletesProperty().asObject());

            ObservableList<Oraret> oraretFilter = getOrarinPrejDeri(selectedValue, selectedValueDest);
            tblOraret.setItems(oraretFilter);
        }catch (NullPointerException e){
            showErrorMessage("Zgjedheni destinacioni!");
        }
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

    private Node createPage(int pageIndex) {
        int fromIndex = pageIndex * rowPerPage;
        int toIndex = Math.min(fromIndex + rowPerPage, tblOraret.getItems().size());

        tblOraret.getItems().setAll(fetchDataFromDatabase().subList(fromIndex, toIndex));

        return tblOraret;
    }
    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
