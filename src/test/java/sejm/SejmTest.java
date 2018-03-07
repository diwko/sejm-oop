package sejm;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SejmTest {
    private Sejm sejm;
    private List<Politician> politicians;

    @Before
    public void setSejm(){
        Politician p1 = Mockito.mock(Politician.class);
        Politician p2 = Mockito.mock(Politician.class);
        Politician p3 = Mockito.mock(Politician.class);
        Politician p4 = Mockito.mock(Politician.class);
        Politician p5 = Mockito.mock(Politician.class);

        Mockito.when(p1.getLastName()).thenReturn("a");
        Mockito.when(p2.getLastName()).thenReturn("b");
        Mockito.when(p3.getLastName()).thenReturn("c");
        Mockito.when(p4.getLastName()).thenReturn("d");
        Mockito.when(p5.getLastName()).thenReturn("f");

        Mockito.when(p1.getFirstName()).thenReturn("f");
        Mockito.when(p2.getFirstName()).thenReturn("f");
        Mockito.when(p3.getFirstName()).thenReturn("f");
        Mockito.when(p4.getFirstName()).thenReturn("f");
        Mockito.when(p5.getFirstName()).thenReturn("f");

        politicians = Arrays.asList(p1,p2,p3,p4,p5);

        sejm = new Sejm(7, politicians);
    }

    @Test
    public void averageCosts() throws Exception {
        Mockito.when(politicians.get(0).costsSum()).thenReturn(10000.0);
        Mockito.when(politicians.get(1).costsSum()).thenReturn(90000.0);
        Mockito.when(politicians.get(2).costsSum()).thenReturn(20000.0);
        Mockito.when(politicians.get(3).costsSum()).thenReturn(15000.0);
        Mockito.when(politicians.get(4).costsSum()).thenReturn(1000.0);

        assertEquals(27200.0, sejm.averageCosts(), 0.001);
    }

    @Test
    public void maxTimesAbroad() throws Exception {
        Mockito.when(politicians.get(0).numberOfTrips()).thenReturn(1);
        Mockito.when(politicians.get(1).numberOfTrips()).thenReturn(4);
        Mockito.when(politicians.get(2).numberOfTrips()).thenReturn(9);
        Mockito.when(politicians.get(3).numberOfTrips()).thenReturn(0);
        Mockito.when(politicians.get(4).numberOfTrips()).thenReturn(2);

        assertEquals(politicians.get(2), sejm.maxTimesAbroad());
    }

    @Test
    public void maxDaysAbroad() throws Exception {
        Mockito.when(politicians.get(0).daysAbroad()).thenReturn(10);
        Mockito.when(politicians.get(1).daysAbroad()).thenReturn(9);
        Mockito.when(politicians.get(2).daysAbroad()).thenReturn(20);
        Mockito.when(politicians.get(3).daysAbroad()).thenReturn(21);
        Mockito.when(politicians.get(4).daysAbroad()).thenReturn(15);

        assertArrayEquals(new Politician[]{politicians.get(3)}, sejm.maxDaysAbroad().toArray());
    }

    @Test
    public void maxTripCosts() throws Exception {
        Mockito.when(politicians.get(0).maxTripCost()).thenReturn(1000.99);
        Mockito.when(politicians.get(1).maxTripCost()).thenReturn(2500.00);
        Mockito.when(politicians.get(2).maxTripCost()).thenReturn(1250.02);
        Mockito.when(politicians.get(3).maxTripCost()).thenReturn(7255.44);
        Mockito.when(politicians.get(4).maxTripCost()).thenReturn(1477.00);

        assertSame(politicians.get(3), sejm.maxTripCosts());
    }

    @Test
    public void politiciansAbroad() throws Exception {
        Mockito.when(politicians.get(0).inCountry("Włochy")).thenReturn(true);
        Mockito.when(politicians.get(1).inCountry("Polska")).thenReturn(true);
        Mockito.when(politicians.get(2).inCountry("Niemcy")).thenReturn(true);
        Mockito.when(politicians.get(3).inCountry("Włochy")).thenReturn(true);
        Mockito.when(politicians.get(4).inCountry("Rosja")).thenReturn(true);

        assertArrayEquals(new Politician[]{politicians.get(0), politicians.get(3)}, sejm.politiciansAbroad("Włochy").toArray());
        assertArrayEquals(new Politician[]{politicians.get(1)}, sejm.politiciansAbroad("Polska").toArray());
        assertArrayEquals(new Politician[]{}, sejm.politiciansAbroad("Ukraina").toArray());
    }

}