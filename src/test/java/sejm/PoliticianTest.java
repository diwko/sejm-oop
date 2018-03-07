package sejm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class PoliticianTest {
    private Politician politician;

    @Before
    public void preparePolitician() {
        politician = new Politician(10, "Anon", "Anonymous");
    }

    @Test
    public void toStringTest() {
        assertEquals("Anon Anonymous", politician.toString());
    }

    @Test
    public void costsSum() {
        Cost cost1 = Mockito.mock(Cost.class);
        Mockito.when(cost1.getSum()).thenReturn(233009.22);
        Mockito.when(cost1.getYear()).thenReturn(2000);
        politician.addCost(cost1);

        assertEquals(233009.22, politician.costsSum(), 0.001);

        Cost cost2 = Mockito.mock(Cost.class);
        Mockito.when(cost2.getSum()).thenReturn(43201.18);
        Mockito.when(cost1.getYear()).thenReturn(2009);
        politician.addCost(cost2);

        assertEquals(276210.40, politician.costsSum(), 0.001);
    }

    @Test
    public void costOfficeRepair() {
        Cost cost1 = Mockito.mock(Cost.class);
        Mockito.when(cost1.getOfficeRepair()).thenReturn(14537.22);
        Mockito.when(cost1.getYear()).thenReturn(2004);
        politician.addCost(cost1);

        assertEquals(14537.22, politician.costOfficeRepair(), 0.001);

        Cost cost2 = Mockito.mock(Cost.class);
        Mockito.when(cost2.getOfficeRepair()).thenReturn(5178.28);
        Mockito.when(cost1.getYear()).thenReturn(2005);
        politician.addCost(cost2);

        assertEquals(19715.50, politician.costOfficeRepair(), 0.001);
    }

    @Test
    public void numberOfTrips() {
        assertEquals(0, politician.numberOfTrips());

        Trip trip1 = Mockito.mock(Trip.class);
        politician.addTrip(trip1);

        assertEquals(1, politician.numberOfTrips());

        Trip trip2 = Mockito.mock(Trip.class);
        politician.addTrip(trip2);

        assertEquals(2, politician.numberOfTrips());

        List<Trip> trips = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            trips.add(Mockito.mock(Trip.class));
        politician.addTrips(trips);

        assertEquals(12, politician.numberOfTrips());
    }

    @Test
    public void maxTripCost() {
        assertEquals(0.0, politician.maxTripCost(), 0.001);

        Trip trip1 = Mockito.mock(Trip.class);
        Mockito.when(trip1.getTotalCost()).thenReturn(1230.21);
        politician.addTrip(trip1);

        assertEquals(1230.21, politician.maxTripCost(), 0.001);

        List<Trip> trips = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Trip trip = Mockito.mock(Trip.class);
            Mockito.when(trip.getTotalCost()).thenReturn(1000.0 * i);

            trips.add(trip);
        }
        politician.addTrips(trips);

        assertEquals(9000.0, politician.maxTripCost(), 0.001);

        Trip trip2 = Mockito.mock(Trip.class);
        Mockito.when(trip2.getTotalCost()).thenReturn(1231.21);
        politician.addTrip(trip2);

        assertEquals(9000.0, politician.maxTripCost(), 0.001);
    }

    @Test
    public void daysAbroad() {
        assertEquals(0, politician.daysAbroad());

        Trip trip1 = Mockito.mock(Trip.class);
        Mockito.when(trip1.getNumberOfDays()).thenReturn(5);
        politician.addTrip(trip1);

        assertEquals(5, politician.daysAbroad());

        List<Trip> trips = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            Trip trip = Mockito.mock(Trip.class);
            Mockito.when(trip.getNumberOfDays()).thenReturn(i);

            trips.add(trip);
        }
        politician.addTrips(trips);

        assertEquals(60, politician.daysAbroad());

        Trip trip2 = Mockito.mock(Trip.class);
        Mockito.when(trip2.getNumberOfDays()).thenReturn(8);
        politician.addTrip(trip2);

        assertEquals(68, politician.daysAbroad());
    }

    @Test
    public void inCountry() {
        assertFalse(politician.inCountry("Polska"));

        Trip trip1 = Mockito.mock(Trip.class);
        Mockito.when(trip1.getCountry()).thenReturn("Włochy");
        politician.addTrip(trip1);

        assertFalse(politician.inCountry("Polska"));
        assertTrue(politician.inCountry("Włochy"));

        Trip trip2 = Mockito.mock(Trip.class);
        Mockito.when(trip2.getCountry()).thenReturn("Polska");
        politician.addTrip(trip2);

        assertTrue(politician.inCountry("Włochy"));
        assertTrue(politician.inCountry("Polska"));
    }

}