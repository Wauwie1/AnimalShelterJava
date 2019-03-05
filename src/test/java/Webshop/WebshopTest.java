package Webshop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.Animal.Dog;
import sample.Animal.Gender;
import sample.Webshop.Product;
import sample.Webshop.Webshop;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WebshopTest {

    Webshop webshop;
    Dog dog;
    @BeforeEach
    void setUp() {
        webshop = new Webshop();
        dog = new Dog("Rex", Gender.Male, new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());
    }

    @AfterEach
    void tearDown() {
        webshop = null;
    }

    @Test
    void testAddProduct() {
        assertEquals(0, webshop.getSellables().size());
        webshop.addProduct("Dierenvoer", 9.99);
        assertEquals(1, webshop.getSellables().size());
        assertEquals("Dierenvoer", webshop.getSellables().get(0).getName());
        assertEquals(9.99, webshop.getSellables().get(0).getPrice());
    }

    @Test
    void testAddAnimal(){
        assertEquals(0, webshop.getSellables().size());
        webshop.addAnimal(dog);
        assertEquals(1, webshop.getSellables().size());
        assertEquals("Rex", webshop.getSellables().get(0).getName());
    }

    @Test
    void testAddAnimal2(){
        assertEquals(0, webshop.getSellables().size());
        webshop.addAnimal(new Dog(null, null, null));
        assertEquals(1, webshop.getSellables().size());
        assertEquals(null, webshop.getSellables().get(0).getName());
    }

    @Test
    void testNotifyObservers() {
        Dog dog2 = new Dog("Regina", Gender.Female, new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());
        webshop.addAnimal(dog);
        webshop.addAnimal(dog2);
        assertEquals(500.0, webshop.getSellables().get(0).getPrice());
    }

    @Test
    void testAddObserver() {
        assertEquals(0, webshop.getAnimalObservers().size());
        webshop.addObserver(dog);
        assertEquals(1, webshop.getAnimalObservers().size());
        assertEquals("Rex", webshop.getAnimalObservers().get(0).getName());
    }

    @Test
    void testSellProduct() {
        assertEquals(0, webshop.getSellables().size());
        Product product = new Product("Dierenvoer", 5);
        webshop.addProduct(product);
        assertEquals(1, webshop.getSellables().size());
        webshop.sellProduct(product);
        assertEquals(0, webshop.getSellables().size());
    }
}