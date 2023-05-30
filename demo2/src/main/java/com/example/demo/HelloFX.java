/*package com.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.text.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class HelloFX extends Application {
    @Override
    public void start(Stage stage) {
        // линия
        Line obj1 = new Line(20, 20, 100, 20);
        // круг
        Circle obj2 = new Circle(40, 60, 20);
        // прямоугольник
        Rectangle obj3 = new Rectangle(20, 100, 100, 40);
        // многоугольник
        double points[] = {40, 160, 70, 160, 90, 180, 70, 200, 40, 200, 20, 180};
        Polygon obj4 = new Polygon(points);
        // дуга
        Arc obj5 = new Arc(60, 250, 40, 30, 0, 180);
        // звезда
        Path path = new Path();
        MoveTo moveTo = new MoveTo(20, 300);
        LineTo line1 = new LineTo(80, 300);
        LineTo line2 = new LineTo(20,330);
        LineTo line3 = new LineTo(50,270);
        LineTo line4 = new LineTo(80, 330);
        LineTo line5 = new LineTo(20, 300);
        path.getElements().add(moveTo);
        path.getElements().addAll(line1, line2, line3, line4, line5);
        // Два пересекающихся закрашенных цветных круга.
        // Отобразите результат применения операций пересечения, объединения и разности.
        // Пересечение
        Circle circle1 = new Circle(50, 380, 30);
        circle1.setFill(Color.RED);
        Circle circle2 = new Circle(100, 380, 30);
        circle2.setFill(Color.RED);
        Shape intersect = Shape.intersect(circle1, circle2);
        intersect.setFill(Color.DARKRED);
        Group circles = new Group(circle1, circle2, intersect);
        // объединение
        Circle circle3 = new Circle(50, 460, 30);
        circle3.setFill(Color.RED);
        Circle circle4 = new Circle(100, 460, 30);
        circle4.setFill(Color.RED);
        Shape union = Shape.union(circle3, circle4);
        union.setFill(Color.DARKRED);
        Group circles2 = new Group(circle3, circle4, union);
        // разность
        Circle circle5 = new Circle(50, 540, 30);
        circle5.setFill(Color.RED);
        Circle circle6 = new Circle(100, 540, 30);
        circle6.setFill(Color.RED);
        Shape sub = Shape.subtract(circle5, circle6);
        sub.setFill(Color.DARKRED);
        Group circles3 = new Group(circle5, circle6, sub);
        // Ваше имя как текстовый элемент. Измените шрифт, цвет и другие элементы стиля.
        Text t = new Text(20, 590, "Саша");
        t.setFont(Font.font ("Verdana", FontWeight.BOLD,20));
        t.setFill(Color.DEEPSKYBLUE);
        t.setWrappingWidth(200);
        Text t1 = new Text(20, 630, "Настя");
        t1.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 40));
        t1.setFill(Color.HOTPINK);
        // Загрузите изображение с диска вашего компьютера с помощью классов
        // Image и ImageView и примените к нему эффект свечения.
        Image image = null;
        try {
            image = new Image(new FileInputStream("cat.jpg"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ImageView imageView = new ImageView(image);
        imageView.setX(200);
        imageView.setY(20);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setEffect(new Glow(0.8));
        Group group = new Group(obj1, obj2, obj3, obj4, obj5, path, circles, circles2, circles3, t, t1, imageView);
        Scene scene = new Scene(group, 640, 650);
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }

    //void main(String[] args) {
    //    launch();
    //}
}
*/