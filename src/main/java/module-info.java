module com.example.projektiknk {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projektiknk to javafx.fxml;
    exports com.example.projektiknk;


    opens controllers;
    exports controllers;

}