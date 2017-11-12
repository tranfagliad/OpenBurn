package view;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.NumberTextField;


/**
 * PropellantInputView.java
 * 
 * Purpose: Contains the input fields for a propellant on the
 * 		OpenBurn graphical user interface.
**/


public class PropellantInputView extends Pane
{
	// Labels
	private static final String BURN_RATE_COEFFICIENT_PROMPT    = "Enter Burn Rate Coefficient";
	private static final String BURN_RATE_EXPONENT_PROMPT    = "Enter Burn Rate Exponent";
	private static final String DENSITY_PROMPT    = "Enter Propellant density";
	private static final String C_STAR_PROMPT    = "Enter C Star";
	
	// Constants
	private static final int FIRST_COL_X         = 20;
	private static final int SECOND_COL_X        = 250;
	private static final int FIRST_ROW_PROMPT_Y  = 30;
	private static final int FIRST_ROW_FIELD_Y   = 40;
	private static final int SECOND_ROW_PROMPT_Y = 110;
	private static final int SECOND_ROW_FIELD_Y  = 120;
	
	// Components
	private Text burnRateCoefficientText;
	private Text burnRateExponentText;
	private Text propDensityText;
	private Text cStarText;
	private NumberTextField burnRateCoefficientTextField;
	private NumberTextField burnRateExponentTextField;
	private NumberTextField propDensityTextField;
	private NumberTextField cStarTextField;
	
	
	/**
	 * NPropellantInputView Constructor
	 * 
	 * Purpose: Creates and initializes the input fields for propellant.
	**/
	public PropellantInputView()
	{
		// Invoke Pane super constructor
		super();
		
		// Add components
		addBurnRateCoefficientInput();
		addBurnRateExponentInput();
		addPropellantDensityInput();
		addCstarInput();
	}//PropellantInputView()
	
	private void addBurnRateCoefficientInput()
	{
		// Burn Rate Coefficient prompt
		burnRateCoefficientText = new Text(BURN_RATE_COEFFICIENT_PROMPT);
		burnRateCoefficientText.setTranslateX(FIRST_COL_X);
		burnRateCoefficientText.setTranslateY(FIRST_ROW_PROMPT_Y);
		this.getChildren().add(burnRateCoefficientText);
		
		// Burn Rate Coefficient input field
		burnRateCoefficientTextField = new NumberTextField();
		burnRateCoefficientTextField.setTranslateX(FIRST_COL_X);
		burnRateCoefficientTextField.setTranslateY(FIRST_ROW_FIELD_Y);
		this.getChildren().add(burnRateCoefficientTextField);
	}//addBurnRateCoefficientInput()
	
	private void addBurnRateExponentInput()
	{
		// Burn Rate Exponent prompt
		burnRateExponentText = new Text(BURN_RATE_EXPONENT_PROMPT);
		burnRateExponentText.setTranslateX(SECOND_COL_X);
		burnRateExponentText.setTranslateY(FIRST_ROW_PROMPT_Y);
		this.getChildren().add(burnRateExponentText);
		
		// Burn Rate Exponent input field
		burnRateExponentTextField = new NumberTextField();
		burnRateExponentTextField.setTranslateX(SECOND_COL_X);
		burnRateExponentTextField.setTranslateY(FIRST_ROW_FIELD_Y);
		this.getChildren().add(burnRateExponentTextField);
	}//addBurnRateExponentInput()

	private void addPropellantDensityInput()
	{
		// Propellant Density prompt
		propDensityText = new Text(DENSITY_PROMPT);
		propDensityText.setTranslateX(FIRST_COL_X);
		propDensityText.setTranslateY(SECOND_ROW_PROMPT_Y);
		this.getChildren().add(propDensityText);
		
		// Propellant Density input field
		propDensityTextField = new NumberTextField();
		propDensityTextField.setTranslateX(FIRST_COL_X);
		propDensityTextField.setTranslateY(SECOND_ROW_FIELD_Y);
		this.getChildren().add(propDensityTextField);
	}//addPropellantDensityInput()
	
	private void addCstarInput()
	{
		// C Star prompt
		cStarText = new Text(C_STAR_PROMPT);
		cStarText.setTranslateX(SECOND_COL_X);
		cStarText.setTranslateY(SECOND_ROW_PROMPT_Y);
		this.getChildren().add(cStarText);
		
		// C Star input field
		cStarTextField = new NumberTextField();
		cStarTextField.setTranslateX(SECOND_COL_X);
		cStarTextField.setTranslateY(SECOND_ROW_FIELD_Y);
		this.getChildren().add(cStarTextField);
	}//addCstarInput()
	
	/**
	 * getBurnRateCoefficientInput()
	 * 
	 * Purpose: Returns the value currently in the Burn Rate Coefficient field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The value currently in the Burn Rate Coefficient field.
	**/
	
	public double getBurnRateCoefficientInput ()
	{
		return Double.parseDouble(burnRateCoefficientTextField.getText().toString());
	}//getBurnRateCoefficientInput ()
	
	/**
	 * getBurnRateExponentInput()
	 * 
	 * Purpose: Returns the value currently in the Burn Rate Exponent field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The value currently in the Burn Rate Exponent field.
	**/
	
	public double getBurnRateExponentInput ()
	{
		return Double.parseDouble(burnRateExponentTextField.getText().toString());
	}//getBurnRateExponentInput ()
	
	/**
	 * getPropellantDensityInput()
	 * 
	 * Purpose: Returns the value currently in the Propellant Density field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The value currently in the Propellant Density field.
	**/
	
	public double getPropellantDensityInput ()
	{
		return Double.parseDouble(propDensityTextField.getText().toString());
	}//getPropellantDensityInput ()
	
	/**
	 * getCstarInput()
	 * 
	 * Purpose: Returns the value currently in the C Star field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The value currently in the C Star field.
	**/
	
	public double getCstarInput ()
	{
		return Double.parseDouble(cStarTextField.getText().toString());
	}//getCstarInput ()
	
}//PropellantInputView
