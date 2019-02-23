package sample.Webshop;

public abstract class Sellable {
    protected String name;
    protected double price;

    protected Sellable(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name + ": " + this.price;
    }

}
