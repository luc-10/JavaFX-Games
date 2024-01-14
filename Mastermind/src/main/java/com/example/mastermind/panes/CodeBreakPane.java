package com.example.mastermind.panes;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CodeBreakPane extends VBox {
    private static boolean stopGame=false;
    public static final int attempts=10;
    private static SingleCodeBreakPane[] singleCodeBreakPanes;
    public CodeBreakPane(){
        super();
        singleCodeBreakPanes=new SingleCodeBreakPane[attempts];
        for (int i=0;i<attempts;i++){
            singleCodeBreakPanes[i]=new SingleCodeBreakPane();
            getChildren().add(singleCodeBreakPanes[i]);
        }
    }
    public static void endGame(boolean won){
        if (stopGame){
            return;
        }
        stopGame=true;
        for (int i=0;i<10;i++){
            singleCodeBreakPanes[i].setClickable(false);
        }
        VBox vBox=new VBox();
        Button closeButton=new Button("OK");
        closeButton.setOnMouseClicked(mouseEvent -> {
            Platform.exit();
        });
        Text txt=new Text();
        if (won){
            txt.setText("You won");
        } else {
            txt.setText("You lost");
        }
        vBox.getChildren().addAll(SetCodePane.getCodePane(),txt,closeButton);
        Scene scene=new Scene(vBox);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
