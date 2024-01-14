package com.example.mastermind.panes;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class CodePane extends HBox {
    public static final int size=4;
    public CodePane(){
        super();
        for (int i=0;i<size;i++){
            getChildren().add(new CellPane(Color.GRAY,true));
        }
    }
    public ArrayList<Color> getCode(){
        ArrayList<Color> ret=new ArrayList<>();
        for (Node n: getChildren()){
            ret.add(((CellPane) n).getColor());
        }
        return ret;
    }
    public void setClickable(boolean clickable){
        for (Node n: getChildren()){
            ((CellPane) n).setClickable(clickable);
        }
    }
    public static int check(ArrayList<Color> c1, ArrayList<Color> c2){ //c1 needs to be the solution
        int x=0, y=0;
        for (int i=0;i<c1.size();i++){
            if (c1.get(i).equals(c2.get(i))){
                c1.remove(i);
                c2.remove(i);
                i--;
                x++;
            }
        }
        for (Color color : c1) {
            for (int j = 0; j < c2.size(); j++) {
                if (color.equals(c2.get(j))) {
                    y++;
                    c2.remove(j);
                    break;
                }
            }
        }
        return x*10+y;
    }
}
