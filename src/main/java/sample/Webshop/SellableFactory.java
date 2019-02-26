package sample.Webshop;

public class SellableFactory {

    public Sellable MakeSellable(String sellable, String name, double price){

        if(sellable.equals("Product")){
            return new Product(name, price);
        }else {
            return null;
        }
    }
}
