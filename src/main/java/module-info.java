module com.example.demoex {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demoex to javafx.fxml;
    exports com.example.demoex;
}