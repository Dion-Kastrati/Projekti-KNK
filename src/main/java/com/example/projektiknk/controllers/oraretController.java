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
import models.Oraret;
import models.dto.CreateOraretDto;
import repository.oraretRepository;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static repository.NormalUserRepository.fetchDataFromDatabase;
import static repository.oraretRepository.selectCompanies;

public class oraretController implements Initializable {
    @FXML
    private TableColumn<Oraret, Integer> columnID;
    @FXML
    private TableColumn<Oraret, String> columnEmriID;
    @FXML
    private TableColumn<Oraret, String> columnVendNisjaID;
    @FXML
    private TableColumn<Oraret, String> columnDestinacioniID;
    @FXML
    private TableColumn<Oraret, String> columnNisjaID;
    @FXML
    private TableColumn<Oraret, String> columnArritjaID;
    @FXML
    private TableColumn<Oraret, Double> columnCmimiBiletesID;
    @FXML
    private ComboBox<String> emriKompanise_ID;
    @FXML
    private TextField vendNisja_ID;
    @FXML
    private TextField destinacioni_ID;
    @FXML
    private TextField oraNisjes_ID;
    @FXML
    private TextField oraArritjes_ID;
    @FXML
    private TextField cmimi_ID;
    @FXML
    private TableView<Oraret> tblOraretAdmin_ID;
    @FXML
    private Text menaxhimiOrareveID;
    @FXML
    private Button shtoLinjenButton_ID;
    @FXML
    private Button shtoKompaniButton_ID;
    @FXML
    private Button homeID;
    @FXML
    private Button oraretID;
    @FXML
    private Button profilID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        columnID.setCellValueFactory(cellData -> cellData.getValue().orariIdProperty().asObject());
        columnEmriID.setCellValueFactory(cellData -> cellData.getValue().companyNameProperty());
        columnVendNisjaID.setCellValueFactory(cellData -> cellData.getValue().prejProperty());
        columnDestinacioniID.setCellValueFactory(cellData -> cellData.getValue().deriProperty());
        columnNisjaID.setCellValueFactory(cellData -> cellData.getValue().kohaNisjesProperty());
        columnArritjaID.setCellValueFactory(cellData -> cellData.getValue().kohaArritjesProperty());
        columnCmimiBiletesID.setCellValueFactory(cellData -> cellData.getValue().cmimiBiletesProperty().asObject());

        // Fetch data from the database and populate the TableView
        ObservableList<Oraret> oraretList = fetchDataFromDatabase();
        tblOraretAdmin_ID.setItems(oraretList);

        try {
            ObservableList<String> kompanite = selectCompanies();
            emriKompanise_ID.setItems(kompanite);
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

    // logjika e buttonit update
//    public void updateStudentClick() {
//        // Get the selected student ID and updated student information from input fields or other sources
//        int orariID = Integer.parseInt(oraretID.getText());
//        String companyName = columnEmriID.getText();
//        String vendNisja = columnVendNisjaID.getText();
//        String destinacioni = columnDestinacioniID.getText();
//        String kohaNisjes = columnNisjaID.getText();
//        String kohaArritjes = columnArritjaID.getText();
//        String ticketPrice = columnCmimiBiletesID.getText();
//
//        UpdateOrariDto updateLinjen = new UpdateOrariDto(orariID, companyName, vendNisja, destinacioni, kohaNisjes,kohaArritjes, ticketPrice);
//
//        AdminOraret selectedOrari = null;
//        for (AdminOraret oraret: tblOraretAdmin_ID.getItems()){
//            if (oraret.getOrariID() == orariID){
//                selectedOrari = oraret;
//            }
//        }
//
//        if (selectedOrari != null) {
//            // Update the AdminStudent object with the updated information
//            if (!companyName.isEmpty()){
//            selectedOrari.setCompanyName(companyName);
//            }
//            if (!vendNisja.isEmpty()){
//            selectedOrari.setVendNisja(vendNisja);
//            }
//            if (!destinacioni.isEmpty()){
//                selectedOrari.setDestinacioni(destinacioni);
//            }
//            if (!kohaNisjes.isEmpty()){
//                selectedOrari.setKohaNisjes(kohaNisjes);
//            }
//            if(!kohaArritjes.isEmpty()){
//                selectedOrari.setKohaArritjes(kohaArritjes);
//            }
//            if(!ticketPrice.isEmpty()){
//                selectedOrari.setCmimiBiletes(ticketPrice);
//            }
//
//
//
//            try {
//
//                boolean isUpdated = AdminLinjaRepository.updateOrarin(updateLinjen);
//                if (isUpdated) {
//
//                    System.out.println("Student updated successfully.");
//                    tblOraretAdmin_ID.refresh();
//                } else {
//
//                    System.out.println("Failed to update student.");
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//
//            }
//
//        }
//    }

    public void shtoKompaniButton(ActionEvent actionEvent) {
        try {
            // Load the signup.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/projektiknk/shtoKompani.fxml"));

            // Create a new scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) profilID.getScene().getWindow();
            stage.setTitle("Shto Kompani - Manager");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }    }

    public void shtoLinjenButton(ActionEvent actionEvent) {
        //TODO: Logjika qe me shtu linjen e re masi t mushen fields
        // i marrim tdhanat prej text fields
        String companyName = emriKompanise_ID.getValue().toString();
        String vendiNisjes = vendNisja_ID.getText();
        String destinacionit = destinacioni_ID.getText();
        String kohaNisjes = oraNisjes_ID.getText();
        String kohaArritjes = oraArritjes_ID.getText();
        String cmimiBiletesStr = columnCmimiBiletesID.getText();
        double cmimiBiletes = Double.parseDouble(cmimiBiletesStr);


        CreateOraretDto orari = new CreateOraretDto(companyName,vendiNisjes,destinacionit,kohaNisjes,kohaArritjes,cmimiBiletes);


        try {
            Oraret insertedOrari = oraretRepository.insert(orari);
            if (insertedOrari != null) {
                tblOraretAdmin_ID.getItems().add(insertedOrari);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
