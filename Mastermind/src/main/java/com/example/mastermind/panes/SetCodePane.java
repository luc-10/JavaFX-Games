package com.example.mastermind.panes;

import com.example.mastermind.Main;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class SetCodePane extends VBox {
    private static CodePane codePane;
    private final Button setCodeButton;
    public SetCodePane(){
        codePane=new CodePane();
        setCodeButton=new Button("Start");
        setCodeButton.setDisable(true);
        getChildren().addAll(codePane,setCodeButton);
        setOnMouseClicked(mouseEvent -> {
            if (canStart()){
                setCodeButton.setDisable(false);
            }
        });
        setCodeButton.setOnMouseClicked(mouseEvent -> {
            Main.startCodeBreak();
        });
    }
    private boolean canStart(){
        for (Color c: codePane.getCode()){
            if (c.equals(Color.GRAY)){
                return false;
            }
        }
        return true;
    }
    public static ArrayList<Color> getCode(){
        return codePane.getCode();
    }
    public static CodePane getCodePane(){
        return codePane;
    }
    public void putRandomColors(){
        for (int i=0;i<CodePane.size;i++){
            ((CellPane) codePane.getChildren().get(i)).setColor(getRandomColor());
        }
    }
    private Color getRandomColor(){
        Random random=new Random();
        switch (random.nextInt(8)){
            case 0:
                return Color.RED;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.ORANGE;
            case 5:
                return Color.PURPLE;
            case 6:
                return Color.WHITE;
            case 7:
                return Color.BLACK;
        }
        return null;
    }
}
