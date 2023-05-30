package package1;

public abstract class Reptile implements Animal{
    public void sleep() {
        System.out.println("Reptile sleep");
    }
    public void eat() {
        System.out.println("Reptile eat");
    }
    public void walk() {
        System.out.println("Reptile walk");
    }
    public void breed() {

    }
    public abstract void talk();
}
