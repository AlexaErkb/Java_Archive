package org.example;

import java.util.ArrayList;

public class Main {
    public static <T extends ClassA> void MyGenericMethod(T obj) {
        System.out.println(obj.getClass().toString());
    }
    public static void main(String[] args) {
        MyGenericClass<ClassA> genericClass = new MyGenericClass<>(new ClassA());
        genericClass.getObj().methodA();
        MyGenericMethod(new ClassA());
        ArrayList<ClassA> arraylist = new ArrayList<>();
        arraylist.add(new ClassA());
        arraylist.add(new ClassB());
        arraylist.add(new ClassC());
        arraylist.add(new ClassD());

        ArrayList<? extends ClassB> list1 = new ArrayList<>();
        ArrayList<ClassC> arrayList2 = new ArrayList<>();
        arraylist.add(new ClassC());
        arraylist.add(new ClassD());
        ArrayList <? super ClassD> list2 = new ArrayList<>();
        
    }
}
