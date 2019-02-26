package Animal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.Animal.Dog;
import sample.Animal.Gender;
import sample.Animal.Reservor;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {

    Dog dog;
    @BeforeEach
    void setUp() {
        dog = new Dog("Rex", Gender.Male,  new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());
    }

    @AfterEach
    void tearDown() {
        dog = null;
    }
    @Test
    void testGetName() {
        String expected = "Rex";
        assertEquals(expected, dog.getName());
    }

    @Test
    void testGetGender() {
        Gender expected = Gender.Male;
        assertEquals(expected, dog.getGender());
    }

    @Test
    void testGetReservedBy() {
        Reservor reservor = new Reservor("Paul", new Date());

    }

    @Test
    void testReserve() {
        assertEquals(null, dog.getReservedBy());
        dog.reserve("Paul");
        assertEquals("Paul" , dog.getReservedBy().name);
    }

    @Test
    void testReserve2() {
        assertEquals(null, dog.getReservedBy());
        dog.reserve("Paul");
        assertEquals("Paul" , dog.getReservedBy().name);
        assertEquals(false, dog.reserve("Jan"));
    }

    @Test
    void testToString() {
        String expected = "Rex, Male, not reserved, last walk: Tue Feb 11 00:00:00 CET 2014 Price: 550.0.";

        assertEquals(expected, dog.toString());
    }
}