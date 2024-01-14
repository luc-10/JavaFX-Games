package com.example.lightsout.panes;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class TablePane extends GridPane {
    public static int size=9;
    public TablePane(){
        super();
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                super.add(new CellPane(i,j),j,i);
            }
        }
    }
    public void solve() throws InterruptedException {
        for (int i=0;i<size-1;i++){
            for (int j=0;j<size;j++){
                if (getCellPaneAt(this, i, j).isLight()){
                    getCellPaneAt(this,i+1,j).click();
                    return;
                }
            }
        }
        getCellPaneAt(this,0,0).click();
    }
    public void startGame(){
        Random random=new Random();
        for (int i=0;i<100;i++){
            ((CellPane )this.getChildren().get(random.nextInt(size*size))).click();
        }
    }
    public static boolean checkWin(GridPane gp){
        MainPane.updateMoves();
        for (Node n: gp.getChildren()){
            if (((CellPane) n).isLight()){
                return false;
            }
        }
        return true;
    }
    public static CellPane getCellPaneAt(GridPane gp, int x, int y){
        for (Node n: gp.getChildren()){
            if (getRowIndex(n)==x && getColumnIndex(n)==y){
                return (CellPane) n;
            }
        }
        return null;
    }
}
