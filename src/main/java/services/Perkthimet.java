package services;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class Perkthimet {
    private static String selectedLanguage;

    public static String getSelectedLanguage() {
        return selectedLanguage;
    }

    public static void setSelectedLanguage(String selectedLanguage) {
        Perkthimet.selectedLanguage = selectedLanguage;
    }

    public void translate(Button signupID, Label emri_label, Label mbiemri_label, Label email_label,
                          Label username_label, Label password_label, TextField emriID, TextField mbiemriID, TextField emailID,
                          TextField usernameID, PasswordField passwordID, Button shqip_ID, Button english_ID,
                          Label alreadymember_label, Button login_ID){
        Locale currentLocale = Locale.getDefault();
        ResourceBundle translate = ResourceBundle.getBundle("translations.content", currentLocale);

        signupID.setText(translate.getString("signupID"));
        emri_label.setText(translate.getString("emri_label"));
        mbiemri_label.setText(translate.getString("mbiemri_label"));
        email_label.setText(translate.getString("email_label"));
        username_label.setText(translate.getString("username_label"));
        password_label.setText(translate.getString("password_label"));
        emriID.setPromptText(translate.getString("emriID"));
        mbiemriID.setPromptText(translate.getString("mbiemriID"));
        emailID.setPromptText(translate.getString("emailID"));
        usernameID.setPromptText(translate.getString("usernameID"));
        passwordID.setPromptText(translate.getString("passwordID"));
        shqip_ID.setText(translate.getString("shqip_ID"));
        english_ID.setText(translate.getString("english_ID"));
        alreadymember_label.setText(translate.getString("alreadymember_label"));
        login_ID.setText(translate.getString("login_ID"));
    }
    public void translate(Button cancelID, Button loginID, Button signup_ID, Button guest_ID,
                          TextField usernameID, PasswordField passwordID, Text or_label,
                          Label notmember_label, Label username_label, Label password_label) {
        ResourceBundle translate = ResourceBundle.getBundle("translations.content", Locale.getDefault());

        username_label.setText(translate.getString("username_label"));
        password_label.setText(translate.getString("password_label"));
        or_label.setText(translate.getString("or_label"));
        notmember_label.setText(translate.getString("notmember_label"));
        guest_ID.setText(translate.getString("guest_ID"));
        cancelID.setText(translate.getString("cancelID"));
        loginID.setText(translate.getString("loginID"));
        signup_ID.setText(translate.getString("signup_ID"));
        usernameID.setPromptText(translate.getString("usernameID"));
        passwordID.setPromptText(translate.getString("passwordID"));
    }

}
