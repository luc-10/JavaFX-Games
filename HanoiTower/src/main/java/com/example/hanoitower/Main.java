package com.example.hanoitower;

import com.example.hanoitower.panes.HanoiPane;
import com.example.hanoitower.panes.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        MainPane mp=new MainPane();
        Scene scene=new Scene(mp,(HanoiPane.size+3)*30*3,(HanoiPane.size+3)*30);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}