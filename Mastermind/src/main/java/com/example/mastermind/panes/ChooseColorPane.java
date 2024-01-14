package com.example.mastermind.panes;

import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ChooseColorPane extends TilePane {
    public static Color color;
    public ChooseColorPane(){
        super();
        setPrefColumns(4);
        setPrefRows(2);
        getChildren().addAll(new CellPane(Color.RED,false),new CellPane(Color.GREEN,false),
                             new CellPane(Color.BLUE,false),new CellPane(Color.YELLOW,false),
                             new CellPane(Color.ORANGE,false),new CellPane(Color.PURPLE,false),
                             new CellPane(Color.WHITE,false),new CellPane(Color.BLACK,false));
    }

}
