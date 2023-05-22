package com.example.projektiknk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import services.UserService;
import services.interfaces.UserServiceInterface;


public class LoginController {
    public Button loginID;
    //services
    private UserServiceInterface userService;

    public LoginController() {
        System.out.println("Controller");
        this.userService = new UserService();
    }


    @FXML
    private TextField usernameID;
    @FXML
    private PasswordField passwordID;
    @FXML
    private Button loginId;

    @FXML
    private void onActionLogin(ActionEvent e){
        String username = this.usernameID.getText();
        String password = this.passwordID.getText();

        System.out.printf("Username: %s, Password: %s", username, password);
    }


    public void onclickLogin(MouseEvent mouseEvent) {
    }

    public void onclickCancel(MouseEvent mouseEvent) {
        this.usernameID.clear();
        this.passwordID.clear();
    }
}
