package com.mycompany.tranbajofinalprogii;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mycompany.tranbajofinalprogii.Logic.Elemento;
import com.mycompany.tranbajofinalprogii.Logic.node;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;

@SuppressWarnings("exports")
public class SecondaryController implements Initializable {

    int i = 0;
    int cacheImg = 0;
    @FXML
    public GridPane carritoView;
    public AnchorPane carritoTab, rowAdd;
    public Button button, buttonAddElementTienda, addImageButton;
    public TextField addNameToShop, AddPriceToShop, imageDirTextField;
    public ComboBox selectProductTag;
    public Tab opOptions, tab1;
    public ImageView addImageToShop;
    private boolean all;

    public void cerra() {
        System.exit(0);
    }

    public void setUp() {

        if (App.currentAccount.isAdmin) {
            System.out.println(App.currentAccount.isAdmin + "\n" + button.isDisable());
            opOptions.setDisable(false);
        } else {
            opOptions.setDisable(true);
        }
    }

    public double carritoHeight() {
        if (carritoView.getRowCount() == 0) {
            return 0;
        } else {
            return carritoView.getRowCount() * 200;
        }
    }

    // Funcion que crea los paneles del carrito
    public AnchorPane rowAddCarrito() {

        // Creando los elementos de la fila
        AnchorPane rowadd = new AnchorPane();
        Label lbl = new Label();
        Button btt = new Button();
        Image img = new Image("file:src/main/resources/icons/imgNotFound.jpg");
        ImageView iv = new ImageView(img);

        // Asignando las caracteristicas a el elemento de la imagen
        iv.setFitHeight(150);
        iv.setFitWidth(162);
        iv.setLayoutX(66);
        iv.setLayoutY(25);
        iv.preserveRatioProperty().set(true);

        // Asignando las caracteristicas al label principal
        lbl.setPrefSize(330, 89);
        lbl.setLayoutX(253);
        lbl.setLayoutY(20);
        lbl.setFont(Font.font("System", FontWeight.BOLD, 24));
        lbl.setText("LoremIpsum");
        lbl.setTextFill(Color.BLACK);

        // Asignando las caracteristicas al boton
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
        btt.setOnAction(e -> {
            // Hay que añadir la funcion de eliminar el elemento
        });
        btt.setStyle("-fx-background-radius: 15;-fx-border-radius: 15;");

        // Asignando las caracteristicas al panel principal que contiene todo
        rowadd.setPrefSize(Double.MAX_VALUE, 200);
        rowadd.getStylesheets().add("file:/" + System.getProperty("user.dir"
                + "").replace("\\", "/") + "/target/classes/com/mycompany/tranbajofinalprogii/StyleGradient.css");
        rowadd.getStyleClass().add("carritoLabel");
        rowadd.getChildren().add(lbl);
        rowadd.getChildren().add(btt);
        rowadd.getChildren().add(iv);
        return rowadd;
    }

    public void addElementToCarrito() {
        carritoView.setPrefHeight(carritoHeight() + 200);
        carritoView.add(rowAddCarrito(), 0, i);
        i++;
    }

    // Funcion que añade el elemento a la tienda
    public void addElementToTienda() throws IOException {
        Alert errorPanel = new Alert(AlertType.ERROR);
        errorPanel.initStyle(StageStyle.UNDECORATED);
        System.out.println("Prueba");

        // Comprobacion
        if (addNameToShop.getText().isBlank() || imageDirTextField.getText().isBlank()
                || selectProductTag.getValue().toString().isBlank() || AddPriceToShop.getText().isBlank()) {
            errorPanel.setContentText("Ningun campo puede estar vacio, verifique los datos");
            errorPanel.show();
            return;
        }

        Elemento auxiliar = new Elemento(addNameToShop.getText(), imageDirTextField.getText(),
                selectProductTag.getValue().toString(),
                Integer.parseInt(AddPriceToShop.getText()));
        App.shop.createnode(auxiliar);
    }

    // Funcion para seleccionar la imagen
    public void selectImage() throws IOException {
        Alert errorPanel = new Alert(AlertType.ERROR);
        errorPanel.initStyle(StageStyle.UNDECORATED);
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(App.getStage());
        if (!file.exists()) {
            errorPanel.setContentText("La ruta dada no es valida");
            errorPanel.show();
            return;
        }
        imageDirTextField.setText(file.getAbsolutePath());
        Image img = new Image(file.toURI().toString());
        addImageToShop.setImage(img);
    }

