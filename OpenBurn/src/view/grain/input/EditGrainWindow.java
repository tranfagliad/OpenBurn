package view.grain.input;

import controller.GrainTableHandle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.NumberTextField;
import model.grains.CylindricalGrain;
import model.grains.GrainFactory;
import model.grains.GrainType;

/**
 * EditGrainWindow.java
 * 
 * Purpose: Contains all the components for grain editing
 * 		in the OpenBurn graphical user interface.
**/

public class EditGrainWindow extends Stage
{
	// Labels
	private static final String EDIT_GRAIN_TITLE      = "Edit Grain #";
	private static final String LENGTH_PROMPT         = "Length";
	private static final String OUTER_DIAMETER_PROMPT = "Outer Diameter";
	private static final String INNER_DIAMETER_PROMPT = "Inner Diameter";
	private static final String BURNING_ENDS_PROMPT   = "Number of Burning Ends";
	private static final String SUBMIT_BUTTON_TEXT    = "Submit";
	private static final String ERROR_TEXT            = "Inner diameter must be less than outer diameter!";
	private static final String EMPTY                 = "";
	private static final String ICON_FILE_PATH        = "./../../../images/OpenBurnLogo_1.png";
	
	
	
	// Constants
	private static final int WINDOW_WIDTH  = 450;
	private static final int WINDOW_HEIGHT = 270;
	
	
	
	// Components
	private Text lengthText;
	private Text outerDiameterText;
	private Text burningEndsText;
	private Text innerDiameterText;
	private Text errorText;
	private NumberTextField lengthTextField;
	private NumberTextField outerDiameterTextField;
	private ComboBox<String> burningEndsSelection;
	private NumberTextField innerDiameterTextField;
	private Button submitButton;
	
	
	
	// Fields
	private GrainTableHandle tableHandle;
	private int row;
	private BooleanBinding lengthTextFieldNotValid;
	private BooleanBinding outerDiameterTextFieldNotValid;
	private BooleanBinding burningEndsSelectionNotValid;
	private BooleanBinding innerDiameterTextFieldNotValid;
	
	
	
	/**
	 * EditGrainWindow Constructor
	 * 
	 * Purpose: Creates and initializes the grain removing window.
	**/
	
	public EditGrainWindow (GrainTableHandle tableHandle, int row)
	{
		// Invoke Pane super constructor
		super();
		
		// Set fields
		this.tableHandle = tableHandle;
		this.row = row;
		
		// Initialize window
		this.getIcons().add(new Image(this.getClass().getResourceAsStream(ICON_FILE_PATH)));
		this.setTitle(EDIT_GRAIN_TITLE + this.tableHandle.getInputView().getTable().getItems().get(row).getGrainID());
		this.setResizable(false);
		Pane editPane = new Pane();
        Scene editScene = new Scene(editPane, WINDOW_WIDTH, WINDOW_HEIGHT);
        editScene.setRoot(editPane);
        this.setScene(editScene);
		
        // Add components
        addErrorText(editPane);
        addLengthInput(editPane);
        addOuterDiameterInput(editPane);
        addBurningEndsInput(editPane);
		addInnerDiameterInput(editPane);
		addSubmitButton(editPane);
		
		// Cannot click back to main GUI until this window is closed
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(tableHandle.getInputView().getScene().getWindow());
	} // EditGrainWindow Constructor
	
	
	
	/**
	 * addLengthInput()
	 * 
	 * Purpose: Adds the length input on the given Pane.
	 * 
	 * Parameters:
	 * 		Pane frame -- The Pane to add the length input to.
	 * 
	 * Returns: void.
	**/
	
	private void addLengthInput (Pane frame)
	{
		// Length prompt
		lengthText = new Text(LENGTH_PROMPT);
    	lengthText.setTranslateX(25);
    	lengthText.setTranslateY(40);
    	frame.getChildren().add(lengthText);
    	
    	// Length input field
    	lengthTextField = new NumberTextField(tableHandle.getInputView().getTable().getItems().get(row).getLength());
    	lengthTextField.setTranslateX(25);
    	lengthTextField.setTranslateY(50);
		frame.getChildren().add(lengthTextField);
		
		// Set binding rule on length input
		lengthTextFieldNotValid = Bindings.createBooleanBinding(() ->
		{
    	    return lengthTextField.getText().equals(EMPTY);
    	}, lengthTextField.textProperty());
	} // addLengthInput()
	
	
	
	/**
	 * addOuterDiameterInput()
	 * 
	 * Purpose: Adds the outer diameter input on the given Pane.
	 * 
	 * Parameters:
	 * 		Pane frame -- The Pane to add the length input to.
	 * 
	 * Returns: void.
	**/
	
	private void addOuterDiameterInput (Pane frame)
	{
		// Outer Diameter prompt
		outerDiameterText = new Text(OUTER_DIAMETER_PROMPT);
		outerDiameterText.setTranslateX(25);
    	outerDiameterText.setTranslateY(130);
		frame.getChildren().add(outerDiameterText);
		
		// Outer Diameter input field
		outerDiameterTextField = new NumberTextField(tableHandle.getInputView().getTable().getItems().get(row).getOuterDiameter());
		outerDiameterTextField.setTranslateX(25);
    	outerDiameterTextField.setTranslateY(140);
    	frame.getChildren().add(outerDiameterTextField);
		
    	// Set binding rule on outer diameter input
		outerDiameterTextFieldNotValid = Bindings.createBooleanBinding(() ->
		{
    	    return outerDiameterTextField.getText().equals(EMPTY);
    	}, outerDiameterTextField.textProperty());
	} // addOuterDiameterInput()
	
	
	
