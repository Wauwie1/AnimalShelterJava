package Animal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.Animal.Animal;
import sample.Animal.AnimalFactory;
import sample.Animal.Gender;

import static org.junit.jupiter.api.Assertions.*;

class AnimalFactoryTest {

    AnimalFactory factory;

    @BeforeEach
    void setUp() {
        factory = new AnimalFactory();
    }

    @Test
    void testMakeaAnimal() {
        Animal dog = factory.MakeAnimal("Dog", "Rex", Gender.Male, null);
        assertNotNull(dog);
        assertEquals("Rex", dog.getName());
        assertEquals(Gender.Male, dog.getGender());
    }

    @Test
    void testMakeaAnimal2() {
        Animal cat = factory.MakeAnimal("Cat", "Luna", Gender.Female, "Dom");
        assertNotNull(cat);
        assertEquals("Luna", cat.getName());
        assertEquals(Gender.Female, cat.getGender());
        assertEquals(290, cat.getPrice());
    }

    @Test
    void testMakeaAnimal3() {
        Animal nonExistent = factory.MakeAnimal("Null", "Luna", Gender.Female, "Dom");
        assertNull(nonExistent);

    }

    @Test
    void testMakeAnimal4() {
        Animal dog = factory.MakeAnimal("Dog", null, null, null);
        assertNotNull(dog);
    }
}
