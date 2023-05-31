package com.example.projektiknk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.SQLException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(

                App.class.getResource("dergoAnkesa.fxml")

        );

        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }


}