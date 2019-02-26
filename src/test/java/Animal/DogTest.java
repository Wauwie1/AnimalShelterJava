package Animal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.Animal.Dog;
import sample.Animal.Gender;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DogTest {

    Dog dog;
    @BeforeEach
    void setUp() {
        dog = new Dog("Rex", Gender.Male, new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());
    }

    @AfterEach
    void tearDown() {
        dog = null;
    }

    @Test
    void testNeedsWalk() {
        boolean expected = true;

        assertEquals(expected, dog.needsWalk());
    }

    @Test
    void testNeedsWalk2() {

        dog = new Dog("Rex", Gender.Male, new Date());
        boolean expected = false;


        assertEquals(expected, dog.needsWalk());
    }

    @Test
    void testToString() {
        String expected = "Rex, Male, not reserved, last walk: Tue Feb 11 00:00:00 CET 2014 Price: 550.0.";

        assertEquals(expected, dog.toString());
    }

    @Test
    void testGetLastWalk() {
        Date expected = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();

        assertEquals(expected, dog.getLastWalk());
    }

}