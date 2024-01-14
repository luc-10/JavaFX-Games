package com.example.hanoitower.panes;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PiecePane extends StackPane {
    private final int value;
    public PiecePane(int i){
        super();
        this.setAlignment(Pos.CENTER);
        this.value=i;
        Rectangle r=new Rectangle(30*i,30);
        r.setFill(Color.AQUA);
        r.setStroke(Color.BLACK);
        Text txt=new Text(""+value);
        this.getChildren().addAll(r,txt);
    }
    public int getValue(){
        return value;
    }
}
