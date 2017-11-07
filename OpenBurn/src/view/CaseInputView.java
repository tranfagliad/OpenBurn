package view;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.NumberTextField;

/**
 * CaseInputView.java
 * 
 * Purpose: Contains the input fields for a case on the
 * 		OpenBurn graphical user interface.
**/

public class CaseInputView extends Pane
{
	// Labels
	private static final String CASE_MASS_PROMPT     = "Mass";
	private static final String CASE_DIAMETER_PROMPT = "Diameter";
	private static final String CASE_LENGTH_PROMPT   = "Length";
	
	
	
	// Constants
	private static final int FIRST_COL_X         = 20;
	private static final int SECOND_COL_X        = 250;
	private static final int FIRST_ROW_PROMPT_Y  = 30;
	private static final int FIRST_ROW_FIELD_Y   = 40;
	private static final int SECOND_ROW_PROMPT_Y = 110;
	private static final int SECOND_ROW_FIELD_Y  = 120;
	
	
	
	// Components
	private Text massText;
	private Text diameterText;
	private Text lengthText;
	private NumberTextField massTextField;
	private NumberTextField diameterTextField;
	private NumberTextField lengthTextField;
	
	
	
	/**
	 * CaseInputView Constructor
	 * 
	 * Purpose: Creates and initializes the input fields for a case.
	**/
	
	public CaseInputView ()
	{
		// Invoke Pane super constructor
		super();
		
		// Add components
		addMassInput();
		addDiameterInput();
		addLengthInput();
	} // CaseInputView Constructor
	
	
	
	/**
	 * addMassInput()
	 * 
	 * Purpose: Adds the mass input field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void addMassInput ()
	{
		// Mass prompt
		massText = new Text(CASE_MASS_PROMPT);
		massText.setTranslateX(FIRST_COL_X);
		massText.setTranslateY(FIRST_ROW_PROMPT_Y);
		this.getChildren().add(massText);
		
		// Mass input field
		massTextField = new NumberTextField();
		massTextField.setTranslateX(FIRST_COL_X);
		massTextField.setTranslateY(FIRST_ROW_FIELD_Y);
		this.getChildren().add(massTextField);
	} // addMassInput()
	
	
	
	/**
	 * addDiameterInput()
	 * 
	 * Purpose: Adds the diameter input field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void addDiameterInput ()
	{
		// Diameter prompt
		diameterText = new Text(CASE_DIAMETER_PROMPT);
		diameterText.setTranslateX(FIRST_COL_X);
		diameterText.setTranslateY(SECOND_ROW_PROMPT_Y);
		this.getChildren().add(diameterText);
		
		// Diameter input field
		diameterTextField = new NumberTextField();
		diameterTextField.setTranslateX(FIRST_COL_X);
		diameterTextField.setTranslateY(SECOND_ROW_FIELD_Y);
		this.getChildren().add(diameterTextField);
	} // addDiameterInput()
	
	
	
	/**
	 * addLengthInput()
	 * 
	 * Purpose: Adds the length input field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void addLengthInput ()
	{
		// Length prompt
		lengthText = new Text(CASE_LENGTH_PROMPT);
		lengthText.setTranslateX(SECOND_COL_X);
		lengthText.setTranslateY(FIRST_ROW_PROMPT_Y);
		this.getChildren().add(lengthText);
		
		// Length input field
		lengthTextField = new NumberTextField();
		lengthTextField.setTranslateX(SECOND_COL_X);
		lengthTextField.setTranslateY(FIRST_ROW_FIELD_Y);
		this.getChildren().add(lengthTextField);
	} // addLengthInput()
	
	
	
	/**
	 * getMassInput()
	 * 
	 * Purpose: Returns the value currently in the mass field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The value currently in the mass field.
	**/
	
	public double getMassInput ()
	{
		return Double.parseDouble(massTextField.getText().toString());
	} // getMassInput()
	
	
	
	/**
	 * getDiameterInput()
	 * 
	 * Purpose: Returns the value currently in the diameter field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The value currently in the diameter field.
	**/
	
	public double getDiameterInput ()
	{
		return Double.parseDouble(diameterTextField.getText().toString());
	} // getDiameterInput()
	
	
	
	/**
	 * getLengthInput()
	 * 
	 * Purpose: Returns the value currently in the length field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The value currently in the length field.
	**/
	
	public double getLengthInput ()
	{
		return Double.parseDouble(lengthTextField.getText().toString());
	} // getLengthInput()
	
} // class CaseInputView
