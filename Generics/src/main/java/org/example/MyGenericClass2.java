package org.example;

public class MyGenericClass2 <T extends ClassD> {
    private T obj;
    MyGenericClass2(T obj) {
        this.obj = obj;
        obj.methodA();
        obj.methodB();
        obj.methodC();
        obj.methodD();
    }
    public T getObj() { return obj; }
}
