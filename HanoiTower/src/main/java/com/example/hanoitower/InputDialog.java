package com.example.hanoitower;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class InputDialog {
    public static String getResponse(){
        TextInputDialog dialog=new TextInputDialog();
        dialog.setHeaderText("Size?");
        Optional<String> result=dialog.showAndWait();
        return result.orElse(null);
    }
}
