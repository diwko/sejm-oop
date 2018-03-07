package sejm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Politician {
    private int id;
    private String firstName;
    private String lastName;
    private List<Trip> trips;
    private Map<Integer, Cost> costs;

    public Politician(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        trips = new ArrayList<>();
        costs = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public void addTrips(List<Trip> trips) {
        this.trips.addAll(trips);
    }

    public void addCost(Cost cost) {
        if (costs.containsKey(cost.getYear()))
            costs.replace(cost.getYear(), cost);
        costs.put(cost.getYear(), cost);
    }

    public void addCosts(List<Cost> costs) {
        for (Cost cost : costs)
            addCost(cost);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public double costsSum() {
        double sum = 0;
        for (Cost yearCost : costs.values())
            sum += yearCost.getSum();
        return sum;
    }

    public double costOfficeRepair() {
        double sum = 0;
        for (Cost yearCost : costs.values())
            sum += yearCost.getOfficeRepair();
        return sum;
    }

    public int numberOfTrips() {
        return trips.size();
    }

    public double maxTripCost() {
        double max = 0;
        for (Trip trip : trips)
            if (trip.getTotalCost() > max)
                max = trip.getTotalCost();
        return max;
    }

    public int daysAbroad() {
        int days = 0;
        for (Trip trip : trips)
            days += trip.getNumberOfDays();
        return days;
    }

    public boolean inCountry(String country) {
        country = country.toLowerCase();
        for (Trip trip : trips)
            if (trip.getCountry().toLowerCase().equals(country))
                return true;
        return false;
    }
}