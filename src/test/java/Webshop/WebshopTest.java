package Webshop;

import Animal.Dog;
import Animal.Gender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class WebshopTest {

    Webshop webshop;
    @BeforeEach
    void setUp() {
        webshop = new Webshop();
    }

    @AfterEach
    void tearDown() {
        webshop = null;
    }

    @Test
    void addProduct() {
        assertEquals(0, webshop.sellables.size());
        webshop.addProduct(new Product("Dierenvoer", 9.99));
        assertEquals(1, webshop.sellables.size());
        assertEquals("Dierenvoer", webshop.sellables.get(0).name);
        assertEquals(9.99, webshop.sellables.get(0).price);
    }

    @Test
    void addDog() {
        Dog dog = new Dog("Regina", Gender.Female, new Date());
        assertEquals(0, webshop.sellables.size());
        webshop.addDog(dog);
        assertEquals(1, webshop.sellables.size());
        assertEquals("Regina", webshop.sellables.get(0).name);
        assertEquals(500, webshop.sellables.get(0).price);
    }

    @Test
    void addDog2() {
        Dog dog = new Dog("Regina", Gender.Female, new Date());
        Dog dog2 = new Dog("Rex", Gender.Male, new Date());
        Dog dog3 = new Dog("Floef", Gender.Female, new Date());
        webshop.addDog(dog);
        webshop.addDog(dog2);
        webshop.addDog(dog3);
        assertEquals(3, webshop.sellables.size());
        assertEquals(500, webshop.sellables.get(2).price);
        assertEquals(450, webshop.sellables.get(1).price);
        assertEquals(400, webshop.sellables.get(0).price);

    }

    @Test
    void sellProduct() {
        Product product = new Product("Artiekel", 99.99);
        webshop.addProduct(product);
        assertEquals(1, webshop.sellables.size());
        webshop.sellProduct(product);
        assertEquals(0, webshop.sellables.size());
    }
}