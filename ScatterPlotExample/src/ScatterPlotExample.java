
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class ScatterPlotExample extends Application
{
	final double SCALE_DELTA = 1.1;
	
	
	
	@Override
	public void start(Stage stage)
	{
		stage.setTitle("Deez Nuts");
		StackPane root = new StackPane();
	    Scene scene = new Scene(root, 600, 850);
	    
	    NumberAxis xAxis = new NumberAxis();
	    NumberAxis yAxis = new NumberAxis();
	    
	    xAxis.setLabel("Time");
	    yAxis.setLabel("Distance");
	    
	    ScatterChart chart = new ScatterChart(xAxis, yAxis, getData());
	    chart.setTitle("On Your Chin");
	    
	    root.getChildren().add(chart);
	    
	    
	    
	    
	    
	    stage.setScene(scene);
	    stage.show();
	}

	
	public static void main(String[] args)
	{
		launch(args);
	}

	
	
	private static ObservableList<Series<Double, Double>> getData ()
	{
		ObservableList<XYChart.Series<Double, Double>> data = FXCollections.observableArrayList();
		
		Series<Double, Double> s = new Series<>();
		s.setName("Data Set 1");
		
		Series<Double, Double> t = new Series<>();
		t.setName("Data Set 2");
		
		Double xValue1 = (Double)(7.3);
		Double yValue1 = (Double)(1.8);
		
		Double xValue2 = (Double)(5.5);
		Double yValue2 = (Double)(3.4);
		
		for (int i = 0; i < 100; i++)
		{
			s.getData().add(new XYChart.Data(xValue1, yValue1));
			
			xValue1 += (Double)(Math.random() % 10);
			yValue1 += (Double)(Math.random() % 10);
			
			xValue2 += (Double)(Math.random() % 10);
			yValue2 += (Double)(Math.random() % 10);
		}
		
		data.addAll(s);
		data.addAll(t);
		
		return data;
	}
	
	
	
	
	
	
	
}
