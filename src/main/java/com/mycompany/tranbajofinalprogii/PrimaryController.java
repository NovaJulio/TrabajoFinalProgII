package com.mycompany.tranbajofinalprogii;

import java.io.IOException;
import javafx.animation.*;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class PrimaryController {

    @FXML
    public Pane registerPane;
    @FXML
    public Pane panel1;
    @FXML
    public Pane storeLabel;
    @FXML
    public Pane assetsStore;
    @FXML
    public Pane goOut;
    @FXML
    public Pane base;
    @FXML
    public AnchorPane anchorRoot;
    @FXML
    public Button logInButton;

    public void cerra() {
        System.exit(0);
    }

    public void goToRegister() {
        FadeTransition fade2 = new FadeTransition();
        fade2.setNode(panel1);
        fade2.setDuration(Duration.millis(500));
        fade2.setFromValue(1);
        fade2.setToValue(0);
        fade2.play();
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(goOut);
        translate.setDelay(Duration.millis(500));
        translate.setDuration(Duration.millis(1000));
        translate.setByX(515);
        translate.play();
        FadeTransition fade = new FadeTransition();
        fade.setNode(registerPane);
        fade.setToValue(1);
        fade.setDelay(Duration.millis(translate.getDelay().toMillis() + 1000));
        fade.play();
    }

    public void goToLogIn() {
        FadeTransition fade = new FadeTransition();
        fade.setNode(registerPane);
        fade.setInterpolator(Interpolator.EASE_IN);;
        fade.setDuration(Duration.millis(500));
        fade.setToValue(0);
        fade.play();
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(goOut);
        translate.setInterpolator(Interpolator.EASE_IN);;
        translate.setDelay(Duration.millis(500));
        translate.setDuration(Duration.millis(1000));
        translate.setByX(-515);
        translate.play();
        FadeTransition fade2 = new FadeTransition();
        fade2.setNode(panel1);
        fade2.setInterpolator(Interpolator.EASE_IN);;
        fade2.setToValue(1);
        fade2.setDelay(Duration.millis(translate.getDelay().toMillis() + 1000));
        fade2.play();
    }

    public void goToPage() throws IOException {
        FadeTransition fade2 = new FadeTransition(Duration.millis(500),panel1);
        fade2.setInterpolator(Interpolator.EASE_IN);
        fade2.setFromValue(1);
        fade2.setToValue(0);
        fade2.play();
        ScaleTransition scale = new ScaleTransition();
        scale.setInterpolator(Interpolator.EASE_IN);
        scale.setNode(storeLabel);
        scale.setToX(464);
        scale.setDuration(Duration.seconds(15));
        scale.setDelay(Duration.millis(500));
        scale.play();
        TranslateTransition trans = new TranslateTransition();
        trans.setInterpolator(Interpolator.EASE_IN);
        trans.setNode(assetsStore);
        trans.setDelay(Duration.millis(500));
        trans.setToX(232);
        trans.play();
        TranslateTransition trans1 = new TranslateTransition();
        trans1.setInterpolator(Interpolator.LINEAR);
        trans1.setNode(goOut);
        trans1.setToY(-682);
        trans1.setDelay(Duration.millis(1000));
        trans1.setDuration(Duration.millis(1000));
        trans1.play();
        getScene2();
    }
    public void getScene2() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("secondary.fxml"));
        Scene scene = logInButton.getScene();
        root.translateYProperty().set(scene.getHeight());
        base.getChildren().add(root);
        Timeline tl =new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.LINEAR);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        tl.getKeyFrames().add(kf);
        tl.setOnFinished(event->{
            base.getChildren().remove(anchorRoot);
        });
        
        tl.setDelay(Duration.millis(852));
        tl.play();
    }
}
