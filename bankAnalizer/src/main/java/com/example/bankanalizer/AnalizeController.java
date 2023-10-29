package com.example.bankanalizer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AnalizeController {
    //Входные параметры
    @FXML
    private TextField x1;
    @FXML
    private TextField x2;
    @FXML
    private TextField x3;
    @FXML
    private TextField x4;
    @FXML
    private TextField x5;
    @FXML
    private TextField x6;
    @FXML
    private TextField x7;
    @FXML
    private TextField x8;
    @FXML
    private TextField x9;
    @FXML
    private TextField x10;
    @FXML
    private TextField x11;
    @FXML
    private TextField x12;
    @FXML
    private TextField x13;
    @FXML
    private TextField x14;
    @FXML
    private TextField x15;
    @FXML
    private TextField x16;
    @FXML
    private TextField x17;
    @FXML
    private TextField x18;
    @FXML
    private TextField x19;
    @FXML
    private TextField x20;
    @FXML
    private TextField x21;
    @FXML
    private TextField x22;
    @FXML
    private TextField x23;
    @FXML
    private TextField x24;
    @FXML
    private TextField x25;
    @FXML
    private TextField x26;
    @FXML
    private TextField x27;
    @FXML
    private TextField x28;
    @FXML
    private TextField x29;
    @FXML
    private TextField x30;
    @FXML
    private TextField x31;
    @FXML
    private TextField x32;
    @FXML
    private TextField x33;
    @FXML
    private TextField x34;
    @FXML
    private TextField x35;

    public AnalizeController() {
    }

    @FXML
    protected void onAnalizeButtonClick() throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException {
        ArrayList<String> inputArr = new ArrayList<>();

        inputArr.add(x1.getText());
        inputArr.add(x2.getText());
        inputArr.add(x3.getText());
        inputArr.add(x4.getText());
        inputArr.add(x5.getText());
        inputArr.add(x6.getText());
        inputArr.add(x7.getText());
        inputArr.add(x8.getText());
        inputArr.add(x9.getText());
        inputArr.add(x10.getText());
        inputArr.add(x11.getText());
        inputArr.add(x12.getText());
        inputArr.add(x13.getText());
        inputArr.add(x14.getText());
        inputArr.add(x15.getText());
        inputArr.add(x16.getText());
        inputArr.add(x17.getText());
        inputArr.add(x18.getText());
        inputArr.add(x19.getText());
        inputArr.add(x20.getText());
        inputArr.add(x21.getText());
        inputArr.add(x22.getText());
        inputArr.add(x23.getText());
        inputArr.add(x24.getText());
        inputArr.add(x25.getText());
        inputArr.add(x26.getText());
        inputArr.add(x27.getText());
        inputArr.add(x28.getText());
        inputArr.add(x29.getText());
        inputArr.add(x30.getText());
        inputArr.add(x31.getText());
        inputArr.add(x32.getText());
        inputArr.add(x33.getText());
        inputArr.add(x34.getText());
        inputArr.add(x35.getText());

        int length = inputArr.size();
        boolean flag = true;

        float[] arr = new float[length];

        for (int i = 0; i < length; i++){
            if(!isNumeric(inputArr.get(i))){
                flag = false;
                break;
            }
            else{
                arr[i] = Float.parseFloat(inputArr.get(i));
            }
        }
        //Если всё числа, то результат. Иначе сообщение об ошибке
        if (flag) {
            NeuralNet myPredict = new NeuralNet(arr);
            float[] result = myPredict.predict();
            System.out.println(Arrays.toString(result));

            Stage stage1 = new Stage();
            FXMLLoader fxmlLoader1 = new FXMLLoader(BankAnalizerApplication.class.getResource("result-view.fxml"));
            Scene scene1 = new Scene(fxmlLoader1.load(), 700, 500);

            ResultWindowController result_controller = fxmlLoader1.getController();
            result_controller.initData(result);


            stage1.setTitle("Bank Analizer");
            stage1.setScene(scene1);
            stage1.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Заполните все поля числовыми данными", ButtonType.OK);
            alert.showAndWait();
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}