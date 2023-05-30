package package1;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.breed();
        Crocodile croco = new Crocodile();
        croco.walk();
        System.out.println(Animal.counter);
        Animal animal1 = new Dog();
        Animal animal2 = new Crocodile();
        ArrayList<Animal> arraylist = new ArrayList<Animal>();
        arraylist.add(animal1);
        arraylist.add(animal2);
        for (Animal animal:arraylist) {
            animal.breed();
            animal.eat();
        }
    }
}
