package app.stat;

import java.util.Arrays;

public class CumulativeDistribution {
    double[] xvalues;
    double[] Fvalues;
    double dx;

    public CumulativeDistribution(Distribution distr, double minx, double maxx, int countX) {
        dx = (maxx - minx) / countX;
        xvalues = new double[countX + 1];
        Fvalues = new double[countX + 1];

        double F = 0;
        double x = minx;
        for (int i = 0; i < countX; i++) {
            xvalues[i] = x;
            Fvalues[i] = F;

            F += (distr.getRho(x) + distr.getRho(x + dx)) * dx / 2;
            x += dx;
        }
    }

    public double getF(double x) {
        int idx = Arrays.binarySearch(xvalues, x);
        if (idx<0) idx = -idx -1;
        if (idx >= Fvalues.length) idx = Fvalues.length-1;
        return Fvalues[idx];
    }

    public double getX(double F) {
        int idx = Arrays.binarySearch(Fvalues, F);
        if (idx<0) idx = -idx -1;
        if (idx >= xvalues.length) idx = xvalues.length-1;
        return xvalues[idx];
    }

}
