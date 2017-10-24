package view;
import java.util.List;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

/**
 * 
 * 
 * 
 * 
**/

public class GraphView
{
	// Private fields
	private ScatterChart chart;
	
	
	
	/**
	 * 
	 * 
	 * 
	**/
	
	public GraphView (String chartName, String xAxisName, String yAxisName)
	{
		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel(xAxisName);
		
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel(yAxisName);
		
		this.chart = new ScatterChart(xAxis, yAxis);
	    chart.setTitle(chartName);
	} // GraphView Constructor (String, String, String)

	
	
	/**
	 * 
	**/
	
	public ScatterChart getChart ()
	{
		return chart;
	} // getChart()
	
	
} // class ResultsScatterPlot
