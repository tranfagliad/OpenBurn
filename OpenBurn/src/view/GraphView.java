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
import model.calculations.SimulationResults;

/**
 * GraphView.java
 * 
 * Purpose: A wrapper class for the ScatterChart used in the application.
 * 		This class will allow the user to more easily create an empty
 * 		ScatterChart and add data sets to it.
**/

public class GraphView
{
	// Private fields
	private ScatterChart chart;
	
	
	
	/**
	 * GraphView Constructor (String, String, String)
	 * 
	 * Purpose: Takes in names for the x-axis, y-axis, and chart, then
	 * 		creates an empty ScatterChart that the user can access.
	**/
	
	public GraphView (String chartName, String xAxisName, String yAxisName)
	{
		// Create and name the x-axis
		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel(xAxisName);
		
		// Create and name the y-axis
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel(yAxisName);
		
		// Create and name the ScatterChart
		this.chart = new ScatterChart(xAxis, yAxis);
	    chart.setTitle(chartName);
	} // GraphView Constructor (String, String, String)

	
	
	/**
	 * getChart()
	 * 
	 * Purpose: Returns the ScatterChart contained within this GraphView.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: ScatterChart. The chart contained within this wrapper.
	**/
	
	public ScatterChart getChart ()
	{
		return chart;
	} // getChart()
	
	
	
	/**
	 * addDataSet()
	 * 
	 * Purpose: Takes in a list of simulation results, and adds the
	 * 		data into the chart. The name in the legend for the data
	 * 		set is given by the user.
	 * 
	 * Parameters:
	 * 		String legendName -- The displayed name for new data
	 * 			set in the legend.
	 * 		List<SimulationResults> results -- List of results from
	 * 			a simulation.
	 * 
	 * Returns: void.
	**/
	
	public void addDataSet (String legendName, List<SimulationResults> results)
	{
		ObservableList<XYChart.Series<Double, Double>> data = FXCollections.observableArrayList();
		
		Series<Double, Double> dataSeries = new Series<Double, Double>();
		dataSeries.setName(legendName);
		
		
		// ADDME: Loop through results to add to the dataSeries list.
		
		
		data.addAll(dataSeries);
	} // addDataSet()
	
} // class GraphView
