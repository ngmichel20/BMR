package g48962.atl.bmr.view;


import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;

/**
 * This is the Chart of the BMR and Height.
 * 
 * @author g48962
 */
public class BMRHeigthChart extends HBox {

    /**
     * Line who allow to connect the point
     */
    private final LineChart<Number, Number> lineChart;
    /**
     * Point of the chart
     */
    private final XYChart.Series segmentMen;
    /**
     * Point of the chart
     */
    private final XYChart.Series segmentWomen;

    /**
     * This method allows to initialize the attributes and create the chart.
     */
    public BMRHeigthChart() {
        NumberAxis xAxisName = new NumberAxis();
        NumberAxis yAxisName = new NumberAxis();
        xAxisName.setLabel("Height (cm)");
        yAxisName.setLabel("BMR");

        lineChart = new LineChart<>(xAxisName, yAxisName);
        lineChart.setTitle("Height (cm) Vs BMR");
        segmentMen = new XYChart.Series();
        segmentWomen = new XYChart.Series();
        segmentMen.setName("MenData");
        segmentWomen.setName("WomenData");

        lineChart.getData().add(segmentMen);
        lineChart.getData().add(segmentWomen);
        getChildren().add(lineChart);
    }

    /**
     * Give the line of the chart
     *
     * @return The line of the chart
     */
    public LineChart<Number, Number> getLineChart() {
        return lineChart;
    }

    /**
     * Give the line of the chart for the men
     *
     * @return The line of the chart for the men
     */
    public XYChart.Series getSegmentMen() {
        return segmentMen;
    }

    /**
     * Give the line of the chart for the women
     *
     * @return The line of the chart for the women
     */
    public XYChart.Series getSegmentWomen() {
        return segmentWomen;
    }
}


