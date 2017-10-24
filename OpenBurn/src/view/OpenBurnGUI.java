package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class OpenBurnGUI extends Application
{
	// General prompts
	private static final String GRAIN_PROMPT   = "Enter number of grains (Must enter at least 1): ";
	private static final String DENSITY_PROMPT = "Enter propellant density (Must be positive): ";
	private static final String FILE_PROMPT    = "\nEnter the desired name of the CSV file (Don't include \".csv\"): ";
	
	// Grain prompts
	private static final String OUTER_DIAMETER_PROMPT = "Enter grain outer diameter (Must be positive): ";
	private static final String INNER_DIAMETER_PROMPT = "Enter grain inner diameter (Must be positive): ";
	private static final String LENGTH_PROMPT         = "Enter grain length (Must be positive): ";
	private static final String BURNING_ENDS_PROMPT   = "Enter grain number of burning ends (Must be 0, 1, or 2): ";
	
	// Nozzle prompts
	private static final String THROAT_DIAMETER_PROMPT   = "\nEnter nozzle throat diameter (Must be positive): ";
	private static final String ENTRANCE_DIAMETER_PROMPT = "Enter nozzle entrance diameter (Must be positive): ";
	private static final String EXIT_DIAMETER_PROMPT     = "Enter nozzle exit diameter (Must be positive): ";
	private static final String CF_PROMPT                = "Enter nozzle CF (Must be positive): ";
	
	
	
	// Time Delta prompt
	private static final String TIME_DELTA_PROMPT = "Enter change in time (Must be positive): ";
	
	
	
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	
	@Override
	public void start(Stage stage)
	{
		StackPane root = new StackPane();
		Scene scene = new Scene(root, 900, 650);
		stage.setScene(scene);
		stage.setTitle("OpenBurn");

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);

		scene.setRoot(grid);

		final TextField name = new TextField();
		name.setPromptText(GRAIN_PROMPT);
		name.setPrefColumnCount(10);
		GridPane.setConstraints(name, 0, 0);
		grid.getChildren().add(name);
		
		final TextField field2 = new TextField();
		field2.setPromptText(DENSITY_PROMPT);
		field2.setPrefColumnCount(10);
		field2.getText();
		GridPane.setConstraints(field2, 0, 3);
		grid.getChildren().add(field2);
		
		final TextField field3 = new TextField();
		field3.setPromptText(FILE_PROMPT);
		field3.setPrefColumnCount(10);
		field3.getText();
		GridPane.setConstraints(field3, 0, 6);
		grid.getChildren().add(field3);
		
		final TextField field4 = new TextField();
		field4.setPromptText(OUTER_DIAMETER_PROMPT);
		field4.setPrefColumnCount(10);
		field4.getText();
		GridPane.setConstraints(field4, 0, 9);
		grid.getChildren().add(field4);
		
		final TextField field5 = new TextField();
		field5.setPromptText(INNER_DIAMETER_PROMPT);
		field5.setPrefColumnCount(10);
		field5.getText();
		GridPane.setConstraints(field5, 0, 12);
		grid.getChildren().add(field5);
		
		final TextField field6 = new TextField();
		field6.setPromptText(LENGTH_PROMPT);
		field6.setPrefColumnCount(10);
		field6.getText();
		GridPane.setConstraints(field6, 0, 15);
		grid.getChildren().add(field6);
		
		final TextField field7 = new TextField();
		field7.setPromptText(BURNING_ENDS_PROMPT);
		field7.setPrefColumnCount(10);
		field7.getText();
		GridPane.setConstraints(field7, 3, 0);
		grid.getChildren().add(field7);
		
		final TextField field8 = new TextField();
		field8.setPromptText(THROAT_DIAMETER_PROMPT);
		field8.setPrefColumnCount(10);
		field8.getText();
		GridPane.setConstraints(field8, 3, 3);
		grid.getChildren().add(field8);
		
		final TextField field9 = new TextField();
		field9.setPromptText(ENTRANCE_DIAMETER_PROMPT);
		field9.setPrefColumnCount(10);
		field9.getText();
		GridPane.setConstraints(field9, 3, 6);
		grid.getChildren().add(field9);
		
		final TextField field10 = new TextField();
		field10.setPromptText(EXIT_DIAMETER_PROMPT);
		field10.setPrefColumnCount(10);
		field10.getText();
		System.out.print(field10.getText());
		GridPane.setConstraints(field10, 3, 9);
		grid.getChildren().add(field10);
		
		final TextField field11 = new TextField();
		field11.setPromptText(CF_PROMPT);
		field11.setPrefColumnCount(10);
		field11.getText();
		GridPane.setConstraints(field11, 3, 12);
		grid.getChildren().add(field11);
		
		final TextField field12 = new TextField();
		field12.setPromptText(TIME_DELTA_PROMPT);
		field12.setPrefColumnCount(10);
		field12.getText();
		GridPane.setConstraints(field12, 3, 15);
		grid.getChildren().add(field12);
		
		
		grid.getChildren().add(new GraphView("Pressure vs. Time", "Time", "Pressure").getChart());
		
    	
		stage.show();
	}

		
	
  
}

