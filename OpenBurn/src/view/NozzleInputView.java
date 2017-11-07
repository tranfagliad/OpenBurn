package view;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.NumberTextField;

/**
 * NozzleInputView.java
 * 
 * Purpose: Contains the input fields for a nozzle on the
 * 		OpenBurn graphical user interface.
**/

public class NozzleInputView extends Pane
{
	// Labels
	private static final String THROAT_DIAMETER_PROMPT   = "Throat Diameter";
	private static final String ENTRANCE_DIAMETER_PROMPT = "Entrance Diameter";
	private static final String EXIT_DIAMETER_PROMPT     = "Exit Diameter";
	private static final String CF_PROMPT                = "CF";
	
	
	
	// Constants
	private static final int FIRST_COL_X         = 20;
	private static final int SECOND_COL_X        = 250;
	private static final int FIRST_ROW_PROMPT_Y  = 30;
	private static final int FIRST_ROW_FIELD_Y   = 40;
	private static final int SECOND_ROW_PROMPT_Y = 110;
	private static final int SECOND_ROW_FIELD_Y  = 120;
	
	
	
	// Components
	private Text throatDiameterText;
	private Text entranceDiameterText;
	private Text exitDiameterText;
	private Text cfText;
	private NumberTextField throatDiameterTextField;
	private NumberTextField entranceDiameterTextField;
	private NumberTextField exitDiameterTextField;
	private NumberTextField cfTextField;
	
	
	
	/**
	 * NozzleInputView Constructor
	 * 
	 * Purpose: Creates and initializes the input fields for a nozzle.
	**/
	
	public NozzleInputView ()
	{
		// Invoke Pane super constructor
		super();
		
		// Add components
		addThroatDiameterInput();
		addEntranceDiameterInput();
		addExitDiameterInput();
		addCfInput();
	} // NozzleInputView Constructor
	
	
	
	/**
	 * addEntranceDiameterInput()
	 * 
	 * Purpose: Adds the entrance diameter input field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void addEntranceDiameterInput ()
	{
		// Entrance Diameter prompt
		entranceDiameterText = new Text(ENTRANCE_DIAMETER_PROMPT);
		entranceDiameterText.setTranslateX(FIRST_COL_X);
		entranceDiameterText.setTranslateY(FIRST_ROW_PROMPT_Y);
		this.getChildren().add(entranceDiameterText);
		
		// Entrance Diameter input field
		entranceDiameterTextField = new NumberTextField();
		entranceDiameterTextField.setTranslateX(FIRST_COL_X);
		entranceDiameterTextField.setTranslateY(FIRST_ROW_FIELD_Y);
		this.getChildren().add(entranceDiameterTextField);
	} // addEntranceDiameterInput()
	
	
	
	/**
	 * addExitDiameterInput()
	 * 
	 * Purpose: Adds the exit diameter input field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void addExitDiameterInput ()
	{
		// Exit Diameter prompt
		exitDiameterText = new Text(EXIT_DIAMETER_PROMPT);
		exitDiameterText.setTranslateX(SECOND_COL_X);
		exitDiameterText.setTranslateY(FIRST_ROW_PROMPT_Y);
		this.getChildren().add(exitDiameterText);
		
		// Exit Diameter input field
		exitDiameterTextField = new NumberTextField();
		exitDiameterTextField.setTranslateX(SECOND_COL_X);
		exitDiameterTextField.setTranslateY(FIRST_ROW_FIELD_Y);
		this.getChildren().add(exitDiameterTextField);
	} // addExitDiameterInput()
	
	
	
	/**
	 * addThroatDiameterInput()
	 * 
	 * Purpose: Adds the throat diameter input field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void addThroatDiameterInput ()
	{
		// Throat Diameter prompt
		throatDiameterText = new Text(THROAT_DIAMETER_PROMPT);
		throatDiameterText.setTranslateX(FIRST_COL_X);
		throatDiameterText.setTranslateY(SECOND_ROW_PROMPT_Y);
		this.getChildren().add(throatDiameterText);
		
		// Throat Diameter input field
		throatDiameterTextField = new NumberTextField();
		throatDiameterTextField.setTranslateX(FIRST_COL_X);
		throatDiameterTextField.setTranslateY(SECOND_ROW_FIELD_Y);
		this.getChildren().add(throatDiameterTextField);
	} // addThroatDiameterInput()
	
	
	
	/**
	 * addCfInput()
	 * 
	 * Purpose: Adds the Cf input field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void addCfInput ()
	{
		// Cf prompt
		cfText = new Text(CF_PROMPT);
		cfText.setTranslateX(SECOND_COL_X);
		cfText.setTranslateY(SECOND_ROW_PROMPT_Y);
		this.getChildren().add(cfText);
		
		// Cf input field
		cfTextField = new NumberTextField();
		cfTextField.setTranslateX(SECOND_COL_X);
		cfTextField.setTranslateY(SECOND_ROW_FIELD_Y);
		this.getChildren().add(cfTextField);
	} // addCfInput()
	
	
	
	/**
	 * getEntranceDiameterInput()
	 * 
	 * Purpose: Returns the value currently in the entrance diameter field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The value currently in the entrance diameter field.
	**/
	
	public double getEntranceDiameterInput ()
	{
		return Double.parseDouble(entranceDiameterTextField.getText().toString());
	} // getEntranceDiameterInput()
	
	
	
	/**
	 * getExitDiameterInput()
	 * 
	 * Purpose: Returns the value currently in the exit diameter field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The value currently in the exit diameter field.
	**/
	
	public double getExitDiameterInput ()
	{
		return Double.parseDouble(exitDiameterTextField.getText().toString());
	} // getExitDiameterInput()
	
	
	
	/**
	 * getThroatDiameterInput()
	 * 
	 * Purpose: Returns the value currently in the throat diameter field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The value currently in the throat diameter field.
	**/
	
	public double getThroatDiameterInput ()
	{
		return Double.parseDouble(throatDiameterTextField.getText().toString());
	} // getThroatDiameterInput()
	
	
	
	/**
	 * getCfInput()
	 * 
	 * Purpose: Returns the value currently in the Cf field.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The value currently in the Cf field.
	**/
	
	public double getCfInput ()
	{
		return Double.parseDouble(cfTextField.getText().toString());
	} // getCfInput()
	
} // class NozzleInputView
