module com.example.jushuapeterte {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.jushuapeterte to javafx.fxml;
    exports com.example.jushuapeterte;
}