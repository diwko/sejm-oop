package sejm;

import org.json.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.*;

public class PoliticianJsonParser {
    private int cadency;
    private String allPoliticiansURL =
            "https://api-v3.mojepanstwo.pl/dane/poslowie.json";
    private String costsAndTripsURL =
            "https://api-v3.mojepanstwo.pl/dane/poslowie/{$id}.json?layers[]=wydatki&layers[]=wyjazdy";


    public PoliticianJsonParser(int cadency) {
        this.cadency = cadency;
    }

    private List<Politician> parsePoliticians(int page) throws IOException {
        String jsonText = loadPoliticiansJson(cadency, page);
        JSONObject jsonObject = new JSONObject(jsonText);
        JSONArray politiciansJson = jsonObject.getJSONArray("Dataobject");

        if (politiciansJson.length() == 0)
            return null;

        List<Politician> politicians = new LinkedList<>();
        for (int j = 0; j < politiciansJson.length(); j++) {
            JSONObject politicianJson = politiciansJson.getJSONObject(j);
            int id = politicianJson.getInt("id");

            JSONObject data = politicianJson.getJSONObject("data");
            String firstName = data.getString("poslowie.imie_pierwsze");
            String lastName = data.getString("poslowie.nazwisko");

            politicians.add(new Politician(id, firstName, lastName));
        }
        return politicians;
    }

    private List<Cost> parseCosts(String jsonText) {
        List<Cost> costs = new ArrayList<>();
        try {
            JSONArray costsJson =
                    new JSONObject(jsonText)
                            .getJSONObject("layers")
                            .getJSONObject("wydatki")
                            .getJSONArray("roczniki");

            for (int i = 0; i < costsJson.length(); i++) {
                JSONObject yearJson = costsJson.getJSONObject(i);
                int year = yearJson.getInt("rok");
                List<Double> values = new ArrayList<>();
                JSONArray valuesJson = yearJson.getJSONArray("pola");

                for (int j = 0; j < valuesJson.length(); j++)
                    values.add(valuesJson.getDouble(j));

                costs.add(new Cost(year, values));
            }
        } catch (org.json.JSONException e) {
            //Politician don't have costs
        }
        return costs;
    }

    private List<Trip> parseTrips(String jsonText) {
        List<Trip> trips = new ArrayList<>();
        try {
            JSONArray tripsJson =
                    new JSONObject(jsonText)
                            .getJSONObject("layers")
                            .getJSONArray("wyjazdy");
            for (int i = 0; i < tripsJson.length(); i++) {
                JSONObject tripJson = tripsJson.getJSONObject(i);
                trips.add(
                        new Trip(
                                Integer.valueOf(tripJson.getString("do").substring(0, 4)),
                                tripJson.getString("kraj"),
                                tripJson.getInt("liczba_dni"),
                                tripJson.getDouble("koszt_suma")));
            }
        } catch (org.json.JSONException e) {
            //Politician don't have trips
        }
        return trips;
    }

    private String loadPoliticiansJson(int cadency, int page) throws IOException {
        String url = allPoliticiansURL +
                "?conditions[poslowie.kadencja]=" + cadency +
                "&page=" + page;

        return URLReader.loadURL(url);
    }

    private URLReader loadPoliticianDataThread(int id) {
        String url = costsAndTripsURL.replace("{$id}", id + "");

        return new URLReader(url);
    }

    private String loadPoliticianDataJson(int id) throws IOException {
        String url = costsAndTripsURL.replace("{$id}", id + "");
        return URLReader.loadURL(url);
    }

    private Politician findPolitician(String firstname, String lastname) throws IOException {
        firstname = firstname.toLowerCase();
        lastname = lastname.toLowerCase();

        for (int page = 1; ; page++) {
            JSONObject jsonObject = new JSONObject(loadPoliticiansJson(cadency, page));
            JSONArray politiciansJson = jsonObject.getJSONArray("Dataobject");

            if (politiciansJson.length() == 0)
                return null;

            for (int j = 0; j < politiciansJson.length(); j++) {
                JSONObject politicianJson = politiciansJson.getJSONObject(j);
                JSONObject data = politicianJson.getJSONObject("data");

                String fn = data.getString("poslowie.imie_pierwsze");
                String ln = data.getString("poslowie.nazwisko");

                if (fn.toLowerCase().equals(firstname) && ln.toLowerCase().equals(lastname)) {
                    int id = politicianJson.getInt("id");
                    return new Politician(id, fn, ln);
                }
            }
        }
    }

    public Politician getPolitician(String firstname, String lastname) throws IOException {
        Politician politician = findPolitician(firstname, lastname);

        if (politician == null)
            return null;

        String politicianDataJson = loadPoliticianDataJson(politician.getId());
        politician.addCosts(parseCosts(politicianDataJson));
        politician.addTrips(parseTrips(politicianDataJson));

        return politician;
    }

    public Sejm getSejm() throws IOException, InterruptedException, NoSuchElementException {
        List<Politician> politicians = new LinkedList<>();

        System.out.println("Proszę czekać, trwa pobieranie listy posłów...");
        for (int page = 1; ; page++) {
            List<Politician> politiciansPage = parsePoliticians(page);
            if (politiciansPage == null)
                break;
            else
                politicians.addAll(politiciansPage);
        }

        ExecutorService executor = Executors.newFixedThreadPool(200);
        List<URLReader> readers = new ArrayList<>(600);
        for (Politician politician : politicians)
            readers.add(loadPoliticianDataThread(politician.getId()));

        System.out.println("Proszę czekać trwa pobieranie szczegółowych danych...");
        for(URLReader reader : readers)
            executor.execute(reader);

        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);

        for (int i = 0; i < politicians.size(); i++) {
            String jsonText = readers.get(i).toString();
            if (jsonText == null)
                throw new IOException();

            politicians.get(i).addCosts(parseCosts(jsonText));
            politicians.get(i).addTrips(parseTrips(jsonText));
        }
        if(politicians.size() == 0)
            throw new NoSuchElementException();
        return new Sejm(cadency, politicians);
    }
}
