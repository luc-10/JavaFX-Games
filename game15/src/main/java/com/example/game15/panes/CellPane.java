package com.example.game15.panes;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CellPane extends StackPane {
    private final int value;
    private int x;
    private int y;
    public CellPane(int k){
        super();
        this.value=k;
        Rectangle r=new Rectangle(100,100);
        if (k==0){
            r.setFill(Color.TRANSPARENT);
            r.setStroke(Color.TRANSPARENT);
            this.getChildren().addAll(r);
        } else {
            r.setFill(Color.AQUA);
            r.setStroke(Color.TRANSPARENT);
            Text txt=new Text(""+k);
            this.getChildren().addAll(r,txt);
        }
        this.setOnMouseClicked(mouseEvent -> {
            TablePane.move(x,y);
            MainPane.updateMoves();
            MainPane.checkWin();
        });
    }
    public boolean isEmpty(){
        return value==0;
    }
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getValue(){
        return value;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
