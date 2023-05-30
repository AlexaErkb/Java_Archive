package package2;

import package1.Candy;

public class Marmalade extends Candy {
    public Marmalade(String manufacturer, int barcode) {
        super(manufacturer, barcode);
    }

    public void eat() {
        System.out.println(toString() + "marmalade");
    }
}
