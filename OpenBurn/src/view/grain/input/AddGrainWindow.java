package view.grain.input;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
**/

public class AddGrainWindow extends Stage
{
	// Labels
	private static final String ADD_GRAIN_TITLE       = "Add a Grain";
	
	private static final String LENGTH_PROMPT         = "Enter Length";
	private static final String OUTER_DIAMETER_PROMPT = "Enter Outer Diameter";
	private static final String INNER_DIAMETER_PROMPT = "Enter Inner Diameter";
	private static final String BURNING_ENDS_PROMPT   = "Enter Number of Burning Ends";
	
	private static final String SUBMIT_BUTTON_TEXT = "Submit";
	
	private static final String EMPTY = "";
	
	
	
	// Constants
	private static final int WINDOW_WIDTH  = 450;
	private static final int WINDOW_HEIGHT = 270;
	
	
	
	// GUI Components
	private Text lengthText;
	private Text outerDiameterText;
	private Text burningEndsText;
	private Text innerDiameterText;
	
	private TextField lengthTextField;
	private TextField outerDiameterTextField;
	private TextField burningEndsTextField;
	private TextField innerDiameterTextField;
	
	private Button submitButton;
	
	
	
	public AddGrainWindow ()
	{
		super();
		
		this.getIcons().add(new Image(this.getClass().getResourceAsStream("./../../../images/OpenBurnLogo_1.png")));
		
		this.setTitle(ADD_GRAIN_TITLE);
		this.setResizable(false);
		
		Pane addPane = new Pane();
        Scene addScene = new Scene(addPane, WINDOW_WIDTH, WINDOW_HEIGHT);
        addScene.setRoot(addPane);
        
        this.setScene(addScene);
        
        lengthText = new Text(LENGTH_PROMPT);
    	lengthText.setTranslateX(25);
    	lengthText.setTranslateY(40);
    	addPane.getChildren().add(lengthText);
    	
    	lengthTextField = new TextField();
    	lengthTextField.setTranslateX(25);
    	lengthTextField.setTranslateY(50);
		addPane.getChildren().add(lengthTextField);
		
		BooleanBinding lengthTextFieldValid = Bindings.createBooleanBinding(() -> {
    	    if (lengthTextField.getText().equals(EMPTY))
    	    	return true;
    	    else
    	    	return false;
    	}, lengthTextField.textProperty());
		
		
		
		
		outerDiameterText = new Text(OUTER_DIAMETER_PROMPT);
		outerDiameterText.setTranslateX(25);
    	outerDiameterText.setTranslateY(130);
		addPane.getChildren().add(outerDiameterText);
		
		outerDiameterTextField = new TextField();
		outerDiameterTextField.setTranslateX(25);
    	outerDiameterTextField.setTranslateY(140);
		addPane.getChildren().add(outerDiameterTextField);
		
		BooleanBinding outerDiameterTextFieldValid = Bindings.createBooleanBinding(() -> {
    	    if (outerDiameterTextField.getText().equals(EMPTY))
    	    	return true;
    	    else
    	    	return false;
    	}, outerDiameterTextField.textProperty());
		
		
		
		
		
		burningEndsText = new Text(BURNING_ENDS_PROMPT);
		burningEndsText.setTranslateX(235);
    	burningEndsText.setTranslateY(40);
		addPane.getChildren().add(burningEndsText);
		
		burningEndsTextField = new TextField();
		burningEndsTextField.setTranslateX(235);
    	burningEndsTextField.setTranslateY(50);
		addPane.getChildren().add(burningEndsTextField);
		
		BooleanBinding burningEndsTextFieldValid = Bindings.createBooleanBinding(() -> {
    	    if (burningEndsTextField.getText().equals(EMPTY))
    	    	return true;
    	    else
    	    	return false;
    	}, burningEndsTextField.textProperty());
		
		
		
		
		
		
		innerDiameterText = new Text(INNER_DIAMETER_PROMPT);
		innerDiameterText.setTranslateX(235);
    	innerDiameterText.setTranslateY(130);
		addPane.getChildren().add(innerDiameterText);
		
		innerDiameterTextField = new TextField();
		innerDiameterTextField.setTranslateX(235);
    	innerDiameterTextField.setTranslateY(140);
		addPane.getChildren().add(innerDiameterTextField);
		
		BooleanBinding innerDiameterTextFieldValid = Bindings.createBooleanBinding(() -> {
    	    if (innerDiameterTextField.getText().equals(EMPTY))
    	    	return true;
    	    else
    	    	return false;
    	}, innerDiameterTextField.textProperty());
		
		
		
		
		
		
		submitButton = new Button(SUBMIT_BUTTON_TEXT);
		submitButton.setTranslateX(155);
    	submitButton.setTranslateY(200);
    	submitButton.setPrefWidth(130);
    	submitButton.setPrefHeight(35);
    	addPane.getChildren().add(submitButton);
    	
    	submitButton.disableProperty().bind((lengthTextFieldValid.or(outerDiameterTextFieldValid).or(burningEndsTextFieldValid).or(innerDiameterTextFieldValid)));
    	
		
	}
	
	
	
	
}