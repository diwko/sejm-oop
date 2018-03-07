package sejm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class PoliticianJsonParserTest {
    PoliticianJsonParser parser;

    @Before
    public void setParser(){
        parser = new PoliticianJsonParser(1);
    }

    @Test
    public void parseCosts(){
        try {
            Method m = PoliticianJsonParser.class.getDeclaredMethod("parseCosts", String.class);
            m.setAccessible(true);
            List<Cost> costs;
            costs = (List<Cost>) m.invoke(parser, "{\"id\":\"399\",\"dataset\":\"poslowie\",\"url\":\"https:\\/\\/api-v3.mojepanstwo.pl\\/dane\\/poslowie\\/399\",\"mp_url\":\"https:\\/\\/mojepanstwo.pl\\/dane\\/poslowie\\/399\",\"schema_url\":\"https:\\/\\/api-v3.mojepanstwo.pl\\/schemas\\/dane\\/poslowie.json\",\"global_id\":\"1556900\",\"slug\":\"tomanski-piotr\",\"score\":null,\"data\":{\"ludzie.id\":\"390\",\"ludzie.nazwa\":\"Piotr Toma\\u0144ski\",\"ludzie.slug\":\"piotr-tomanski\",\"sejm_kluby.id\":\"1\",\"sejm_kluby.skrot\":\"PO\",\"sejm_kluby.nazwa\":\"Platforma Obywatelska\",\"poslowie.wartosc_biuro_inne\":3259.61,\"poslowie.wartosc_biuro_ekspertyzy\":0,\"poslowie.wartosc_biuro_materialy_biurowe\":9733.34,\"poslowie.frekwencja\":98.1,\"poslowie.mandat_wygasl\":\"0\",\"poslowie.wartosc_biuro_taksowki\":0,\"poslowie.sejm_okreg_id\":\"22\",\"poslowie.liczba_przelotow\":86,\"poslowie.wartosc_biuro_zlecenia\":0,\"poslowie.liczba_projektow_uchwal\":5,\"poslowie.imiona\":\"Piotr\",\"poslowie.biuro_html\":\"<table><thead><th class=\\\"left\\\">Wydatkowanie kwoty rycza\\u0142tu przeznaczonego na prowadzenie biura poselskiego:<\\/th><\\/thead><tbody><tr><td class=\\\"left\\\">Sprawozdanie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2011399\\/$File\\/2011ryczalt_399.pdf?OpenElement\\\" target=\\\"_blank\\\">2011 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Sprawozdanie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2012399\\/$File\\/2012ryczalt_399.pdf?OpenElement\\\" target=\\\"_blank\\\">2012 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Sprawozdanie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2013399\\/$File\\/2013ryczalt_399.pdf?OpenElement\\\" target=\\\"_blank\\\">2013 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Sprawozdanie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2014399\\/$File\\/2014ryczalt_399.pdf?OpenElement\\\" target=\\\"_blank\\\">2014 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Korekta za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2014399k\\/$File\\/2014ryczaltkor_399.pdf?OpenElement\\\" target=\\\"_blank\\\">2014 rok<\\/A><\\/td><\\/tr><tr><td class=\\\"left\\\">Rozliczenie za <A class=\\\"pdf right\\\" HREF=\\\"http:\\/\\/orka.sejm.gov.pl\\/rozlicz7.nsf\\/lista\\/2015399\\/$File\\/2015ryczalt_399.pdf?OpenElement\\\" target=\\\"_blank\\\">okres sprawowania mandatu <\\/A><\\/td><\\/tr><\\/tbody><\\/table>\",\"poslowie.wartosc_biuro_wynagrodzenia_pracownikow\":76748.99,\"poslowie.numer_legitymacji\":399,\"poslowie.imie_pierwsze\":\"Piotr\",\"poslowie.liczba_glosow\":9621,\"poslowie.procent_glosow\":3.23,\"poslowie.pkw_komitet_id\":\"3\",\"poslowie.wartosc_uposazenia_pln\":9892.3,\"poslowie.zawod\":\"ekonomista\",\"poslowie.data_urodzenia\":\"1969-06-25\",\"poslowie.okreg_gminy_str\":\"Przemy\\u015bl, Krosno, Jaros\\u0142aw\",\"poslowie.imie_drugie\":\"\",\"poslowie.kadencja_ostatnia\":\"7\",\"poslowie.wartosc_biuro_spotkania\":100,\"poslowie.liczba_glosowan_zbuntowanych\":25,\"poslowie.klub_id\":\"1\",\"poslowie.liczba_komisji\":2,\"poslowie.wartosc_wyjazdow\":910.41,\"poslowie.zbuntowanie\":0.4,\"poslowie.nazwa_odwrocona\":\"Toma\\u0144ski Piotr\",\"poslowie.twitter_account_id\":\"24\",\"poslowie.wartosc_biuro_przejazdy\":12000,\"poslowie.liczba_glosowan_opuszczonych\":116,\"poslowie.plec\":\"M\",\"poslowie.kadencja\":[7],\"poslowie.id\":\"399\",\"poslowie.wartosc_refundacja_kwater_pln\":0,\"poslowie.liczba_interpelacji\":74,\"poslowie.nazwa\":\"Piotr Toma\\u0144ski\",\"poslowie.dopelniacz\":\"Piotra Toma\\u0144skiego\",\"poslowie.wartosc_biuro_telekomunikacja\":10243.74,\"poslowie.liczba_uchwal_komisji_etyki\":0,\"poslowie.nazwisko\":\"Toma\\u0144ski\",\"poslowie.wartosc_biuro_biuro\":34338.43,\"poslowie.miejsce_urodzenia\":\"Przemy\\u015bl\",\"poslowie.wartosc_biuro_podroze_pracownikow\":7158.1,\"poslowie.krs_osoba_id\":\"400658\",\"poslowie.liczba_podkomisji\":1,\"poslowie.liczba_przejazdow\":31,\"poslowie.numer_na_liscie\":4,\"poslowie.rozliczenie_id\":\"274759\",\"poslowie.pkw_nr_listy\":\"0\",\"poslowie.liczba_wyjazdow\":2,\"poslowie.liczba_wypowiedzi\":20,\"poslowie.liczba_projektow_ustaw\":19,\"poslowie.liczba_glosowan\":6174,\"poslowie.liczba_wnioskow\":0,\"poslowie.miejsce_zamieszkania\":\"\\u017burawica\",\"poslowie.mowca_id\":\"390\",\"poslowie.okreg_wyborczy_numer\":\"22\",\"poslowie.liczba_slow\":6996,\"poslowie.wartosc_biuro_srodki_trwale\":170.97},\"layers\":{\"dataset\":null,\"channels\":null,\"page\":null,\"subscribers\":null,\"krs\":{\"biznes\":[{\"organizacja\":{\"id\":\"107402\",\"nazwa\":\"VIDEO TOMEX 2\",\"forma_prawna_str\":\"SP\\u00d3\\u0141KA Z OGRANICZON\\u0104 ODPOWIEDZIALNO\\u015aCI\\u0104\",\"kapital_zakladowy\":\"1962000.00\",\"cel_dzialania\":\"\",\"data_rejestracji\":\"2002-04-16\"},\"rola\":{\"id\":\"1080489\",\"label\":\"PREZES ZARZ\\u0104DU\",\"deleted\":\"0\"},\"forma\":{\"typ_id\":\"1\"}},{\"organizacja\":{\"id\":\"107402\",\"nazwa\":\"VIDEO TOMEX 2\",\"forma_prawna_str\":\"SP\\u00d3\\u0141KA Z OGRANICZON\\u0104 ODPOWIEDZIALNO\\u015aCI\\u0104\",\"kapital_zakladowy\":\"1962000.00\",\"data_rejestracji\":\"2002-04-16\"},\"rola\":{\"id\":\"80579\",\"udzialy_str\":\"981 UDZIA\\u0141\\u00d3W O \\u0141\\u0104CZNEJ WARTO\\u015aCI 196 200,00 Z\\u0141\",\"deleted\":\"0\",\"label\":\"Wsp\\u00f3lnik\"}}],\"ngo\":[]},\"wydatki\":{\"liczba_pol\":20,\"liczba_rocznikow\":2,\"punkty\":[{\"tytul\":\"Wydatki na wynagrodzenia pracownik\\u00f3w biura poselskiego zatrudnionych na podstawie umowy o prac\\u0119 wraz z pochodnymi\",\"numer\":\"1\"},{\"tytul\":\"Koszty bada\\u0144 lekarskich i szkole\\u0144 pracownik\\u00f3w zatrudnionych w biurze poselskim na podstawie umowy o prac\\u0119\",\"numer\":\"2\"},{\"tytul\":\"Wydatki na wynagrodzenia wyp\\u0142acane na podstawie zawartych przez pos\\u0142a um\\u00f3w zlece\\u0144 i o dzie\\u0142o wraz z pochodnymi\",\"numer\":\"3\"},{\"tytul\":\"Koszty ekspertyz, opinii, t\\u0142umacze\\u0144\",\"numer\":\"4\"},{\"tytul\":\"Koszty us\\u0142ug telekomunikacyjnych zwi\\u0105zanych z wykonaniem mandatu poselskiego (nie obejmuj\\u0105 koszt\\u00f3w us\\u0142ug telekomunikacyjnych w \\\"Domu Poselskim\\\" oraz w kwaterach prywatnych w Warszawie, potr\\u0105canych przez Kancelari\\u0119 Sejmu z rycza\\u0142tu na biuro poselskie)\",\"numer\":\"5\"},{\"tytul\":\"Koszty us\\u0142ug telekomunikacyjnych w \\\"Domu Poselskim\\\" oraz w kwaterach prywatnych w Warszawie, potr\\u0105canych przez Kancelari\\u0119 Sejmu z rycza\\u0142tu na biuro poselskie\",\"numer\":\"6\"},{\"tytul\":\"Koszty korespondencji i og\\u0142osze\\u0144\",\"numer\":\"7\"},{\"tytul\":\"Koszty wynajmowania sal na spotkania z wyborcami\",\"numer\":\"8\"},{\"tytul\":\"Koszty przejazd\\u00f3w pos\\u0142a w zwi\\u0105zku z wykonaniem mandatu poselskiego samochodem w\\u0142asnym lub innym\",\"numer\":\"9\"},{\"tytul\":\"Koszty przejazd\\u00f3w pos\\u0142a w zwi\\u0105zku z wykonywaniem mandatu poselskiego taks\\u00f3wkami\",\"numer\":\"10\"},{\"tytul\":\"Koszty najmu lokalu biura poselskiego, w tym: czynsz, op\\u0142aty za energi\\u0119 elektryczn\\u0105 i ciepln\\u0105, gaz, wod\\u0119, wyw\\u00f3z \\u015bmieci, podatki i op\\u0142aty lokalne\",\"numer\":\"11\"},{\"tytul\":\"Koszty konserwacji i naprawy sprz\\u0119tu technicznego biura poselskiego oraz koszty jego eksploatacji\",\"numer\":\"12\"},{\"tytul\":\"Koszty drobnych napraw i remont\\u00f3w lokalu biura poselskiego\",\"numer\":\"13\"},{\"tytul\":\"Zakup materia\\u0142\\u00f3w biurowych, prasy, wydawnictw, \\u015brodk\\u00f3w bhp itp.\",\"numer\":\"14\"},{\"tytul\":\"Zakup \\u015brodk\\u00f3w trwalych o charakterze wyposa\\u017cenia*\",\"numer\":\"15\"},{\"tytul\":\"Koszty podr\\u00f3\\u017cy s\\u0142u\\u017cbowych pracownik\\u00f3w biura poselskiego, zatrudnionych na podstawie umowy o prac\\u0119\",\"numer\":\"16\"},{\"tytul\":\"Odpis na fundusz \\u015bwiadcze\\u0144 socjalnych\",\"numer\":\"17\"},{\"tytul\":\"\\u015awiadczenia urlopowe wyp\\u0142acane pracownikom biura poselskiego, zatrudnionych na podstawie umowy o prac\\u0119\",\"numer\":\"18\"},{\"tytul\":\"Koszty obs\\u0142ugi rachunkowo-ksi\\u0119gowej i bankowej biura poselskiego\",\"numer\":\"19\"},{\"tytul\":\"Inne wydatki zwi\\u0105zane z prowadzeniem biura poselskiego (og\\u00f3\\u0142em)\",\"numer\":\"20\"}],\"roczniki\":[{\"pola\":[\"74561.13\",\"0.00\",\"0.00\",\"0.00\",\"10243.74\",\"0.00\",\"6026.91\",\"100.00\",\"12000.00\",\"0.00\",\"21048.70\",\"4866.81\",\"19.98\",\"9733.34\",\"170.97\",\"7158.10\",\"0.00\",\"2187.86\",\"2376.03\",\"3259.61\"],\"dokument_id\":\"452247\",\"rok\":\"2013\"},{\"pola\":[\"54680.32\",\"0.00\",\"0.00\",\"0.00\",\"15352.60\",\"0.00\",\"5317.14\",\"0.00\",\"34800.00\",\"0.00\",\"15768.00\",\"4958.44\",\"0.00\",\"7113.50\",\"47.99\",\"3346.83\",\"0.00\",\"1914.38\",\"2349.90\",\"3791.88\"],\"dokument_id\":\"365272\",\"rok\":\"2012\"}]}},\"Aggs\":{\"_page\":{\"doc_count\":0,\"page\":{\"hits\":{\"total\":0,\"max_score\":null,\"hits\":[]}}}}}");

            Field values = Cost.class.getDeclaredField("values");
            values.setAccessible(true);
            List<Double> values1Test = (List<Double>) values.get(costs.get(0));
            List<Double> values2Test = (List<Double>) values.get(costs.get(1));

            List<Double> values1 = Arrays.asList(74561.13, 0.00,0.00,0.00,10243.74,0.00,6026.91,100.00,12000.00,0.00,21048.70,4866.81,19.98,9733.34,170.97,7158.10,0.00,2187.86,2376.03,3259.61);
            List<Double> values2 = Arrays.asList(54680.32,0.00,0.00,0.00,15352.60,0.00,5317.14,0.00,34800.00,0.00,15768.00,4958.44,0.00,7113.50,47.99,3346.83,0.00,1914.38,2349.90,3791.88);

            assertArrayEquals(values1.toArray(), values1Test.toArray());
            assertArrayEquals(values2.toArray(), values2Test.toArray());

            Field year = Cost.class.getDeclaredField("year");
            year.setAccessible(true);

            assertEquals(2013, (int) year.get(costs.get(0)));
            assertEquals(2012, (int) year.get(costs.get(1)));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

}