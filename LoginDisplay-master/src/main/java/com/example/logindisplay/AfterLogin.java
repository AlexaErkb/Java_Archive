package com.example.logindisplay;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * Класс отвечает за обработку событий кнопки, которая отображается на экране после перехода с начального экрана
 */
public class AfterLogin {
    @FXML
    private Button button2;

    /**
     * Вовзращение на предыдщий экран
     * @param event событие кнопки
     * @throws IOException если на входе/выходе произошло исключение
     */
    public void logoutUser(ActionEvent event) throws IOException {
        Main page = new Main();
        page.changeStage("auto-login.fxml");

    }
}
