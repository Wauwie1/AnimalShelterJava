package Webshop;

public class Product extends Sellable {

    public Product(String name, double price) {
        super(name);
        super.name = name;
        super.price = price;
    }
}
