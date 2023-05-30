package package1;

import package2.ChildClass3;

public class Main {
    public static void main(String[] args) {
        ParentClass parent = new ParentClass();
        ChildClass1 child = new ChildClass1();
        ChildClass3 child3 = new ChildClass3();
        child3.protected_method();
    }
}
