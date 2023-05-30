package com.example.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Model {

    public void analyzeNum(ActionEvent event, boolean isOperatorPressed, TextField out) {
        if (event.getSource() instanceof Button) {
            Button btn = (Button) event.getSource();
            if (isOperatorPressed) {
                out.setText(btn.getText().trim());
            } else {
                out.setText(out.getText().trim() + btn.getText().trim());
            }
            isOperatorPressed = false;
        }
    }

    public Double analyzeOp(ActionEvent event, boolean isOperatorPressed, TextField out, Double result, Double temp, String operatorPressed) {
            if (!out.getText().isEmpty()) {
                temp = Double.valueOf(out.getText());
                switch (operatorPressed) {
                    case "+":
                        result += temp;
                        break;
                    case "-":
                        result -= temp;
                        break;
                    case "X":
                        result *= temp;
                        break;
                    case "/":
                        result /= temp;
                        break;
                    default:
                        result = temp;
                }
            }
            isOperatorPressed = true;
        return result;
    }
}
