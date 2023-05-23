package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;
import services.UserAuthService;

import java.sql.SQLException;

public class SignupController {
    @FXML
    private TextField emriID;
    @FXML
    private TextField mbiemriID;
    @FXML
    private TextField emailID;
    @FXML
    private TextField usernameID;
    @FXML
    private PasswordField passwordID;

    public void signupClick(ActionEvent event) {
        String emri = emriID.getText();
        String mbiemri = mbiemriID.getText();
        String email = emailID.getText();
        String username = usernameID.getText();
        String password = passwordID.getText();

        try {
            User user = UserAuthService.register(emri, mbiemri, email, username, password);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        System.out.printf("Emri: %s Username: %s, Password: %s",emri, username, password);
    }
}
