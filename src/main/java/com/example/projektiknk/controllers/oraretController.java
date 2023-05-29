package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.AdminKompanite;
import models.AdminOraret;
import models.Oraret;
import models.dto.CreateAdminOraretDto;
import models.dto.CreateKompaniDto;
import models.dto.CreateOraretDto;
import models.dto.UpdateOrariDto;
import repository.oraretRepository;
import repository.AdminLinjaRepository;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class oraretController {
    @FXML
    private TableColumn<AdminOraret, Integer> columnID;
    @FXML
    private TableColumn<AdminOraret, String> columnEmriID;
    @FXML
    private TableColumn<AdminOraret, String> columnVendNisjaID;
    @FXML
    private TableColumn<AdminOraret, String> columnDestinacioniID;
    @FXML
    private TableColumn<AdminOraret, String> columnNisjaID;
    @FXML
    private TableColumn<AdminOraret, String> columnArritjaID;
    @FXML
    private TableColumn<AdminOraret, Double> columnCmimiBiletesID;
    @FXML
    private ComboBox<AdminOraret> emriKompanise_ID;
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
    private TableView<AdminOraret> tblOraretAdmin_ID;
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
        String cmimiBiletes = cmimi_ID.getText();

        CreateAdminOraretDto student = new CreateAdminOraretDto(companyName,vendiNisjes,destinacionit,kohaNisjes,kohaArritjes,cmimiBiletes);


        try {
            AdminOraret insertedOrari = AdminLinjaRepository.insert(student);
            if (insertedOrari != null) {
                tblOraretAdmin_ID.getItems().add(insertedOrari);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
