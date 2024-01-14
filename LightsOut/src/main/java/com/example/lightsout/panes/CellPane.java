package com.example.lightsout.panes;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CellPane extends StackPane {
    private final Rectangle bg;
    private final int x;
    private final int y;
    private boolean dark;
    public CellPane(int x, int y){
        super();
        this.x=x;
        this.y=y;
        bg=new Rectangle(50,50);
        bg.setStroke(Color.BLACK);
        bg.setFill(Color.GRAY);
        dark=true;
        getChildren().add(bg);
        setOnMouseClicked(mouseEvent -> click());
    }

    public boolean isLight() {
        return !dark;
    }

    private boolean isBound(int x, int y){
        return (x>=0 && x<TablePane.size && y>=0 && y<TablePane.size);
    }
    public void click(){
        clickOnSingleCell();
        if (isBound(x+1,y)){
            TablePane.getCellPaneAt(MainPane.tp,x+1,y).clickOnSingleCell();
        }
        if (isBound(x-1,y)){
            TablePane.getCellPaneAt(MainPane.tp,x-1,y).clickOnSingleCell();
        }
        if (isBound(x,y+1)){
            TablePane.getCellPaneAt(MainPane.tp,x,y+1).clickOnSingleCell();
        }
        if (isBound(x,y-1)){
            TablePane.getCellPaneAt(MainPane.tp,x,y-1).clickOnSingleCell();
        }
        if(TablePane.checkWin(MainPane.tp)){
            VBox vBox=new VBox();
            Button button=new Button("OK");
            button.setOnMouseClicked(mouseEvent -> {
                Platform.exit();
            });
            vBox.getChildren().addAll(new Text(MainPane.getTxtString()),button);
            Scene scene=new Scene(vBox);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }
    private void clickOnSingleCell(){
        if (dark){
            dark=false;
            bg.setFill(Color.WHITE);
        } else {
            dark=true;
            bg.setFill(Color.GRAY);
        }
    }
}
