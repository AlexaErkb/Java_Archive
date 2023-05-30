package package1;

public class Dog extends Mammal{
    @Override
    public void walk() {
        System.out.println("Dog is walking");
    }
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }
    @Override
    public void breed() {
        System.out.println("Dog is breeding");
    }
    @Override
    public void sleep() {
        System.out.println("Dog is sleeping");
    }
    @Override
    public void talk() {
        System.out.println("Dog is talking");
    }
}
