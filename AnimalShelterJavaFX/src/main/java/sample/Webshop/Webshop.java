package sample.Webshop;



import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import sample.Animal.Animal;
import sample.Animal.Dog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Webshop {

    private List<Sellable> sellableList = new ArrayList<Sellable>();;
    private ObservableList<Sellable> sellables;

    public ObservableList<Sellable> getSellables() {
        return sellables;
    }

    public Webshop() {
    sellables =  FXCollections.observableList(sellableList);
        sellables.addListener((ListChangeListener) change -> System.out.println("Detected a change!"));
    }

    public void addProduct(String name, double price) {
        SellableFactory sellableFactory = new SellableFactory();
        Sellable product = sellableFactory.MakeSellable("Product", name, price);
        sellables.add(product);
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

    public void addAnimal(Animal animal){

    }

    public void sellProduct(Sellable sellable) {
        sellables.remove(sellable);
    }
}
