module com.example.hanoitower {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hanoitower to javafx.fxml;
    exports com.example.hanoitower;
}