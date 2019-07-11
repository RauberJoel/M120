package rcas.controller;

import com.sun.org.apache.xpath.internal.operations.Variable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import rcas.model.RaceCar;
import rcas.util.CorneringAnalyserUtil;
import rcas.util.Variables;

import java.util.Iterator;

public class PropertieController {
    @FXML
    public LineChart<Number, Number> linechart;

    @FXML
    private Tab tabProperties;

    private RaceCar raceCar;

    @FXML
    public void initialize() {
        switch(Variables.selectedCar){
            case "AudiR8":
                raceCar = Variables.ARaceCar;
                break;
            case "Lambo":
                raceCar = Variables.LRaceCar;
                break;
            case "New":
                raceCar = Variables.NRaceCar;
                break;
        }

        linechart.getData().clear();
        CorneringAnalyserUtil corneringUtil = new CorneringAnalyserUtil();
        if(raceCar != null) {
            ObservableList<XYChart.Series<Number, Number>> dataList_1 = corneringUtil.generateMMMChartData(raceCar);

            linechart.getData().addAll(dataList_1);
            // Set the style of the series after adding the data to the chart.
            // Otherwise no there is no reference "Node" which leads to a
            // NullPointerException.

            this.setSeriesStyle(dataList_1, ".chart-series-line", "-fx-stroke: blue; -fx-stroke-width: 1px;");

            ObservableList<XYChart.Series<Number, Number>> dataList_2 = corneringUtil.generateMMMChartData(raceCar);
            linechart.getData().addAll(dataList_2);
            this.setSeriesStyle(dataList_2, ".chart-series-line", "-fx-stroke: red; -fx-stroke-width: 1px;");
        }
    }

    private void setSeriesStyle(ObservableList<XYChart.Series<Number, Number>> dataList_1, String styleSelector,
                                String lineStyle) {
        for (Iterator<XYChart.Series<Number, Number>> iterator = dataList_1.iterator(); iterator.hasNext();) {
            XYChart.Series<Number, Number> curve = (XYChart.Series<Number, Number>) iterator.next();
            curve.getNode().lookup(styleSelector).setStyle(lineStyle);
        }
    }
}
