package com.example.findimage.panes;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.scene.layout.GridPane.getColumnIndex;
import static javafx.scene.layout.GridPane.getRowIndex;

public class MainPane extends BorderPane {
    static int size=7;
    private final TablePane tablePane;
    private int attempts=3;
    private final Text text=new Text("Attempts: "+attempts);
    public MainPane(){
        super();
        SolutionPane solutionPane=new SolutionPane();
        tablePane=new TablePane(solutionPane);
        setCenter(tablePane);
        Button checkButton=new Button("Check");
        TilePane bottomPane = new TilePane();
        bottomPane.setHgap(25);
        bottomPane.setPrefColumns(2);
        bottomPane.getChildren().addAll(checkButton,text);
        setBottom(bottomPane);
        checkButton.setOnMouseClicked(mouseEvent -> {
            if (tablePane.check()){
                gameOver(true);
                checkButton.setDisable(true);
                return;
            }
            attempts--;
            updateText();
            if (attempts==0){
                gameOver(false);
                checkButton.setDisable(true);
            }
        });
    }
    private void gameOver(boolean won){
        tablePane.setNotClickable();
        Stage stage=new Stage();
        Scene scene=new Scene(tablePane.getSolutionPane());
        stage.setScene(scene);
        stage.show();
    }
    private void updateText(){
        text.setText("Attempts: "+attempts);
    }
    static CellPane getCellPaneAt(GridPane gridPane, int x, int y){
        for (Node n: gridPane.getChildren()){
            if (getRowIndex(n)==x && getColumnIndex(n)==y){
                return (CellPane) n;
            }
        }
        return null;
    }
}
