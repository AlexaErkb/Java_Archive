package package1;

public class ChildClass1 extends ParentClass{
    public ChildClass1() {
        System.out.println("Child Class");
    }
    public void public_method() {
        super.public_method();
        System.out.println("Overwrite");
    }
}
