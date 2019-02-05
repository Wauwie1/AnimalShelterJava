package Webshop;

import Animal.Dog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Webshop {

    private List<Sellable> sellables = new ArrayList<Sellable>();

    public void addProduct(String name, double price) {
        sellables.add(new Product(name, price));
    }

    public void addDog(Dog dog) {
        sellables.add(dog);

        Collections.reverse(sellables);
        int counter = 500;
        for(Sellable sellable : sellables){
            if(sellable instanceof Dog){
                sellable.price = counter;
                if(sellable.price != 50){
                    counter -= 50;
                }
            }
        }
        Collections.reverse(sellables);
    }

    public void sellProduct(Sellable product) {
        sellables.remove(product);
    }
}