    // Funcion para copiar la imagen a el directorio interno
    private String copyImage() {
        return null;
    }

    // Funcion que crea los paneles de la tienda
    public AnchorPane AddTienda(node elemento) {
        Elemento elementoAAñadir = (Elemento) elemento;
        // Creando los elementos
        AnchorPane addtienda = new AnchorPane();
        Label lbl = new Label();
        Label lbl2 = new Label();
        Label lbl3 = new Label();
        Button btt = new Button();
        Button btt2 = new Button();
        Image img = new Image(elementoAAñadir.imgDir);
        ImageView iv = new ImageView(img);

        // Asignando las caracteristicas a el elemento de la imagen
        iv.setFitWidth(338);
        iv.setFitHeight(495);
        iv.setLayoutX(14);
        iv.setLayoutY(14);
        iv.preserveRatioProperty().set(true);

        // Asignando las caracteristicas a los labels
        lbl.setPrefSize(311, 37);
        lbl.setLayoutX(14);
        lbl.setLayoutY(6);
        lbl.setFont(Font.font("System", FontWeight.BOLD, 24));
        lbl.setText(elementoAAñadir.elementName);
        lbl.setTextFill(Color.BLACK);

        lbl2.setPrefSize(311, 37);
        lbl2.setLayoutX(14);
        lbl2.setLayoutY(340);
        lbl2.setFont(Font.font("System", FontWeight.BOLD, 24));
        lbl2.setText(elementoAAñadir.price + "");
        lbl2.setTextFill(Color.BLACK);

        lbl3.setPrefSize(311, 37);
        lbl3.setLayoutX(14);
        lbl3.setLayoutY(377);
        lbl3.setFont(Font.font("System", FontWeight.BOLD, 24));
        lbl3.setText(elementoAAñadir.tag);
        lbl3.setTextFill(Color.BLACK);

        // Asignando las caracteristicas a los botones
        btt.setPrefSize(119, 55);
        btt.setLayoutX(43);
        btt.setLayoutY(418);
        btt.setFont(Font.font("System", FontWeight.BOLD, 12));
        btt.setText("Carrito");
        Image carrito = new Image("file:src/main/resources/icons/carrito.png");
        ImageView a = new ImageView(carrito);
        a.setFitHeight(30);
        a.setFitWidth(30);
        btt.setOnAction(e -> {
            // Hay que añadir la funcion de añadir el elemento al carro
        });

        btt2.setPrefSize(119, 55);
        btt2.setLayoutX(43);
        btt2.setLayoutY(418);
        btt2.setFont(Font.font("System", FontWeight.BOLD, 12));
        btt2.setText("Deseos");
        Image deseos = new Image("file:src/main/resources/icons/Corazon.png");
        ImageView b = new ImageView(deseos);
        b.setFitHeight(30);
        b.setFitWidth(30);
        btt.setOnAction(e -> {
            // Hay que añadir la funcion de añadir el elemento a favoritos
        });

        // Asignando las caracteristicas al panel principal que contiene todo
        addtienda.setPrefSize(338, 495);
        addtienda.getStylesheets().add("file:/" + System.getProperty("user.dir"
                + "").replace("\\", "/") + "/target/classes/com/mycompany/tranbajofinalprogii/StyleGradient.css");
        addtienda.getStyleClass().add("carritoLabel");
        addtienda.getChildren().add(lbl);
        addtienda.getChildren().add(lbl2);
        addtienda.getChildren().add(lbl3);
        addtienda.getChildren().add(btt);
        addtienda.getChildren().add(btt2);
        addtienda.getChildren().add(iv);

        return addtienda;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (App.currentAccount.isAdmin) {
            opOptions.setDisable(false);
        } else {
            opOptions.setDisable(true);
        }

        // Añadiendo los tags a selectProductTag
        selectProductTag.getItems().addAll("Skin");
        selectProductTag.getItems().addAll("Pico");
        selectProductTag.getItems().addAll("Mochila");
        selectProductTag.getItems().addAll("Envoltorio");
    }

}