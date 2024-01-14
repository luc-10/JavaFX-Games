module com.example.game15 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.game15 to javafx.fxml;
    exports com.example.game15;
}