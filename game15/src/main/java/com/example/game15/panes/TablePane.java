package com.example.game15.panes;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Random;

public class TablePane extends GridPane {
    private CellPane[] cells;
    public static final int size=4;
    public TablePane(){
        super();
        createCells();
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                cells[i*4+j].setXY(i,j);
                super.add(cells[i*4+j],j,i);
            }
        }
    }
    private void createCells(){
        cells=new CellPane[16];
        for (int k=1;k<16;k++){
            cells[k-1]=new CellPane(k);
        }
        cells[15]=new CellPane(0);
    }
    public void shuffle(){
        int k=0;
        while(k<100){
            Random random=new Random();
            int x=random.nextInt(size);
            int y=random.nextInt(size);
            if (move(x,y)){
                k++;
            }
        }
    }
    public static CellPane getCellPaneAt(GridPane gp, int x, int y){
        for (Node n: gp.getChildren()){
            if (getRowIndex(n)==x && getColumnIndex(n)==y){
                return (CellPane) n;
            }
        }
        return null;
    }
    private static boolean isBound(int x, int y){
        return (x>=0 && x<size && y>=0 && y<size);
    }
    public static boolean move(int x, int y){
        if (isBound(x+1,y) && getCellPaneAt(MainPane.tablePane,x+1,y).isEmpty()){
            swapCellPanes(getCellPaneAt(MainPane.tablePane,x,y),getCellPaneAt(MainPane.tablePane,x+1,y));
            return true;
        }
        if (isBound(x-1,y) && getCellPaneAt(MainPane.tablePane,x-1,y).isEmpty()){
            swapCellPanes(getCellPaneAt(MainPane.tablePane,x,y),getCellPaneAt(MainPane.tablePane,x-1,y));
            return true;
        }
        if (isBound(x,y+1) && getCellPaneAt(MainPane.tablePane,x,y+1).isEmpty()){
            swapCellPanes(getCellPaneAt(MainPane.tablePane,x,y),getCellPaneAt(MainPane.tablePane,x,y+1));
            return true;
        }
        if (isBound(x,y-1) && getCellPaneAt(MainPane.tablePane,x,y-1).isEmpty()){
            swapCellPanes(getCellPaneAt(MainPane.tablePane,x,y),getCellPaneAt(MainPane.tablePane,x,y-1));
            return true;
        }
        return false;
    }
    public static void swapCellPanes(CellPane c1, CellPane c2){
        MainPane.tablePane.getChildren().remove(c1);
        MainPane.tablePane.getChildren().remove(c2);
        MainPane.tablePane.add(c2,c1.getY(),c1.getX());
        MainPane.tablePane.add(c1,c2.getY(),c2.getX());
        int x=c1.getX();
        int y=c1.getY();
        c1.setXY(c2.getX(),c2.getY());
        c2.setXY(x,y);
    }
}
