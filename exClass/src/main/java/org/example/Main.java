package org.example;

//import Task;


import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Class<? extends ExampleClass> expClass = new ExampleClass().getClass();
        System.out.println("-------------");
        System.out.println("! все переменные класса вместе с типом и модификатором доступа");
        Field[] fields = expClass.getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field.getName()+" " +field);
        }
        System.out.println("-------------");
        System.out.println("!Вывести все методы класса");
        Method[] methods = expClass.getMethods();
        for (Method method: methods) {
            System.out.println(method);
        }
        System.out.println("-------------");
        Method[] methods1 = expClass.getDeclaredMethods();
        for (Method method: methods1) {
            System.out.println(method.getName());
        }
        System.out.println("-------------");
        System.out.println("!Вывести все конструкторы класса");

        Constructor[] constructors = expClass.getConstructors();
        for (Constructor constructor: constructors) {
            System.out.println(constructor);
        }
        System.out.println("-------------");
        System.out.println("!Вывести всех значений переменных класса");
        ExampleClass myClass = new ExampleClass();
        Field[] fields2 = myClass.getClass().getDeclaredFields();
        for (Field field: fields2) {
            field.setAccessible(true);
            System.out.println(field.get(myClass));
        }
        System.out.println("-------------");
        System.out.println("!Вывести всех аннотацией в классе");

        for (Method method: methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation: annotations) {
                System.out.println(annotation.annotationType().getName());
            }
        }
        System.out.println("-------------");
        System.out.println("!Создать объект типа ExampleClass");
        ExampleClass newClass = ExampleClass.class.getConstructor().newInstance();
        System.out.println(newClass.getClass().getName());

    }

}
