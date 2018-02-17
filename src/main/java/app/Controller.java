package app;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import org.apache.commons.math3.distribution.BetaDistribution;
import org.apache.commons.math3.distribution.CauchyDistribution;
import org.apache.commons.math3.distribution.WeibullDistribution;

import java.util.Random;

public class Controller {

    @FXML
    HBox fff;

    @FXML
    TextField a;

    @FXML
    TextField b;


    XYChart.Series<String, Number> series1;


    public void doSomething() throws Exception {

        //Defining the axes
        CategoryAxis xAxis = new CategoryAxis() ;

//        xAxis.setCategories(FXCollections.<String>
//                observableArrayList(Arrays.asList("Speed", "User rating" , "Milage" , "Safety") ));
//
//        xAxis.setLabel("category") ;

        NumberAxis yAxis = new NumberAxis() ;
        yAxis.setLabel("histogram") ;

        //Creating the Bar chart
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis) ;

        //Prepare XYChart.Series objects by setting data
        //

        series1 = new XYChart.Series<>() ;
        series1.setName("data bins") ;


        for (int i = 0; i < 10; i++) {
            //tu dodajemy dane typu "x" --> "y"
            series1.getData().add(new XYChart.Data<>("" + i, (int) (10 * Math.sin(1. * i / 3))) );
        }

        //Setting the data to bar chart
        barChart.getData().addAll(series1);

        fff.getChildren().add(barChart);


    }

    public void printWeibullHisto() {
        double alpha = Double.valueOf(a.getText());
        double beta = Double.valueOf(b.getText());

//        BetaDistribution weibullDistribution = new BetaDistribution(alpha, beta);    //k=5, beta=1
        CauchyDistribution cauchyDistribution = new CauchyDistribution(alpha, beta);    //k=5, beta=1
        double[] data = cauchyDistribution.sample(100_000);

        double binWidth = 0.05;
        int binCount = 30;

        int[] whisto = new int[binCount];
        for (int i = 0; i < data.length; i++) {
            int idx = (int)(data[i]/binWidth);
            if (idx>=binCount) continue;
            if (idx<0) continue;
            whisto[idx]++;
        }

        CategoryAxis xAxis = new CategoryAxis() ;
        NumberAxis yAxis = new NumberAxis() ;
        yAxis.setLabel("histogram") ;

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis) ;
        series1 = new XYChart.Series<>() ;
        series1.setName("data bins") ;


        for (int i = 0; i < whisto.length; i++) {
            series1.getData().add(new XYChart.Data<>("" + (i * binWidth), whisto[i]) );
        }

        //Setting the data to bar chart
        barChart.getData().addAll(series1);

        fff.getChildren().add(barChart);


    }

    public double[] generateRandomNumbers(int n) {
        Random r = new Random();
        double[] aaa = new double[n];
        for (int i = 0; i < n; i++) {
            aaa[i] = r.nextGaussian();
        }
        return aaa;
    }

    public void dodaj() {
        Random r = new Random();
        series1.getData().add(new XYChart.Data<>("" + r.nextInt(100),  r.nextInt(10)) );
    }
}
