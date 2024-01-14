package com.example.findimage.panes;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CellPane extends StackPane {
    protected boolean clickable=true;
    private boolean isWhite=true;
    private final Rectangle r=new Rectangle(50,50);
    CellPane(){
        super();
        r.setFill(Color.WHITE);
        r.setStroke(Color.BLACK);
        getChildren().add(r);
        setOnMouseClicked(mouseEvent -> {
            if (clickable){
                click();
            }
        });
    }
    final void click(){
        if (isWhite){
            r.setFill(Color.GRAY);
            isWhite=false;
        } else {
            r.setFill(Color.WHITE);
            isWhite=true;
        }
    }
    final void setNotClickable(){
        this.clickable= false;
    }

    final public boolean isNotWhite() {
        return !isWhite;
    }
    final boolean equals(CellPane c){
        return (isWhite==c.isWhite);
    }
    final void setWrong(){
        isWhite=true;
        clickable=false;
        r.setFill(Color.RED);
    }
}
