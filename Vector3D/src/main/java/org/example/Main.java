package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите данные для первого вектора");
        String x = in.next();
        String[] strArr = x.split(",");
        ArrayList<String> v = new ArrayList<>(Arrays.asList(strArr));
        Vector3d vector1 = new Vector3d(Double.parseDouble(v.get(0)), Double.parseDouble(v.get(1)), Double.parseDouble(v.get(2)));
        System.out.println("Введите данные для второго вектора");
        x = in.next();
        String[] strArr2 = x.split(",");
        ArrayList<String> v2 = new ArrayList<>(Arrays.asList(strArr2));
        Vector3d vector2 = new Vector3d(Double.parseDouble(v2.get(0)), Double.parseDouble(v2.get(1)), Double.parseDouble(v2.get(2)));
        System.out.println();
        System.out.println("Скалярное произведение: " + vector1.scalar(vector2));
        System.out.println("Векторное произведение: " + vector1.vector_add(vector2));
        System.out.println("Сумма векторов: " + vector1.add(vector2));
        System.out.println("Разность векторов: " + vector1.sub(vector2));
        System.out.println("Модуль вектора 1: " + vector1.module());
        System.out.println("Модуль вектора 2: " + vector2.module());
        System.out.println("Угол между векторами: " + vector1.angle(vector2));
    }
}