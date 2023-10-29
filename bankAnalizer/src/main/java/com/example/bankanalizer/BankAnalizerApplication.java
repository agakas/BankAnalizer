package com.example.bankanalizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BankAnalizerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BankAnalizerApplication.class.getResource("start-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load());
        stage.setTitle("Bank Analizer");
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}