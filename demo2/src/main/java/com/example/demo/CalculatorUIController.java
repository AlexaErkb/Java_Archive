package com.example.demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CalculatorUIController implements Initializable {

    Double temp = 0.0, result = 0.0;
    boolean isOperatorPressed;
    String operatorPressed = "";
    @FXML
    TextField out;
    private Model model;

    /**
     *
     * Инизиализация вводимых данных
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        out.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> a, String old, String new_value) {
                if (!new_value.matches("\\d*([\\.]\\d*)?")) {
                    out.setText(old);
                }
            }
        });
        this.model = new Model();
    }

    /**
     *
     * Если клик произошел по кнопку цифры
     * @param event ивент - клик
     */
    @FXML
    private void numClick(ActionEvent event) {
        model.analyzeNum(event, isOperatorPressed, out);
    }

    /**
     * Если нажатие произошло по оператору + - Х /
     * @param event - клик
     */
    @FXML
    private void opClick(ActionEvent event) {
        //model.analyzeOp(event, isOperatorPressed, out, result, temp, operatorPressed);
        if(event.getSource() instanceof Button) {
            System.out.println(operatorPressed);
            Button btn = (Button)event.getSource();
            result = model.analyzeOp(event, isOperatorPressed, out, result, temp, operatorPressed);
            if (btn.getText().equals("=")) {
                out.setText(String.valueOf(result));
                operatorPressed = "";
            } else {
                out.setText("");
                operatorPressed = btn.getText().trim();
            }
        }
    }

    /**
     * Если мы хотим удалить значение и клик произошел по С
     * @param event - клик
     */
    @FXML
    private void delClick(ActionEvent event) {
        if(out.getText().length() > 0) {
            out.setText(out.getText(0, out.getText().length() - 1));
        }
    }
}