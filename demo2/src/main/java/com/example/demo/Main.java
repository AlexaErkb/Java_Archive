package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Основная функция, отвечает за запуск программы
 * Наследует Application
 * @author Еркебаева Александра и Шадынина Анастасия
 */
public class Main extends Application {
    /**
     *
     * @param stage
     * @throws Exception если на выходе/выходе произошло исключение
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CalculatorUI.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toString());

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Запуск программы
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}