module com.example.projektiknk {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projektiknk to javafx.fxml;
    exports com.example.projektiknk;
}