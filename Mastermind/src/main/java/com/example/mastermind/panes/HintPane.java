package com.example.mastermind.panes;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static java.lang.Math.floor;

public class HintPane extends GridPane {
    Rectangle[] hints;
    public HintPane(){
        super();
        hints=new Rectangle[CodePane.size];
        for (int i=0;i<CodePane.size;i++){
            hints[i]=new Rectangle((double) CellPane.cellSize /2, (double) CellPane.cellSize /2);
            hints[i].setFill(Color.GRAY);
            hints[i].setStroke(Color.BLACK);
        }
        for (int i=0;i<CodePane.size;i++){
            super.add(hints[i],i%(CodePane.size/2),(int) floor((double) i /((double) CodePane.size /2)));
        }
    }
    public void activate(int k){
        System.out.println(k);
        if (k/10==CodePane.size){
            CodeBreakPane.endGame(true);
        }
        for (int i=0;i<k/10;i++){
            hints[i].setFill(Color.RED);
        }
        for (int i=k/10;i<k%10+k/10;i++){
            hints[i].setFill(Color.WHITE);
        }
    }
}
