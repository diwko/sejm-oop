package sejm;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArgumentsParserTest {


    @Test
    public void parse() throws Exception {
        ArgumentsParser testParser = new ArgumentsParser(new String[]{"1","wyjazdy","najwiecej"});
        Arguments testArgumetns = testParser.parse();
        assertEquals(testArgumetns.getCadency(), 1);
        assertEquals(testArgumetns.getAttribute(), Attribute.TripsMaxTimesAbroad);

        testParser = new ArgumentsParser(new String[]{"2","wyjazdy","najdłużej"});
        testArgumetns = testParser.parse();
        assertEquals(testArgumetns.getCadency(), 2);
        assertEquals(testArgumetns.getAttribute(), Attribute.TripsMaxDaysAbroad);

        testParser = new ArgumentsParser(new String[]{"20","wydatki","srednia"});
        testArgumetns = testParser.parse();
        assertEquals(testArgumetns.getCadency(), 20);
        assertEquals(testArgumetns.getAttribute(), Attribute.CostsAverage);

        testParser = new ArgumentsParser(new String[]{"4","wydatki","suma", "Jan", "Nowak"});
        testArgumetns = testParser.parse();
        assertEquals(testArgumetns.getCadency(), 4);
        assertEquals(testArgumetns.getAttribute(), Attribute.CostsSum);
        assertEquals(testArgumetns.getDetails(), "Jan Nowak");

        testParser = new ArgumentsParser(new String[]{"8","wydatki","remont", "Michał", "Kowalski"});
        testArgumetns = testParser.parse();
        assertEquals(testArgumetns.getCadency(), 8);
        assertEquals(testArgumetns.getAttribute(), Attribute.CostsOfficeRepair);
        assertEquals(testArgumetns.getDetails(), "Michał Kowalski");

        testParser = new ArgumentsParser(new String[]{"15","wyjazdy","kraj", "Włochy"});
        testArgumetns = testParser.parse();
        assertEquals(testArgumetns.getCadency(), 15);
        assertEquals(testArgumetns.getAttribute(), Attribute.TripsCountry);
        assertEquals(testArgumetns.getDetails(), "Włochy");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseException() throws Exception {
        ArgumentsParser testParser = new ArgumentsParser(new String[]{"1","wyjazdy"});
        Arguments testArgumetns = testParser.parse();
    }


}