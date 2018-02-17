package app.stat;

import java.util.Arrays;

public class WeibullCumulativeDistribution extends CumulativeDistribution {

    public WeibullCumulativeDistribution(WeibullDistribution distr, double minx, double maxx, int countX) {
        super(distr, minx, maxx, countX);
    }
}
