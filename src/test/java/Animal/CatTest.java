package Animal;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    Cat cat;
    @BeforeEach
    void setUp() {
        cat = new Cat("Mies", Gender.Female, "Krast");
    }

    @AfterEach
    void tearDown() {
        cat = null;
    }

    @Test
    void testCalculatePrice(){
        double expected = 250;

        assertEquals(expected, cat.getPrice());
    }

    @Test
    void testCalculatePrice2(){
        cat = new Cat("Mies", Gender.Female, "This cat has a  lot of bad habits.");
        assertEquals(35, cat.getPrice());
    }

    @Test
    void testToString(){
        String expected = "Mies, Female, not reserved, bad habits: krast";
        assertEquals(expected, cat.toString());
    }
}