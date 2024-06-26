module com.mycompany.tranbajofinalprogii {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires org.json;
    requires java.desktop;

    opens com.mycompany.tranbajofinalprogii to javafx.fxml;

    exports com.mycompany.tranbajofinalprogii;
}
