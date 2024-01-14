package com.example.findimage.panes;

import javafx.scene.layout.GridPane;

import java.util.Objects;
import java.util.Random;

public class SolutionPane extends GridPane {
    private final int size=MainPane.size;
    SolutionPane(){
        super();
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                CellPane c=new CellPane();
                c.setNotClickable();
                super.add(c,j,i);
            }
        }
        initialiseSolutionPane();
    }
    private void initialiseSolutionPane(){
        Random random=new Random();
        for (int i=0;i<size*size*size;i++){
            Objects.requireNonNull(MainPane.getCellPaneAt(this, random.nextInt(size), random.nextInt(size))).click();
        }
    }
}
