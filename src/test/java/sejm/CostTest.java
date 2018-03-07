package sejm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CostTest {
    List<Double> values = new ArrayList<>(
            Arrays.asList(3.94, 67.69, 8.2, 1933.09, 78.11, 37.5, 23.1, 36.99, 31.37, 8.2,
                    99.26, 12.22, 690.92, 81.48, 12.45, 2.1, 3800.05, 71.84, 22.58, 93.23));
    private Cost cost = new Cost(2016, values);;

    @Test
    public void getYear() {
        assertEquals(2016, cost.getYear());
    }

    @Test
    public void getSum() {
        assertEquals(7114.32, cost.getSum(), 0.001);
    }

    @Test
    public void getOfficeRepair() throws Exception {
        assertEquals(690.92, cost.getOfficeRepair(), 0.001);
    }

}