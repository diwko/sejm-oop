package sejm;

import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Key = cadency
        HashMap<Integer, Sejm> sejmHashMap = new HashMap<>();
        do {
            try {
                ArgumentsParser parser = new ArgumentsParser(args);
                Arguments arguments = parser.parse();

                Sejm sejm;

                if(sejmHashMap.containsKey(arguments.getCadency()))
                    sejm = sejmHashMap.get(arguments.getCadency());
                else{
                    PoliticianJsonParser politicianJsonParser = new PoliticianJsonParser(arguments.getCadency());
                    sejm = politicianJsonParser.getSejm();
                    sejmHashMap.put(arguments.getCadency(), sejm);
                }

                SejmPrinter sejmPrinter = new SejmPrinter(sejm);
                sejmPrinter.print(arguments);

            } catch (IllegalArgumentException e){
                System.out.println(
                                "\n" +
                                "*********************************************************\n" +
                                "nr_kadencji  wydatki   suma       imię         nazwisko\n" +
                                "nr_kadencji  wydatki   remont     imię         nazwisko\n" +
                                "nr_kadencji  wydatki   średnia\n" +
                                "nr_kadencji  wyjazdy   najwięcej\n" +
                                "nr_kadencji  wyjazdy   najdłużej\n" +
                                "nr_kadencji  wyjazdy   najdrożej\n" +
                                "nr_kadencji  wyjazdy   kraj       nazwa_kraju\n" +
                                "*********************************************************");

            } catch (IOException | InterruptedException e) {
                System.out.println("Błąd pobierania danych");
            } catch (NoSuchElementException e){
                System.out.println("Brak danych");
            } finally {
                //Read arguments from console
                System.out.println("\n-------------------------------");
                System.out.println("Podaj argumenty (q - ZAKOŃCZ):");
                Scanner scanner = new Scanner(System.in);
                args = scanner.nextLine().split("\\s+");
            }

            if(args.length == 0)
                args = new String[]{""};

        } while(!args[0].toLowerCase().equals("q"));
    }

}
