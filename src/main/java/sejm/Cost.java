package sejm;

import java.util.List;

public class Cost {
    private int year;
    private List<Double> values;

    public Cost(int year, List<Double> values) {
        this.year = year;
        this.values = values;
    }

    public int getYear() {
        return year;
    }

    public double getSum() {
        double sum = 0;
        for (double value : values)
            sum += value;
        return sum;
    }

    public double getOfficeRepair() {
        return values.get(12);
    }
}
