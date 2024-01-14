package com.example.mastermind;

import com.example.mastermind.panes.MainPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static MainPane mainPane;
    public static Stage stage;
    @Override
    public void start(Stage stage) {
        mainPane=new MainPane();
        Scene scene=new Scene(mainPane);
        stage.setTitle("Mastermind");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        Main.stage=stage;
    }
    public static void startCodeBreak(){
        mainPane.startCodeBreak();
        stage.sizeToScene();
    }

    public static void main(String[] args) {
        launch();
    }
}