package com.example.projektiknk.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.AdminCompanyProperty;
import models.dto.CreateKompaniDto;
import repository.adminCompanyPropertyRepository;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static repository.adminCompanyPropertyRepository.fetchDataFromDatabase;

public class shtoKompaniController implements Initializable {
    public Button homeID;
    public Button oraretID;
    public Button profilID;
    public Text menaxhimiKompaniveID;
    public TableView<AdminCompanyProperty> tblKompanite;
    public TableColumn<AdminCompanyProperty, Integer> columnID;
    public TableColumn<AdminCompanyProperty, String> columnEmriKompanise;
    public TextField kompaniaRe_ID;
    public TextField kompania_ID;
    public Button shtoButton_ID;
    public Button kerkoButton_ID;
    public Button shtoLinjeID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        columnID.setCellValueFactory(cellData -> cellData.getValue().company_idProperty().asObject());
        columnEmriKompanise.setCellValueFactory(cellData -> cellData.getValue().company_nameProperty());

        ObservableList<AdminCompanyProperty> kompaniteMeIDs = fetchDataFromDatabase();
        tblKompanite.setItems(kompaniteMeIDs);
    }

    public void shtoKompaniButton(ActionEvent actionEvent) {
        // Gather student information from input fields or other sources
        String company_id = columnID.getText();
        String companyName = columnEmriKompanise.getText();

        CreateKompaniDto newKompani = new CreateKompaniDto(company_id, companyName);


        try {
            AdminCompanyProperty insertedKompani = adminCompanyPropertyRepository.insert(newKompani);
            if (insertedKompani != null) {
                tblKompanite.getItems().add(insertedKompani);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


    public void kerkoButton(ActionEvent actionEvent) {
        //TODO: me ba kur ti ranojm qiti butoni varesisht prej qka ka n'textfield me u ba filter
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

    public void sendToProfili(ActionEvent event){
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

    public void shtoButton(ActionEvent actionEvent) {
        // TODO: Kur preket butoni duhet me shtu ni kompani me emer te caktuar
    }

    public void shtoLinjeButton(ActionEvent actionEvent) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/oraret.fxml"));

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
}
