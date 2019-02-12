package Animal;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class ReservorTest {

    Reservor reservor;
    @Test
    void testConstructor() {
        reservor = new Reservor("Jantje", new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());

        assertEquals("Jantje", reservor.name);
        assertEquals(new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime(), reservor.ReservedAt);
    }
}