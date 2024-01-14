package com.example.magiccube2d;

import com.example.magiccube2d.panes.MainPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static MainPane mainPane=new MainPane();
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene=new Scene(mainPane);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}