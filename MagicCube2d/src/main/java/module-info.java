module com.example.magiccube2d {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.magiccube2d to javafx.fxml;
    exports com.example.magiccube2d;
}