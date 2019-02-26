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
        assertEquals(450.0, webshop.getSellables().get(0).getPrice());
    }
//    @Test
//    void addDog2() {
//        Dog dog = new Dog("Regina", Gender.Female, new Date());
//        Dog dog2 = new Dog("Rex", Gender.Male, new Date());
//        Dog dog3 = new Dog("Floef", Gender.Female, new Date());
//        webshop.addDog(dog);
//        webshop.addDog(dog2);
//        webshop.addDog(dog3);
//        assertEquals(3, webshop.sellables.size());
//        assertEquals(500, webshop.sellables.get(2).price);
//        assertEquals(450, webshop.sellables.get(1).price);
//        assertEquals(400, webshop.sellables.get(0).price);
//
//    }
//
//    @Test
//    void sellProduct() {
//        Product product = new Product("Artiekel", 99.99);
//        webshop.addProduct(product);
//        assertEquals(1, webshop.sellables.size());
//        webshop.sellProduct(product);
//        assertEquals(0, webshop.sellables.size());
//    }
}