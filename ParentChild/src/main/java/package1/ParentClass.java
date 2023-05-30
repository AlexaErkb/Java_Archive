package package1;

public class ParentClass {
    public ParentClass() {
        System.out.println("Parent Class");
    }
    private void private_method() {
        System.out.println("It's private");
    }
    protected void protected_method() {
        System.out.println("It's protected");
    }
    public void public_method() {
        System.out.println("It's public");
    }
    void default_method() {
        System.out.println("It's default");
    }
}
