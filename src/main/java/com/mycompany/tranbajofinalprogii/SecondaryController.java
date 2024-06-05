package com.mycompany.tranbajofinalprogii;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

public class SecondaryController {

    int i = 0;
    @FXML
    GridPane carritoView = new GridPane();

    @FXML
    AnchorPane carritoTab = new AnchorPane();
    @FXML
    Button button = new Button();

    public void cerra() {
        System.exit(0);
    }

    public double carritoHeight() {
        if (carritoView.getRowCount() == 0) {
            return 0;
        } else {
            return carritoView.getRowCount() * 200;
        }
    }

    public void addElement() {
        carritoView.setPrefHeight(carritoHeight()+200);
        AnchorPane rowadd = new AnchorPane();
        rowadd.setPrefSize(Double.MAX_VALUE, 200);
        rowadd.getStylesheets().add("file:/"+System.getProperty("user.dir").replace("\\", "/")+ "/target/classes/com/mycompany/tranbajofinalprogii/StyleGradient.css");
        rowadd.getStyleClass().add("carritoLabel");
        carritoView.add(rowadd, 0, i);
        
        i++;
    }

}
