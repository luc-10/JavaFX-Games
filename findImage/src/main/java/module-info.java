module com.example.findimage {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.findimage to javafx.fxml;
    exports com.example.findimage;
}