package app.stat;

import static java.lang.Math.exp;
import static java.lang.Math.pow;

public class WeibullDistribution implements Distribution {
    double lambda;
    double k;

    public WeibullDistribution(double lambda, double rho) {
        this.lambda = lambda;
        this.k = rho;
    }

    @Override
    public double getRho(double x) {
        if (x<0) return 0;
        double xl = x / lambda;

        return k / lambda * pow(xl, k - 1) * exp(- pow(xl, k));
    }
}
