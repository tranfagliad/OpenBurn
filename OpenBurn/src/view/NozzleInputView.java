package view;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * NozzleInputView.java
 * 
 * Purpose: Contains the input fields for a nozzle on the
 * 		OpenBurn graphical user interface.
**/

public class NozzleInputView extends Pane
{
	// Labels
	private static final String THROAT_DIAMETER_PROMPT   = "Enter nozzle throat diameter";
	private static final String ENTRANCE_DIAMETER_PROMPT = "Enter nozzle entrance diameter";
	private static final String EXIT_DIAMETER_PROMPT     = "Enter nozzle exit diameter";
	private static final String CF_PROMPT                = "Enter nozzle CF";
	
	
	
	// Components
	private Text throatDiameterText;
	private TextField throatDiameterTextField;
	private Text entranceDiameterText;
	private TextField entranceDiameterTextField;
	private Text exitDiameterText;
	private TextField exitDiameterTextField;
	private Text cfText;
	private TextField cfTextField;
	
	
	
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
		throatDiameterText.setTranslateX(20);
		throatDiameterText.setTranslateY(20);
		this.getChildren().add(throatDiameterText);
		
		// Throat Diameter input field
		throatDiameterTextField = new TextField();
		throatDiameterTextField.setTranslateX(20);
		throatDiameterTextField.setTranslateY(30);
		this.getChildren().add(throatDiameterTextField);
	} // addThroatDiameterInput()
	
	
	
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
		entranceDiameterText.setTranslateX(20);
		entranceDiameterText.setTranslateY(100);
		this.getChildren().add(entranceDiameterText);
		
		// Entrance Diameter input field
		entranceDiameterTextField = new TextField();
		entranceDiameterTextField.setTranslateX(20);
		entranceDiameterTextField.setTranslateY(110);
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
		exitDiameterText.setTranslateX(20);
		exitDiameterText.setTranslateY(180);
		this.getChildren().add(exitDiameterText);
		
		// Exit Diameter input field
		exitDiameterTextField = new TextField();
		exitDiameterTextField.setTranslateX(20);
		exitDiameterTextField.setTranslateY(190);
		this.getChildren().add(exitDiameterTextField);
	} // addExitDiameterInput()
	
	
	
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
		cfText.setTranslateX(20);
		cfText.setTranslateY(260);
		this.getChildren().add(cfText);
		
		// Cf input field
		cfTextField = new TextField();
		cfTextField.setTranslateX(20);
		cfTextField.setTranslateY(270);
		this.getChildren().add(cfTextField);
	} // addCfInput()
	
	
	
	/**
	 * 
	**/
	
	public double getThroatDiameterInput ()
	{
		return Double.parseDouble(throatDiameterTextField.getText().toString());
	}
	
	
	/**
	 * 
	**/
	
	public double getEntranceDiameterInput ()
	{
		return Double.parseDouble(entranceDiameterTextField.getText().toString());
	}
	
	
	
	/**
	 * 
	**/
	
	public double getExitDiameterInput ()
	{
		return Double.parseDouble(exitDiameterTextField.getText().toString());
	}
	
	
	
	/**
	 * 
	**/
	
	public double getCfInput ()
	{
		return Double.parseDouble(cfTextField.getText().toString());
	}
	
} // class NozzleInputView
