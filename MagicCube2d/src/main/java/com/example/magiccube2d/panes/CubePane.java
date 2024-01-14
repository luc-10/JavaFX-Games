package com.example.magiccube2d.panes;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CubePane extends StackPane {
    CubePane(){
        super();
        Rectangle r=new Rectangle(50,50);
        r.setFill(Color.TRANSPARENT);
        getChildren().add(r);
    }
}
