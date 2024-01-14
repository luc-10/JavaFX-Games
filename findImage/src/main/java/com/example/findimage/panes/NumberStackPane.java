package com.example.findimage.panes;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Stack;

public class NumberStackPane extends StackPane {
    NumberStackPane(String s){
        super();
        getChildren().add(new Text(s));
    }
}
