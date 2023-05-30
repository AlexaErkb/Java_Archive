package package1;

public class Candy {
    private String manufacturer;
    private int barcode;
    public Candy(String manufacturer, int barcode) {
        this.manufacturer = manufacturer;
        this.barcode = barcode;
    }
    public void eat() {
        System.out.println(toString() + "candy");
    }
    @Override
    public String toString() {
        return "I am eating ";
    }
}
