package com.mycompany.tranbajofinalprogii;

import com.mycompany.tranbajofinalprogii.Logic.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

public class App extends Application {
    private static Stage stage;
    @SuppressWarnings("exports")
    public static list listCuentas = new list();
    @SuppressWarnings("exports")
    public static cuenta currentAccount;
    @SuppressWarnings("exports")
    public static list currentWishList = new list();
    @SuppressWarnings("exports")
    public static list currentCarrito = new list();
    @SuppressWarnings("exports")
    public static list currentHistory = new list();
    @SuppressWarnings("exports")
    public static list shop = new list();

    private static Scene scene;
    static PrimaryController o;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        App.stage = stage;
        scene = new Scene(loadFXML("primary"), 1116, 682);
        o.setUp();
        stage.setScene(scene);
        Image icon = new Image("file:src/main/resources/icons/84f06681-fd7f-4a69-afae-cf77700183ea.png");
        stage.getIcons().add(icon);
        stage.setTitle("FortniteStore");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        o = new PrimaryController();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setController(o);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        try {
            listCuentas.importList(System.getProperty("user.dir") +
                    "\\src\\main\\resources\\Data\\AccountList.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * cuenta j = (cuenta) listCuentas.cab;
         * do {
         * System.out.println(j.nodeToJson());
         * j = (cuenta) j.next;
         * } while (j != (cuenta) listCuentas.cab);
         */

        launch();
    }

    @SuppressWarnings("exports")
    public static Stage getStage() {
        return stage;
    }
}
