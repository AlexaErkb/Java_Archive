package com.example.logindisplay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * Основная функция, отвечает за запуск программы
 * Наследует Application
 * @author Еркебаева Александра и Шадынина Анастасия
 *
 */

public class Main extends Application {
    private static Stage stg;

    /**
     * запуск экрана, устанавливает начальный fxml файл для отображения
     * @param stage получение экрана
     * @throws IOException если на входе/выходе произошло исключение
     */
    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        Parent root = FXMLLoader.load(getClass().getResource("auto-login.fxml"));
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(AutoLogin.class.getResource("Button.css").toExternalForm());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * меняет fxml файл для отображения
     * @param fxml получение название fxml файла для изменение экрана
     * @throws IOException если на входе/выходе произошло исключение
     */
    public void changeStage(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    /**
     * запуск программы
     * @param args стандартный параметр
     */
    public static void main(String[] args){launch(args);}
}
