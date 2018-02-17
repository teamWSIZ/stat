package app.stat;

import java.util.Random;

public class A {
    public static void main(String[] args) {
        WeibullDistribution dist = new WeibullDistribution(1, 1);
        WeibullCumulativeDistribution f_wei = new WeibullCumulativeDistribution(dist, -10, 10, 10000);

        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            double x = f_wei.getX(r.nextDouble());
            System.out.println(x);
        }

    }
}