	/**
	 * addBurningEndsInput()
	 * 
	 * Purpose: Adds the burning ends input on the given Pane.
	 * 
	 * Parameters:
	 * 		Pane frame -- The Pane to add the burning ends input to.
	 * 
	 * Returns: void.
	**/
	
	private void addBurningEndsInput (Pane frame)
	{
		// Burning Ends prompt
		burningEndsText = new Text(BURNING_ENDS_PROMPT);
		burningEndsText.setTranslateX(235);
    	burningEndsText.setTranslateY(40);
		frame.getChildren().add(burningEndsText);
		
		// Burning Ends input field
		ObservableList<String> options = FXCollections.observableArrayList("0", "1", "2");
		burningEndsSelection = new ComboBox<String>(options);
		burningEndsSelection.setValue(String.valueOf(tableHandle.getInputView().getTable().getItems().get(row).getNumBurningEnds()));
		burningEndsSelection.setPrefWidth(185);
		burningEndsSelection.setTranslateX(235);
    	burningEndsSelection.setTranslateY(50);
		frame.getChildren().add(burningEndsSelection);
		
		// Set binding rule on burning ends input
		burningEndsSelectionNotValid = Bindings.createBooleanBinding(() ->
		{
    	    return burningEndsSelection.getValue().equals(EMPTY);
    	}, burningEndsSelection.valueProperty());
	} // addBurningEndsInput()
	
	
	
	/**
	 * addInnerDiameterInput()
	 * 
	 * Purpose: Adds the inner diameter input on the given Pane.
	 * 
	 * Parameters:
	 * 		Pane frame -- The Pane to add the inner diameter input to.
	 * 
	 * Returns: void.
	**/
	
	private void addInnerDiameterInput (Pane frame)
	{
		// Inner Diameter prompt
		innerDiameterText = new Text(INNER_DIAMETER_PROMPT);
		innerDiameterText.setTranslateX(235);
    	innerDiameterText.setTranslateY(130);
		frame.getChildren().add(innerDiameterText);
		
		// Inner Diameter input field
		innerDiameterTextField = new NumberTextField(tableHandle.getInputView().getTable().getItems().get(row).getInnerDiameter());
		innerDiameterTextField.setTranslateX(235);
    	innerDiameterTextField.setTranslateY(140);
		frame.getChildren().add(innerDiameterTextField);
		
		// Set binding rule on inner diameter input
		innerDiameterTextFieldNotValid = Bindings.createBooleanBinding(() ->
		{
    	    return innerDiameterTextField.getText().equals(EMPTY);
    	}, innerDiameterTextField.textProperty());
	} // addInnerDiameterInput()
	
	
	
	/**
	 * addSubmitButton()
	 * 
	 * Purpose: Adds the submit button on the given Pane. Sets the
	 * 		binding rule for when to disable the button.
	 * 
	 * Parameters:
	 * 		Pane frame -- The Pane to add the submit button to.
	 * 
	 * Returns: void.
	**/
	
	private void addSubmitButton (Pane frame)
	{
		// Initialize submit button
		submitButton = new Button(SUBMIT_BUTTON_TEXT);
		submitButton.setTranslateX(155);
    	submitButton.setTranslateY(200);
    	submitButton.setPrefWidth(130);
    	submitButton.setPrefHeight(35);
    	frame.getChildren().add(submitButton);
    	
    	// Add new grain to table on click
    	submitButton.setOnAction(new EventHandler<ActionEvent> ()
		{
		    @Override public void handle (ActionEvent e)
		    {
		    	// Error check that inner diameter is less than outer diameter
		    	if (Double.parseDouble(innerDiameterTextField.getText()) < Double.parseDouble(outerDiameterTextField.getText()))
		    	{
		    		errorText.setText(EMPTY);
		    		
		    		// Gather grain data from input fields
		    		double length = Double.parseDouble(lengthTextField.getText());
		    		double outerDiameter = Double.parseDouble(outerDiameterTextField.getText());
		    		double innerDiameter = Double.parseDouble(innerDiameterTextField.getText());
		    		int numBurningEnds = Integer.parseInt(burningEndsSelection.getValue());
		    		
		    		// Create grain, add it to the table, close the window
			    	tableHandle.editGrainInTable(row, GrainFactory.createGrain(GrainType.Cylindrical, length, outerDiameter, innerDiameter, numBurningEnds));
			    	closeWindow();
		    	}
		    	// Invalid inputs
		    	else
		    		errorText.setText(ERROR_TEXT);
		    }
		});
    	
    	// Set button binding rules
    	submitButton.disableProperty().bind((lengthTextFieldNotValid.or(
    										 outerDiameterTextFieldNotValid).or(
    										 burningEndsSelectionNotValid).or(
    										 innerDiameterTextFieldNotValid)));
	} // addSubmitButton()
	
	
	
	/**
	 * addErrorText()
	 * 
	 * Purpose: Adds the error text to the given Pane.
	 * 
	 * Parameters:
	 * 		Pane frame -- The Pane to add the text to.
	 * 
	 * Returns: void.
	**/
	
	private void addErrorText (Pane frame)
	{
		errorText = new Text();
		errorText.setTranslateX(60);
		errorText.setTranslateY(265);
		frame.getChildren().add(errorText);
	} // addErrorText()
	
	
	
	/**
	 * closeWindow()
	 * 
	 * Purpose: Closes this window.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void closeWindow ()
	{
		this.close();
	} // closeWindow()
	
} // class EditGrainWindow
