package view;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.calculations.SimulationSummary;


/**
 * SimulationSummaryView.java
 * 
 * Purpose: Displays a summary of the simulation
**/
public class SimulationSummaryView extends Pane
{
	//LABELS
	private static final String CLASSIFICATION_TEXT = "Classification:\n";
	private static final String ISP_TEXT = "ISP:\n";
	private static final String MASS_FRAC_TEXT = "Mass Frac:\n";
	private static final String IMPULSE_TEXT = "Impulse:\n";
	private static final String AVERAGE_THRUST_TEXT = "Average Thrust:\n";
	private static final String MAX_THRUST_TEXT = "Max Thrust:\n";
	private static final String MAX_PRESSURE_TEXT = "Max Pressure:\n";
	private static final String BURN_TIME_TEXT = "Burn Time:\n";
	
	//components
	private Text classification;
	private Text ISP;
	private Text massFrac;
	private Text impulse;
	private Text averageThrust;
	private Text maxThrust;
	private Text maxPressure;
	private Text burnTime;
	
	// Constants
	private static final int FIRST_COL_X = 20;
	private static final int SECOND_COL_X = 250;
	private static final int FIRST_ROW_Y  = 30;
	private static final int SECOND_ROW_Y = 110;
	private static final int THIRD_ROW_Y = 190;
	private static final int FOURTH_ROW_Y = 270;
	
	/**
	 * SimulationSummaryView Constructor
	 * 
	 * Purpose: Creates and initializes the Text fields fields for the summary.
	**/
	public SimulationSummaryView()
	{
		super();
		
		classification = new Text(CLASSIFICATION_TEXT);
		classification.setTranslateX(FIRST_COL_X);
		classification.setTranslateY(FIRST_ROW_Y);
		this.getChildren().add(classification);
		
		ISP = new Text(ISP_TEXT);
		ISP.setTranslateX(SECOND_COL_X);
		ISP.setTranslateY(FIRST_ROW_Y);
		this.getChildren().add(ISP);
		
		massFrac = new Text(MASS_FRAC_TEXT);
		massFrac.setTranslateX(FIRST_COL_X);
		massFrac.setTranslateY(SECOND_ROW_Y);
		this.getChildren().add(massFrac);
		
		impulse = new Text(IMPULSE_TEXT);
		impulse.setTranslateX(SECOND_COL_X);
		impulse.setTranslateY(SECOND_ROW_Y);
		this.getChildren().add(impulse);
		
		averageThrust = new Text(AVERAGE_THRUST_TEXT);
		averageThrust.setTranslateX(FIRST_COL_X);
		averageThrust.setTranslateY(THIRD_ROW_Y);
		this.getChildren().add(averageThrust);
		
		maxThrust = new Text(MAX_THRUST_TEXT);
		maxThrust.setTranslateX(SECOND_COL_X);
		maxThrust.setTranslateY(THIRD_ROW_Y);
		this.getChildren().add(maxThrust);
		
		maxPressure = new Text(MAX_PRESSURE_TEXT);
		maxPressure.setTranslateX(FIRST_COL_X);
		maxPressure.setTranslateY(FOURTH_ROW_Y);
		this.getChildren().add(maxPressure);
		
		burnTime = new Text(BURN_TIME_TEXT);
		burnTime.setTranslateX(SECOND_COL_X);
		burnTime.setTranslateY(FOURTH_ROW_Y);
		this.getChildren().add(burnTime);
	}
	
	/**
	 * setSummary(SimulationSummary summary)
	 * 
	 * Purpose: Displays a summary of the simulation.
	 * 
	 * Parameters: 
	 * 		SimmulationSummary summary -- the summary of the simulation to be displayed.
	 * 
	 * Returns: void
	**/
	public void setSummary(SimulationSummary summary)
	{
		classification.setText(CLASSIFICATION_TEXT + summary.getClassification());
		ISP.setText(ISP_TEXT + summary.ISP());
		massFrac.setText(MASS_FRAC_TEXT + summary.getMassFrac());
		impulse.setText(IMPULSE_TEXT + summary.getImpulse());
		averageThrust.setText(AVERAGE_THRUST_TEXT + summary.getaverageThrust());
		maxThrust.setText(MAX_THRUST_TEXT + summary.getMaxThrust());
		maxPressure.setText(MAX_PRESSURE_TEXT + summary.getmaxPressure());
		burnTime.setText(BURN_TIME_TEXT + summary.getBurnTime());
	}

}
