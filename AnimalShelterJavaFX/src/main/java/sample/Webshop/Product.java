package sample.Webshop;

public class Product extends Sellable {

    public Product(String name, double price) {
        super(name);
        super.price = price;
    }

    public String toString(){
        return this.name + ": " + this.price;
    }
}
