package com.example.mastermind.panes;

import com.example.mastermind.Main;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {
    private ChooseColorPane chooseColorPane;
    private final SetCodePane setCodePane;
    private CodeBreakPane codeBreakPane;

    public MainPane(){
        super();
        chooseColorPane=new ChooseColorPane();
        setBottom(chooseColorPane);
        setCodePane=new SetCodePane();
        setCenter(setCodePane);
        Button randomButton = new Button("Random");
        randomButton.setOnMouseClicked(mouseEvent -> {
            setCodePane.putRandomColors();
            Main.startCodeBreak();
        });
        setTop(randomButton);
    }
    public void startCodeBreak(){
        setCenter(null);
        setTop(null);
        codeBreakPane=new CodeBreakPane();
        setCenter(codeBreakPane);
    }
}
