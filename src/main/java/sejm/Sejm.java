package sejm;

import java.util.*;

public class Sejm {
    private int cadency;
    private HashMap<String, Politician> politicians = new HashMap<>();

    public Sejm(int cadency, List<Politician> politicians) {
        this.cadency = cadency;
        for(Politician politician : politicians){
            String key = (politician.getFirstName() + politician.getLastName()).toLowerCase();
            this.politicians.put(key, politician);
        }
    }

    public int getCadency(){
        return cadency;
    }

    public Politician getPolitician(String firstName, String lastName){
        String key = (firstName + lastName).toLowerCase();
        if(politicians.containsKey(key))
            return politicians.get(key);
        return null;
    }

    public double averageCosts() {
        double sum = 0;
        for (Politician politician : politicians.values()) {
            sum += politician.costsSum();
        }
        return sum / politicians.size();
    }

    public Politician maxTimesAbroad() {
        Politician maxPolitician = null;
        int maxTimes = 0;
        for (Politician politician : politicians.values()) {
            if (politician.numberOfTrips() > maxTimes) {
                maxPolitician = politician;
                maxTimes = politician.numberOfTrips();
            }
        }
        return maxPolitician;
    }

    public List<Politician> maxDaysAbroad() {
        List<Politician> maxPoliticians = new LinkedList<>();
        int maxDaysAbroad = 0;

        for (Politician politician : politicians.values()) {
            int politicianDays = politician.daysAbroad();
            if (politicianDays > maxDaysAbroad) {
                maxDaysAbroad = politicianDays;
                maxPoliticians.clear();
                maxPoliticians.add(politician);
            } else if (politicianDays == maxDaysAbroad)
                maxPoliticians.add(politician);
        }
        return maxPoliticians;
    }

    public Politician maxTripCosts() {
        Politician maxPolitician = null;
        double maxCost = 0;
        for (Politician politician : politicians.values()) {
            if (politician.maxTripCost() > maxCost) {
                maxPolitician = politician;
                maxCost = politician.maxTripCost();
            }
        }
        return maxPolitician;
    }

    public List<Politician> politiciansAbroad(String country) {
        List<Politician> politiciansInCountry = new LinkedList<>();
        for (Politician politician : politicians.values()) {
            if (politician.inCountry(country))
                politiciansInCountry.add(politician);
        }
        return politiciansInCountry;
    }
}
