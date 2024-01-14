package com.example.lightsout;

import com.example.lightsout.panes.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        MainPane mp=new MainPane();
        stage.setTitle("LightsOut");
        Scene scene=new Scene(mp);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}