package com.example.hanoitower;

import com.example.hanoitower.panes.PiecePane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Hand {
    private PiecePane p;
    private boolean isEmpty;
    public Hand(){
        p=null;
        isEmpty=true;
    }
    public void putInHand(PiecePane p){
        isEmpty=false;
        this.p=p;
    }
    public PiecePane getFromHand(){
        isEmpty=true;
        return this.p;
    }
    public StackPane getHand(){
        if (isEmpty){
            Rectangle r=new Rectangle(30,30);
            r.setFill(Color.TRANSPARENT);
            StackPane s=new StackPane();
            s.getChildren().add(r);
            return s;
        } else {
            return p;
        }
    }
    public PiecePane seeHand(){
        return this.p;
    }
    public boolean isHandEmpty(){
        return isEmpty;
    }
}
