package sejm;

public class ArgumentsParser {
    private String[] arguments;
    private Arguments parsedArguments;

    public ArgumentsParser(String[] args) {
        arguments = args;
        parsedArguments = new Arguments();
    }

    public Arguments parse() throws IllegalArgumentException {
        if (arguments.length < 3 || arguments.length > 5) {
            System.out.println("Niepoprawna liczba argumentów");
            throw new IllegalArgumentException();
        }

        try {
            parsedArguments.setCadency(Integer.valueOf(arguments[0]));
        } catch (NumberFormatException e) {
            System.out.println("Pierwszy argument nie jest liczbą");
            throw new IllegalArgumentException();
        }

        if (arguments[1].toLowerCase().equals("wydatki")) {
            parseCosts();
        } else if (arguments[1].toLowerCase().equals("wyjazdy")) {
            parseTrips();
        } else {
            System.out.println("Niepoprawny drugi argument. Wybierz: wydatki / wyjazdy");
            throw new IllegalArgumentException();
        }

        return parsedArguments;
    }

    private void parseCosts() throws IllegalArgumentException {
        String arg3 = arguments[2].toLowerCase();

        if (arg3.equals("suma")) {
            if(arguments.length == 5){
                parsedArguments.setAttribute(Attribute.CostsSum);
                parsedArguments.setDetails(arguments[3] + " " + arguments[4]);
            }
            else {
                System.out.println("Nie podano imienia i nazwiska posła");
                throw new IllegalArgumentException();
            }
        } else if (arg3.equals("remont") && arguments.length == 5) {
            if(arguments.length == 5){
                parsedArguments.setAttribute(Attribute.CostsOfficeRepair);
                parsedArguments.setDetails(arguments[3] + " " + arguments[4]);
            }
            else {
                System.out.println("Nie podano imienia i nazwiska posła");
                throw new IllegalArgumentException();
            }
        } else if (arg3.equals("średnia") || arg3.equals("srednia")) {
            if(arguments.length == 3){
                parsedArguments.setAttribute(Attribute.CostsAverage);
            }
            else {
                System.out.println("Podano za dużo argumentów");
                throw new IllegalArgumentException();
            }
        } else {
            System.out.println("Niepoprawny trzeci argument. Wybierz: suma / remont / srednia");
            throw new IllegalArgumentException();
        }
    }

    private void parseTrips() throws IllegalArgumentException {
        if(arguments.length > 4){
            System.out.println("Za dużo argumentów");
            throw new IllegalArgumentException();
        }

        String arg3 = arguments[2].toLowerCase();
        if (arg3.equals("najwięcej") || arg3.equals("najwiecej")) {
            parsedArguments.setAttribute(Attribute.TripsMaxTimesAbroad);
        } else if (arg3.equals("najdłużej") || arg3.equals("najdluzej")) {
            parsedArguments.setAttribute(Attribute.TripsMaxDaysAbroad);
        } else if (arg3.equals("najdrożej") || arg3.equals("najdrozej")) {
            parsedArguments.setAttribute(Attribute.TripsMaxCost);
        } else if (arg3.equals("kraj")) {
            if(arguments.length == 4){
                parsedArguments.setAttribute(Attribute.TripsCountry);
                parsedArguments.setDetails(arguments[3]);
            }
            else {
                System.out.println("Niepoprawna liczba argumentów");
                throw new IllegalArgumentException();
            }
        } else {
            System.out.println("Niepoprawny trzeci argument. Wybierz: najwięcej / najdłużej / najdrożej / kraj");
            throw new IllegalArgumentException();
        }

    }
}
