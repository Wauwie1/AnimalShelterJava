package Webshop;

import org.junit.jupiter.api.Test;
import sample.Webshop.Product;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    Product product;
    @Test
    void testConstructor() {
        product = new Product("Dierenvoer", 12.50);

        assertEquals("Dierenvoer", product.getName());
        assertEquals(12.50, product.getPrice());
    }

}