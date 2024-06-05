package com.mycompany.tranbajofinalprogii;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SecondaryController {

    int i = 0;
    @FXML
    GridPane carritoView = new GridPane();

    @FXML
    AnchorPane carritoTab = new AnchorPane();
    @FXML
    Button button = new Button();
    @FXML
    AnchorPane rowAdd = new AnchorPane();

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

    public AnchorPane rowadd() {
        AnchorPane rowadd = new AnchorPane();
        Label lbl = new Label();
        Button btt = new Button();
        
        Image img = new Image("file:src/main/resources/icons/imgNotFound.jpg");
        ImageView iv = new ImageView(img);
        iv.setFitHeight(150);
        iv.setFitWidth(162);
        iv.setLayoutX(66);
        iv.setLayoutY(25);
        iv.preserveRatioProperty().set(true);
        lbl.setPrefSize(330, 89);
        lbl.setLayoutX(253);
        lbl.setLayoutY(56);
        lbl.setFont(Font.font("System", FontWeight.BOLD, 24));
        lbl.setText("LoremIpsum");
        lbl.setTextFill(Color.BLACK);
        btt.setPrefSize(108, 43);
        btt.setLayoutX(557);
        btt.setLayoutY(145);
        btt.setFont(Font.font("System", FontWeight.BOLD, 12));
        btt.setText("Eliminar");
        btt.setGraphicTextGap(10);
        Image trashicon = new Image("file:src/main/resources/icons/trash.png");
        ImageView a = new ImageView(trashicon);
        a.setFitHeight(20);
        a.setFitWidth(20);
        btt.setGraphic(a);
        btt.setStyle("-fx-background-radius: 15;-fx-border-radius: 15;");

        rowadd.setPrefSize(Double.MAX_VALUE, 200);
        rowadd.getStylesheets().add("file:/" + System.getProperty("user.dir"
                + "").replace("\\", "/") + "/target/classes/com/mycompany/tranbajofinalprogii/StyleGradient.css");
        rowadd.getStyleClass().add("carritoLabel");
        rowadd.getChildren().add(lbl);
        rowadd.getChildren().add(btt);
        rowadd.getChildren().add(iv);
        return rowadd;
    }

    public void addElement() {
        carritoView.setPrefHeight(carritoHeight() + 200);
        carritoView.add(rowadd(), 0, i);

        i++;
    }

}
