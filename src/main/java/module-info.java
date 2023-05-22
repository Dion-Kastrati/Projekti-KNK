module com.example.projektiknk {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports com.example.projektiknk;


    opens com.example.projektiknk.controllers;
    exports com.example.projektiknk.controllers;
    opens com.example.projektiknk;

}