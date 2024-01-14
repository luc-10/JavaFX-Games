package com.example.mastermind.panes;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import static com.example.mastermind.panes.CodeBreakPane.attempts;

public class SingleCodeBreakPane extends HBox {
    public static int trys=attempts;
    private final CodePane codePane;
    private final HintPane hintPane;
    private final Button checkButton;
    public SingleCodeBreakPane(){
        super();
        codePane=new CodePane();
        hintPane=new HintPane();
        checkButton=new Button("Check");
        checkButton.setOnMouseClicked(mouseEvent -> {
            checkButton.setDisable(true);
            hintPane.activate(CodePane.check(SetCodePane.getCode(),codePane.getCode()));
            codePane.setClickable(false);
            trys--;
            if (trys==0){
                CodeBreakPane.endGame(false);
            }
        });
        getChildren().addAll(codePane,hintPane,checkButton);
    }
    public void setClickable(boolean clickable){
        codePane.setClickable(clickable);
    }
}
