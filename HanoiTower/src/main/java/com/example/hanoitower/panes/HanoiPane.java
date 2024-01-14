package com.example.hanoitower.panes;

import com.example.hanoitower.Hand;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static java.lang.Math.round;

public class HanoiPane extends TilePane {
    private final TowerPane[] t;
    private static Hand hand;
    public static int size;
    private boolean gameOver;
    public HanoiPane(int size){
        super();
        gameOver=false;
        HanoiPane.size =size;
        hand=new Hand();
        this.setAlignment(Pos.CENTER);
        this.setPrefColumns(3);
        this.setHgap(10);
        this.t=new TowerPane[3];
        this.t[0]=new TowerPane();
        this.t[1]=new TowerPane();
        this.t[2]=new TowerPane();
        this.getChildren().addAll(t[0],t[1],t[2]);
        this.t[0].start(size);
        initialise();
    }
    private void checkWin(){
        if (t[2].getSize()==size){
            Text txt=new Text("Minimum moves: "+round(Math.pow(2,size)-1)+"\nMoves: "+MainPane.getMoves());
            Button button=new Button("OK");
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    Platform.exit();
                }
            });
            VBox vBox=new VBox();
            vBox.getChildren().addAll(txt,button);
            Scene scene=new Scene(vBox);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
            gameOver=true;
        }
    }
    private void initialise(){
        for (TowerPane towerPane: t){
            towerPane.setOnMouseClicked(mouseEvent -> {
                if (gameOver){
                    return;
                }
                if (hand.isHandEmpty()){
                    if (!towerPane.isEmpty()) {
                        hand.putInHand(towerPane.takeFromTower());
                    }
                } else {
                    if (towerPane.canPlaceOnTower(hand.seeHand())){
                        towerPane.placeOnTower(hand.getFromHand());
                        if (!towerPane.isTakenFrom()){
                            MainPane.updateText();
                        }
                        resetTakenFrom();
                        checkWin();
                    }
                }
            });
        }
    }
    private void resetTakenFrom(){
        for (int i=0;i<3;i++){
            t[i].resetTakenFrom();
        }
    }
}
