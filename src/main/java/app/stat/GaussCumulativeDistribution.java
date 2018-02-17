package app.stat;

public class GaussCumulativeDistribution extends CumulativeDistribution {
    public GaussCumulativeDistribution(GaussDistribution distr, double minx, double maxx, int countX) {
        super(distr, minx, maxx, countX);
    }
}
