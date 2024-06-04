module com.mycompany.tranbajofinalprogii {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.tranbajofinalprogii to javafx.fxml;
    exports com.mycompany.tranbajofinalprogii;
}
