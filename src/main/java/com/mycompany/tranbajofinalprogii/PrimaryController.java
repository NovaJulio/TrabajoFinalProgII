package com.mycompany.tranbajofinalprogii;

import java.io.IOException;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.StageStyle;
import javafx.util.Duration;

@SuppressWarnings("exports")
public class PrimaryController {

    @FXML
    public Pane registerPane;
    public Pane panel1;
    public Pane storeLabel;
    public Pane assetsStore;
    public Pane goOut;
    public Pane base;
    public AnchorPane anchorRoot;
    public AnchorPane confirmpassAnchor;
    public AnchorPane passReq;
    public Button logInButton;
    public Button registerButton;
    public TextField regUsername;
    public PasswordField regPass;
    public PasswordField regPassComfirm;

    public void setUp() {
        regPass.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, 
                    Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    System.out.println("Textfield on focus");
                } else {
                    System.out.println("Textfield out focus");
                }
            }
        });
    }

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
        FadeTransition fade2 = new FadeTransition(Duration.millis(500), panel1);
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

    public void getScene2() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("secondary.fxml"));
        Scene scene = logInButton.getScene();
        root.translateYProperty().set(scene.getHeight());
        base.getChildren().add(root);
        Timeline tl = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.LINEAR);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        tl.getKeyFrames().add(kf);
        tl.setOnFinished(event -> {
            base.getChildren().remove(anchorRoot);
        });

        tl.setDelay(Duration.millis(852));
        tl.play();
    }

    public boolean minReqPass(String pass) {
        char[] car = pass.toCharArray();
        int digitCount = 0;
        int upperCount = 0;
        int othersCount = 0;
        Alert a = new Alert(AlertType.ERROR);
        a.initStyle(StageStyle.UNDECORATED);
        if (car.length < 8) {
            a.setContentText("La contraseña tiene menos de 8 caracteres");
            a.show();
            return false;
        }
        for (int i = 0; i < car.length; i++) {
            if (Character.isDigit(car[i])) {
                digitCount++;
            } else if (Character.isUpperCase(car[i])) {
                upperCount++;
            } else if (Character.isAlphabetic(car[i])) {
            } else {
                othersCount++;
            }
        }
        if (digitCount < 4) {
            System.out.println("La contraseña debe contar con al menos 4 numeros");
            return false;
        } else if (upperCount == 0) {
            System.out.println("La contraseña debe contar con al menos una mayuscula");
            return false;
        } else if (othersCount < 3) {
            System.out.println("La contraseña debe contar con al menos 3 caracteres no alfanumericos");
            return false;
        } else {
            return true;
        }

    }

    public void registerAccount() {
        if (minReqPass(regPass.getText())) {
            System.out.println("La contraseña es valida");
        } else {

        }
    }

    public void regPassSelect() {
        TranslateTransition trans1 = new TranslateTransition(Duration.seconds(0.5), confirmpassAnchor);
        TranslateTransition trans2 = new TranslateTransition(Duration.seconds(0.5), registerButton);
        trans1.setByY(87);
        trans2.setByY(43);
        FadeTransition fade = new FadeTransition(Duration.seconds(0.2), passReq);
        fade.setDelay(Duration.seconds(0.45));
        fade.setByValue(1);
        trans1.play();
        trans2.play();
        fade.play();
    }
}
