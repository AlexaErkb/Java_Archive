package com.example.withhtml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX WebView Example");
            /*
        WebView webView = new WebView();

        webView.getEngine().load("http://google.com");


        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.load(this.getClass().getResource("1.html").toExternalForm());

        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

             */
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        File file = new File("1.html");
        URL url= null;
        try {
            url = file.toURI().toURL();
        } catch (MalformedURLException e) {
            System.out.println("Ошибка");
            throw new RuntimeException(e);
        }
        engine.load(url.toString());
        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}