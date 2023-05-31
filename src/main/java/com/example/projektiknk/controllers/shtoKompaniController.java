package com.example.projektiknk.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.AdminCompany;
import models.dto.CreateKompaniDto;
import repository.AddNewCompanyRepository;
import repository.adminCompanyPropertyRepository;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static repository.AddNewCompanyRepository.filterCompany;
import static repository.AddNewCompanyRepository.insert;
import static repository.adminCompanyPropertyRepository.fetchDataFromDatabase;

public class shtoKompaniController implements Initializable {
    @FXML
    private Button homeID;
    @FXML
    private Button oraretID;
    @FXML
    private Button profilID;
    @FXML
    private Text menaxhimiKompaniveID;
    @FXML
    private TableView<AdminCompany> tblKompanite;
    @FXML
    private TableColumn<AdminCompany, Integer> columnID;
    @FXML
    private TableColumn<AdminCompany, String> columnEmriKompanise;
    @FXML
    private TextField kompaniaRe_ID;
    @FXML
    private TextField kompania_ID;
    @FXML
    private Button shtoButton_ID;
    @FXML
    private Button kerkoButton_ID;
    @FXML
    private Button shtoLinjeID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        columnID.setCellValueFactory(cellData -> cellData.getValue().company_idProperty().asObject());
        columnEmriKompanise.setCellValueFactory(cellData -> cellData.getValue().company_nameProperty());

        ObservableList<AdminCompany> kompanite = fetchDataFromDatabase();
        tblKompanite.setItems(kompanite);
    }

    public void shtoKompaniButton(ActionEvent actionEvent) {
        String companyName = columnEmriKompanise.getText();

        CreateKompaniDto newKompani = new CreateKompaniDto( companyName);

        try {
            AdminCompany insertedKompani = adminCompanyPropertyRepository.insert(newKompani);
            if (insertedKompani != null) {
                tblKompanite.getItems().add(insertedKompani);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
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

    public void sendToProfili(ActionEvent event){
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

    public void shtoLinjeButton(ActionEvent actionEvent) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/oraret.fxml"));

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

    public void kerkoButton(ActionEvent actionEvent) throws SQLException {
        columnID.setCellValueFactory(cellData -> cellData.getValue().company_idProperty().asObject());
        columnEmriKompanise.setCellValueFactory(cellData -> cellData.getValue().company_nameProperty());

        String companyName = kompania_ID.getText();

        ObservableList<AdminCompany> kompanite = filterCompany(companyName);
        tblKompanite.setItems(kompanite);
    }

    public void shtoButton(ActionEvent actionEvent) {
        String companyName = kompaniaRe_ID.getText();
        CreateKompaniDto newKompani = new CreateKompaniDto(companyName);
        try {
            AdminCompany insertedCompany = AddNewCompanyRepository.insert(newKompani);
            tblKompanite.getItems().add(insertedCompany);
            showInformationMessage("Company added successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void showInformationMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
