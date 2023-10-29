module com.example.bankanalizer {
    requires javafx.controls;
    requires javafx.fxml;
    requires deeplearning4j.nn;
    requires deeplearning4j.modelimport;
    requires nd4j.api;

    opens com.example.bankanalizer to javafx.fxml;
    exports com.example.bankanalizer;
}