package com.example.findimage.panes;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.Objects;

public class TablePane extends GridPane {
    private final int size=MainPane.size;
    private final SolutionPane solutionPane;
    TablePane(SolutionPane solutionPane){
        super();
        this.solutionPane=solutionPane;
        for (int i=1;i<size+1;i++){
            for (int j=1;j<size+1;j++){
                super.add(new CellPane(),j,i);
            }
        }
        for (int k=0;k<size;k++){
            super.add(new NumberStackPane(sumRow(k)),0,k+1);
            super.add(new NumberStackPane(sumCol(k)),k+1,0);
        }
    }
    boolean check(){
        boolean ret=true;
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                CellPane cellOnTable=MainPane.getCellPaneAt(this,i+1,j+1);
                assert cellOnTable != null;
                if (!(Objects.requireNonNull(MainPane.getCellPaneAt(solutionPane, i, j)).equals(cellOnTable))){
                    ret=false;
                    if (cellOnTable.isNotWhite()){
                        //cellOnTable.setWrong();
                    }
                }
            }
        }
        return ret;
    }
    SolutionPane getSolutionPane(){
        return solutionPane;
    }
    void setNotClickable(){
        for (Node n: this.getChildren()){
            if (n instanceof CellPane){
                ((CellPane) n).setNotClickable();
            }
        }
    }
    private String sumRow(int row){
        boolean empty=true;
        String ret="";
        int k=0;
        for (int j=0;j<size;j++) {
            if (Objects.requireNonNull(MainPane.getCellPaneAt(solutionPane, row, j)).isNotWhite()){
                k++;
                empty=false;
            } else {
                if (k!=0){
                    ret=ret+" "+k;
                }
                k=0;
            }
        }
        if (k!=0){
            ret=ret+" "+k;
        } else if (empty){
            ret=ret+" 0";
        }
        return ret;
    }
    private String sumCol(int col){
        boolean empty=true;
        String ret="";
        int k=0;
        for (int i=0;i<size;i++){
            if (Objects.requireNonNull(MainPane.getCellPaneAt(solutionPane, i, col)).isNotWhite()){
                k++;
                empty=false;
            } else {
                if (k!=0){
                    ret=ret+"\n"+k;
                }
                k=0;
            }
        }
        if (k!=0){
            ret=ret+"\n"+k;
        } else if (empty){
            ret=ret+"\n0";
        }
        return ret;
    }
}
