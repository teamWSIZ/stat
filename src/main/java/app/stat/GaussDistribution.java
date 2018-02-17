package app.stat;

import static java.lang.Math.PI;
import static java.lang.Math.exp;
import static java.lang.Math.sqrt;

public class GaussDistribution implements Distribution {
    double avg, sigma;

    public GaussDistribution(double avg, double sigma) {
        this.avg = avg;
        this.sigma = sigma;
    }

    @Override
    public double getRho(double x) {
        return 1. / (sqrt(2 * PI) * sigma) * exp(- (x - avg) * (x- avg) / (2 * sigma * sigma));
    }

}
