package Webshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;
    @Test
    void testConstructor() {
        product = new Product("Dierenvoer", 12.50);

        assertEquals("Dierenvoer", product.name);
        assertEquals(12.50, product.price);
    }

}