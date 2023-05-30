package com.example.logindisplay;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

/**
 * Класс отвечает за обработку событий на начальном экране
 */
public class AutoLogin {

    public AutoLogin() {

    }

    @FXML
    private Button button;
    @FXML
    private Label empLabel;
    @FXML TextField username;
    @FXML PasswordField password;

    /**
     * обработчик кнопки
     * @param event событие кнопки
     * @throws IOException если на входе/выходе произошло исключение
     */
    public void loginUser(ActionEvent event) throws IOException {
        checkData();
    }

    /**
     *
     * проверка корректности данных, вводимые пользоватлем
     * @throws IOException если на входе/выходе произошло исключение
     */
    private void checkData() throws IOException {
        Main page = new Main();
        if (username.getText().toString().equals("qwerty") && password.getText().toString().equals("1234")) {
            page.changeStage("after-login.fxml");
        }
        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            empLabel.setText("Вы не ввели данные");
        }
        else {
            empLabel.setText("Неправильный логин или пароль");
        }
    }


}
