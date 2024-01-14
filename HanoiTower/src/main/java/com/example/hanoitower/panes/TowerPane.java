package com.example.hanoitower.panes;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class TowerPane extends VBox {
    private final ArrayList<PiecePane> pieces;
    private boolean takenFrom;
    public TowerPane(){
        super();
        pieces=new ArrayList<>();
        this.setAlignment(Pos.BOTTOM_CENTER);
        takenFrom=false;
        refresh();
    }
    public boolean isTakenFrom() {
        return takenFrom;
    }
    public void resetTakenFrom(){
        this.takenFrom=false;
    }
    public int getSize(){
        return pieces.size();
    }
    public boolean isEmpty(){
        return pieces.isEmpty();
    }
    private void refresh(){
        this.getChildren().clear();
        for (PiecePane piece : pieces) {
            this.getChildren().add(piece);
        }
        Rectangle rectangle=new Rectangle((HanoiPane.size+1)*30,5);
        this.getChildren().add(rectangle);
    }
    public void start(int k){
        for (int i=0;i<k;i++){
            pieces.add(new PiecePane(i+1));
        }
        refresh();
    }
    public int getTopValue(){
        if (this.pieces.isEmpty()){
            return HanoiPane.size;
        }
        return this.pieces.get(0).getValue();
    }
    public boolean canPlaceOnTower(PiecePane p){
        return (p.getValue()<=getTopValue());
    }
    public void placeOnTower(PiecePane p){
        this.pieces.add(0,p);
        refresh();
    }
    public PiecePane takeFromTower(){
        PiecePane ret = this.pieces.remove(0);
        refresh();
        takenFrom=true;
        return ret;
    }
}
