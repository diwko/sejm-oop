package sejm;

import java.util.List;

public class SejmPrinter {
    private Sejm sejm;

    public SejmPrinter(Sejm sejm){
        this.sejm = sejm;
    }

    public void print(Arguments arguments) {
        String[] name;
        Politician politician;
        List<Politician> politicians;

        switch (arguments.getAttribute()) {
            case CostsSum:
                name = arguments.getDetails().split("\\s+");
                politician = sejm.getPolitician(name[0], name[1]);
                if (politician != null)
                    System.out.println(politician + " Suma wydatków: " +
                            Math.round(politician.costsSum() * 100) / 100.0 + " zł.");
                else
                    System.out.println("Nie znaleziono posła");
                break;
            case CostsOfficeRepair:
                name = arguments.getDetails().split("\\s+");
                politician = sejm.getPolitician(name[0], name[1]);
                if (politician != null)
                    System.out.println(politician + " koszt drobnych napraw i remontów biura poselskiego: " +
                            Math.round(politician.costOfficeRepair() * 100) / 100.0 + " zł.");
                else
                    System.out.println("Nie znaleziono posła");
                break;
            case CostsAverage:
                System.out.println("Średnia wartość sumy wydatków wszystkich posłów: " +
                        Math.round(sejm.averageCosts() * 100) / 100.0 + " zł.");
                break;
            case TripsMaxTimesAbroad:
                politician = sejm.maxTimesAbroad();
                System.out.println("Najwięcej podróży zagranicznych: " + politician + " " + politician.numberOfTrips());
                break;
            case TripsMaxDaysAbroad:
                politicians = sejm.maxDaysAbroad();
                for (Politician p : politicians)
                    System.out.println("Najwięcej dni za granicą: " + p + " " + p.daysAbroad());
                break;
            case TripsMaxCost:
                politician = sejm.maxTripCosts();
                System.out.println("Najdroższa podróż zagraniczna: " +
                        politician + " " + Math.round(politician.maxTripCost() * 100) / 100.0 + " zł.");
                break;
            case TripsCountry:
                politicians = sejm.politiciansAbroad(arguments.getDetails());
                politicians.sort((a, b) ->
                        ((a.getLastName() + a.getFirstName()).compareTo((b.getLastName() + b.getFirstName()))));
                politicians.forEach(System.out::println);
                break;
        }
    }
}
