package sample.Webshop;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import sample.Animal.Animal;
import sample.Database.DatabaseController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Webshop implements Serializable {

    private List<Sellable> sellableList = new ArrayList<Sellable>();
    private ObservableList<Sellable> sellables;
    private List<Animal> animalObservers = new ArrayList<Animal>();
    private DatabaseController databaseController = new DatabaseController();
    private boolean isFirstLoad = true;

    public List<Animal> getAnimalObservers() {
        return animalObservers;
    }

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
        saveToDatabase();
    }

    public void addProduct(Product product) {
        sellables.add(product);
        if(!isFirstLoad) {
            saveToDatabase();
        }
    }


    public void notifyObservers() {
        for (Animal animal : this.animalObservers) {
            animal.update();
        }
    }

    public void addAnimal(Animal animal){
        sellables.add(animal);
    }

    public void sellProduct(Sellable sellable) {
        sellables.remove(sellable);
        saveToDatabase();
    }

    public void loadProductsDatabase(){

        List<Product> databaseProducts = databaseController.loadProductsFromDatabase();
        for (Product product: databaseProducts){
            addProduct(product);
        }
        isFirstLoad = false;
    }

    private void saveToDatabase() {
        databaseController.saveToDatabase(sellableList);
    }
}
