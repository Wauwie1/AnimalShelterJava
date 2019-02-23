package sample.Webshop;

public abstract class Sellable {
    protected String name;
    protected double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    protected Sellable(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name + ": " + this.price;
    }

}
