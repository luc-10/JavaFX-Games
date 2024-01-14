package com.example.game15.panes;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class MainPane extends BorderPane {
    public static TablePane tablePane;
    private static int moves;
    private static Text txt;
    public MainPane(){
        super();
        tablePane=new TablePane();
        this.setCenter(tablePane);
        Button button=new Button("Shuffle");
        button.setOnMouseClicked(mouseEvent -> {
            moves = 0;
            tablePane.shuffle();
        });
        this.setBottom(button);
        moves=-1;
        txt=new Text("");
        updateMoves();
        this.setTop(txt);
    }
    public static void updateMoves(){
        moves++;
        txt.setText("Moves: "+moves);
    }
    public static void checkWin(){
        int k=1;
        for (int i=0;i<TablePane.size;i++){
            for (int j=0;j<TablePane.size;j++){
                if ((i==3 && j==3) || k== Objects.requireNonNull(TablePane.getCellPaneAt(tablePane, i, j)).getValue()){
                    k++;
                } else {
                    return;
                }
            }
        }
        System.out.println("BRAV");
        VBox vBox=new VBox();
        vBox.getChildren().add(new Text("Hai vinto"));
        Button button=new Button("OK");
        button.setAlignment(Pos.CENTER);
        button.setOnMouseClicked(mouseEvent -> {
            Platform.exit();
        });
        vBox.getChildren().add(button);
        Scene scene=new Scene(vBox);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
