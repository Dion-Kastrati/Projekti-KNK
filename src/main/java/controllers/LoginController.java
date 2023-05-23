package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import repository.UserRepository;
import services.UserService;
import services.interfaces.UserServiceInterface;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController {
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

    @FXML
    private void onActionCancel(ActionEvent e){
         this.usernameID.clear();
         this.passwordID.clear();
    }


}
