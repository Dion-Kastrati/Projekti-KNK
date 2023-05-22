package com.example.projektiknk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("login.fxml")
        );

        Scene scene;
        scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("eBus - Home");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}