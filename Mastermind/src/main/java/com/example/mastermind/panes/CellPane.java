package com.example.mastermind.panes;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CellPane extends StackPane {
    public static final int cellSize=60;
    private Color color;
    private boolean clickable;
    private final Rectangle r;
    public CellPane(Color color, boolean changeable){
        this.color=color;
        clickable=true;
        r=new Rectangle(cellSize,cellSize);
        r.setFill(color);
        r.setStroke(Color.BLACK);
        getChildren().add(r);
        setOnMouseClicked(mouseEvent -> {
            if (!clickable){
                return;
            }
            if (changeable){
                setColor(ChooseColorPane.color);
            } else {
                ChooseColorPane.color=this.color;
            }
        });
    }
    void setColor(Color color){
        this.color=color;
        r.setFill(color);
    }

    public Color getColor() {
        return color;
    }
    public void setClickable(boolean clickable){
        this.clickable=clickable;
    }
}
