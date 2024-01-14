package com.example.magiccube2d.panes;

import com.example.magiccube2d.Main;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorPane extends CubePane {
    private Color color;
    private final Rectangle rectangle;
    private int x, y;
    ColorPane(Color color, Pos position){
        super();
        this.color=color;
        if (position.equals(Pos.TOP_CENTER) || position.equals(Pos.BOTTOM_CENTER)){
            rectangle=new Rectangle(45,5);
        } else {
            rectangle=new Rectangle(5,45);
        }
        setAlignment(position);
        rectangle.setFill(color);
        getChildren().add(rectangle);
        setOnMouseClicked(mouseEvent -> Main.mainPane.swap(x,y));
    }
    Color getColor(){
        return color;
    }
    void setXY(int x, int y){
        this.x=x;
        this.y=y;
    }
    void setColor(Color color){
        rectangle.setFill(color);
        this.color=color;
    }
}
