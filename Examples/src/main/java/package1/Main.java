package package1;

import package2.Marmalade;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Candy candy = new Candy("A", 13455);
        Lollipop lollipop = new Lollipop("B", 12467);
        Marmalade marmalade = new Marmalade("C", 12468);
        List<Candy> candies = Arrays.asList(candy, lollipop, marmalade);
        for (Candy c :candies) {
            c.eat();// полиморфный вызов метода
        }
    }
}
