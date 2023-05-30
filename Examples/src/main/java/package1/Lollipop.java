package package1;

public class Lollipop extends Candy{
    public Lollipop(String manufacturer, int barcode) {
        super(manufacturer, barcode);
    }
    public void eat() {
        System.out.println(toString() + "lollipop");
    }
}
