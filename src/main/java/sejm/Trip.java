package sejm;

public class Trip {
    private int year;
    private String country;
    private int numberOfDays;
    private double totalCost;

    public Trip(int year, String country, int numberOfDays, double totalCost) {
        this.year = year;
        this.country = country;
        this.numberOfDays = numberOfDays;
        this.totalCost = totalCost;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
