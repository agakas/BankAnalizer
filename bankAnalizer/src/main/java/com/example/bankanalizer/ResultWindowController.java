package com.example.bankanalizer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;


public class ResultWindowController {
    @FXML
    private Label reg;
    @FXML
    private Label kredit;
    @FXML
    private Label teh;
    @FXML
    private Label market;
    @FXML
    private Label staff;
    @FXML
    private Label psich;
    @FXML
    private Label ability;
    @FXML
    private Label turn;
    @FXML
    private Label finn;
    @FXML
    private Label Z25;
    @FXML
    private Label Z35;
    @FXML
    private Label Bankrupt;

    public ResultWindowController(){

    }
    public void initData(float[] result){
        for (int i = 0; i < result.length; i++){
            if (result[i] < 0){
                result[i] = 0;
            }
        }
        reg.setText(String.valueOf(result[0]));
        kredit.setText(String.valueOf(result[1]));
        teh.setText(String.valueOf(result[2]));
        market.setText(String.valueOf(result[3]));
        staff.setText(String.valueOf(result[4]));
        psich.setText(String.valueOf(result[5]));
        ability.setText(String.valueOf(result[6]));
        turn.setText(String.valueOf(result[7]));
        finn.setText(String.valueOf(result[8]));
        Z25.setText(String.valueOf(result[9]));
        Z35.setText(String.valueOf(result[10]));
        Bankrupt.setText(String.valueOf(result[11]));

        if ((int)Math.round(result[11])>=1){
            Bankrupt.setText("Большая вероятность банкротства");
            Bankrupt.setTextFill(Color.color(1,0,0));
        }else{
            Bankrupt.setText("Малая вероятность банкротства");
            Bankrupt.setTextFill(Color.color(0,1,0));
        }
    }
}
