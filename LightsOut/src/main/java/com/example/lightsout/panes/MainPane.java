package com.example.lightsout.panes;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class MainPane extends BorderPane {
    public static TablePane tp;
    private static int moves;
    private static Text txt;
    public MainPane(){
        super();
        tp=new TablePane();
        setCenter(tp);
        txt=new Text("");
        setTop(txt);
        tp.startGame();
        moves=-1;
        updateMoves();
        Button button=new Button("Hint");
        button.setOnMouseClicked(mouseEvent -> {
            try {
                tp.solve();
            } catch (InterruptedException e) {
                System.out.println("SPE");
            }
        });
        setBottom(button);
    }
    public static void updateMoves(){
        moves++;
        txt.setText("Moves: "+moves);
    }
    public static String getTxtString(){
        return txt.getText();
    }
}
