package com.example.hanoitower.panes;

import com.example.hanoitower.InputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.util.Objects;

public class MainPane extends BorderPane {
    private HanoiPane hanoiPane;
    public static int moves;
    private static Text txt;
    public MainPane(){
        super();
        boolean insertedNumber;
        int size=0;
        do{
            try {
                size = Integer.parseInt(Objects.requireNonNull(InputDialog.getResponse()));
                insertedNumber=true;
            } catch (NumberFormatException e){
                insertedNumber=false;
            }
        } while (!insertedNumber || size<=0);
        hanoiPane=new HanoiPane(size);
        setCenter(hanoiPane);
        moves=0;
        txt=new Text("Moves: "+moves);
        setTop(txt);
    }
    public static void updateText(){
        ++moves;
        txt.setText("Moves: "+moves);
    }
    public static int getMoves(){
        return moves;
    }
}
