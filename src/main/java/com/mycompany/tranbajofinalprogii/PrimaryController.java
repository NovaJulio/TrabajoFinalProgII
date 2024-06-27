package com.mycompany.tranbajofinalprogii;

import java.io.IOException;

import com.mycompany.tranbajofinalprogii.Logic.cuenta;

import javafx.animation.*;
import javafx.beans.value.*;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.util.Duration;

@SuppressWarnings("exports")
public class PrimaryController {

    @FXML
    public Pane registerPane, panel1, storeLabel, assetsStore, goOut, base;
    public AnchorPane anchorRoot, confirmpassAnchor, passReq;
    public Button logInButton, registerButton;
    public TextField regUsername, logInUsername;
    public PasswordField regPass, regPassComfirm, logInPassword;
    public Label c0, c1, c2, c3, c4, confirmPassLabel;

    public void setUp() {
        regPass.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0,
                    Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    regPassInFocus();
                } else {
                    regPassOutfocus();
                }
            }
        });
    }

    public void cerra() {
        System.exit(0);
    }

    // Lleva la pantalla a registrar
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

    // Devuelve la pantalla a login
    public void goToLogIn() {
        FadeTransition fade = new FadeTransition();
        fade.setNode(registerPane);
        fade.setInterpolator(Interpolator.EASE_IN);
        ;
        fade.setDuration(Duration.millis(500));
        fade.setToValue(0);
        fade.play();
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(goOut);
        translate.setInterpolator(Interpolator.EASE_IN);
        ;
        translate.setDelay(Duration.millis(500));
        translate.setDuration(Duration.millis(1000));
        translate.setByX(-515);
        translate.play();
        FadeTransition fade2 = new FadeTransition();
        fade2.setNode(panel1);
        fade2.setInterpolator(Interpolator.EASE_IN);
        ;
        fade2.setToValue(1);
        fade2.setDelay(Duration.millis(translate.getDelay().toMillis() + 1000));
        fade2.play();
    }

    // Animacion antes de cambiar
    public void goToPage() throws IOException {
        FadeTransition fade2 = new FadeTransition(Duration.seconds(0.5), panel1);
        fade2.setInterpolator(Interpolator.EASE_IN);
        fade2.setFromValue(1);
        fade2.setToValue(0);
        fade2.play();
        ScaleTransition scale = new ScaleTransition();
        scale.setInterpolator(Interpolator.EASE_IN);
        scale.setNode(storeLabel);
        scale.setToX(464);
        scale.setDuration(Duration.seconds(15));
        scale.setDelay(Duration.seconds(0.5));
        scale.play();
        TranslateTransition trans = new TranslateTransition();
        trans.setInterpolator(Interpolator.EASE_IN);
        trans.setNode(assetsStore);
        trans.setDelay(Duration.seconds(0.5));
        trans.setToX(232);
        trans.play();
        TranslateTransition trans1 = new TranslateTransition();
        trans1.setInterpolator(Interpolator.LINEAR);
        trans1.setNode(goOut);
        trans1.setToY(-682);
        trans1.setDelay(Duration.seconds(1));
        trans1.setDuration(Duration.seconds(0.5));
        trans1.play();
        getScene2();
    }

    // Cambia de pagina a la tienda
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

    // Validador de contraseñas
    public int minReqPass(String pass) {
        char[] car = pass.toCharArray();
        int digitCount = 0;
        int upperCount = 0;
        int othersCount = 0;

        if (car.length < 8) {
            return 1;
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
            return 2;
        } else if (upperCount < 1) {
            return 3;
        } else if (othersCount < 3) {
            return 4;
        } else {
            return 0;
        }

    }

    // Accion de registrar cuenta
    public void registerAccount() throws IOException {
        Alert a = new Alert(AlertType.ERROR);
        a.initStyle(StageStyle.UNDECORATED);
        switch (minReqPass(regPass.getText())) {
            case 0:
                break;
            case 1:
                a.setContentText("La contraseña tiene menos de 8 caracteres");
                a.show();
                return;
            case 2:
                a.setContentText("La contraseña debe contar con al menos 4 numeros");
                a.show();
                return;
            case 3:
                a.setContentText("La contraseña debe contar con al menos una mayuscula");
                a.show();
                return;
            case 4:
                a.setContentText("La contraseña debe contar con al menos 3 caracteres no alfanumericos");
                a.show();
                return;
        }

        if (warningPassConfirm()) {
            cuenta info = new cuenta(regUsername.getText(), regPass.getText());
            App.listCuentas.createnode(info);
            regUsername.setText("");
            regPass.setText("");
            regPassComfirm.setText("");
            cuenta j = (cuenta) App.listCuentas.cab;
            System.out.println(j.carrito.isEmpty());
        } else {
            a.setContentText("Las contraseñas no son iguales");
            a.show();
        }

    }

    // Animaciones de sugerencias de contraseñas
    public void regPassInFocus() {
        TranslateTransition trans1 = new TranslateTransition(Duration.seconds(0.2), confirmpassAnchor);
        TranslateTransition trans2 = new TranslateTransition(Duration.seconds(0.2), registerButton);
        TranslateTransition trans3 = new TranslateTransition(Duration.seconds(0.2), confirmPassLabel);
        trans1.setByY(87);
        trans3.setByY(87);
        trans2.setByY(confirmPassLabel.isVisible() ? 53 : 43);
        FadeTransition fade = new FadeTransition(Duration.seconds(0.1), passReq);
        fade.setDelay(Duration.seconds(0.17));
        fade.setToValue(1);
        trans1.play();
        trans2.play();
        trans3.play();
        fade.play();
    }

    public void regPassOutfocus() {
        FadeTransition fade = new FadeTransition(Duration.seconds(0.1), passReq);
        fade.setToValue(0);
        TranslateTransition trans1 = new TranslateTransition(Duration.seconds(0.2), confirmpassAnchor);
        TranslateTransition trans2 = new TranslateTransition(Duration.seconds(0.2), registerButton);
        TranslateTransition trans3 = new TranslateTransition(Duration.seconds(0.2), confirmPassLabel);
        trans1.setDelay(Duration.seconds(0.12));
        trans2.setDelay(Duration.seconds(0.12));
        trans3.setDelay(Duration.seconds(0.12));
        trans1.setByY(-87);
        trans3.setByY(-87);
        trans2.setByY(confirmPassLabel.isVisible() ? -53 : -43);
        trans1.play();
        trans2.play();
        trans3.play();
        fade.play();
    }

    // Advertencia de contraseña
    public void warningPass() {
        switch (minReqPass(regPass.getText())) {
            case 0:
                c0.setTextFill(Color.rgb(164, 164, 164));
                c1.setTextFill(Color.rgb(164, 164, 164));
                c2.setTextFill(Color.rgb(164, 164, 164));
                c3.setTextFill(Color.rgb(164, 164, 164));
                c4.setTextFill(Color.rgb(164, 164, 164));
                break;
            case 1:
                c0.setTextFill(Color.rgb(164, 164, 164));
                c1.setTextFill(Color.RED);
                c2.setTextFill(Color.rgb(164, 164, 164));
                c3.setTextFill(Color.rgb(164, 164, 164));
                c4.setTextFill(Color.rgb(164, 164, 164));
                break;
            case 2:
                c0.setTextFill(Color.rgb(164, 164, 164));
                c1.setTextFill(Color.rgb(164, 164, 164));
                c2.setTextFill(Color.RED);
                c3.setTextFill(Color.rgb(164, 164, 164));
                c4.setTextFill(Color.rgb(164, 164, 164));
                break;
            case 3:
                c0.setTextFill(Color.rgb(164, 164, 164));
                c1.setTextFill(Color.rgb(164, 164, 164));
                c2.setTextFill(Color.rgb(164, 164, 164));
                c3.setTextFill(Color.RED);
                c4.setTextFill(Color.rgb(164, 164, 164));
                break;
            case 4:
                c0.setTextFill(Color.rgb(164, 164, 164));
                c1.setTextFill(Color.rgb(164, 164, 164));
                c2.setTextFill(Color.rgb(164, 164, 164));
                c3.setTextFill(Color.rgb(164, 164, 164));
                c4.setTextFill(Color.RED);
                break;
            default:
                break;
        }
    }

    public boolean warningPassConfirm() {
        if (!regPass.getText().equals(regPassComfirm.getText())) {
            confirmPassLabel.setVisible(true);
            return false;
        } else {
            confirmPassLabel.setVisible(false);
            return true;
        }
    }

    // Iniciar sesion
    public void logIn() {
        String password = logInPassword.getText();
        String username = logInUsername.getText();
        cuenta j = (cuenta) App.listCuentas.cab;
        j = getUsernameAccount(username, j);
        if (!j.username.equals(username)) {
            System.out.println("No se ha encontrado la cuenta");
            return;
        }
        if (!j.password.equals(password)) {
            System.out.println("Contraseña incorrecta");
            return;
        }
        App.currentAccount = j;
        try {
            goToPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private cuenta getUsernameAccount(String username, cuenta j) {
        do {
            if (j.username.equals(username)) {
                return j;
            } else {
                j = (cuenta) j.next;
            }
        } while (j != App.listCuentas.cab);
        return j;
    }

}
