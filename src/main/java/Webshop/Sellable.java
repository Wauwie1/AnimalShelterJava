package Webshop;

public abstract class Sellable {
    protected String name;
    protected double price;

    protected Sellable(String name) {
        this.name = name;
    }
}
