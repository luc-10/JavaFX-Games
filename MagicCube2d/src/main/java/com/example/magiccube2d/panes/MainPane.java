package com.example.magiccube2d.panes;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MainPane extends GridPane {
    public MainPane(){
        super();
        super.add(new CubePane(),0,0);
        for (int i=1;i<4;i++){
            super.add(new ColorPane(Color.BLUE, Pos.BOTTOM_CENTER),i,0);
            super.add(new ColorPane(Color.ORANGE, Pos.CENTER_RIGHT),0,i);
            super.add(new ColorPane(Color.RED,Pos.CENTER_LEFT),4,i);
            super.add(new ColorPane(Color.GREEN,Pos.TOP_CENTER),i,4);
        }
        setXYs();
    }
    private void setXYs(){
        for (Node n: this.getChildren()){
            if (n instanceof ColorPane){
                ((ColorPane) n).setXY(getRowIndex(n),getColumnIndex(n));
            }
        }
    }
    private ColorPane getColorPaneAt(int x, int y){
        for (Node n: this.getChildren()){
            if (n instanceof ColorPane && getRowIndex(n)==x && getColumnIndex(n)==y){
                return (ColorPane) n;
            }
        }
        return null;
    }
    private void swapColors(int x1, int y1, int x2, int y2){
        Color color=getColorPaneAt(x1,y1).getColor();
        getColorPaneAt(x1,y1).setColor(getColorPaneAt(x2,y2).getColor());
        getColorPaneAt(x2,y2).setColor(color);
    }
    void swap(int x1, int y1){
        if (x1 == 0) {
            swapColors(x1,y1,4,y1);
        } else if (x1 == 4) {
            swapColors(x1,y1,0,y1);
        } else if (y1 == 0) {
            swapColors(x1,y1,x1,4);
        } else if (y1 == 4) {
            swapColors(x1,y1,x1,0);
        }
        if (y1 == 1) {
            swapColors(1,0,3,0);
        } else if (y1 == 3) {
            swapColors(1,4,3,4);
        } else if (x1 == 1) {
            swapColors(0,1,0,3);
        } else if (x1 == 3) {
            swapColors(4,1,4,3);
        }
    }
}
