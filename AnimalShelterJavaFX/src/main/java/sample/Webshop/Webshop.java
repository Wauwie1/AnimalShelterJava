package sample.Webshop;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import sample.Animal.Animal;
import java.util.ArrayList;
import java.util.List;

public class Webshop {

    private List<Sellable> sellableList = new ArrayList<Sellable>();;
    private ObservableList<Sellable> sellables;
    private List<Animal> animalObservers = new ArrayList<Animal>();

    public ObservableList<Sellable> getSellables() {
        return sellables;
    }

    public Webshop() {
    sellables =  FXCollections.observableList(sellableList);
        sellables.addListener((ListChangeListener) change -> System.out.println("Detected a change!"));
    }

    public void addObserver(Animal animal){
        animalObservers.add(animal);
    }

    public void addProduct(String name, double price) {
        SellableFactory sellableFactory = new SellableFactory();
        Sellable product = sellableFactory.MakeSellable("Product", name, price);
        sellables.add(product);
        notifyObservers();
    }


    public void notifyObservers() {
        for (Animal animal : this.animalObservers) {
            animal.update();
        }
    }

    public void addAnimal(Animal animal){
        sellables.add(animal);
        notifyObservers();
    }

    public void sellProduct(Sellable sellable) {
        sellables.remove(sellable);
    }
}
