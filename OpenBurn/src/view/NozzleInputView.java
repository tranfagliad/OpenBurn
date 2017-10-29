package view;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * 
**/

public class NozzleInputView extends Pane
{
	// GUI Labels
	private static final String THROAT_DIAMETER_PROMPT   = "Enter nozzle throat diameter";
	private static final String ENTRANCE_DIAMETER_PROMPT = "Enter nozzle entrance diameter";
	private static final String EXIT_DIAMETER_PROMPT     = "Enter nozzle exit diameter";
	private static final String CF_PROMPT                = "Enter nozzle CF";
	
	
	
	// GUI Components
	private Text throatDiameterText;
	private TextField throatDiameterTextField;
	private Text entranceDiameterText;
	private TextField entranceDiameterTextField;
	private Text exitDiameterText;
	private TextField exitDiameterTextField;
	private Text cfText;
	private TextField cfTextField;
	
	
	
	public NozzleInputView ()
	{
		super();
		
		throatDiameterText = new Text(THROAT_DIAMETER_PROMPT);
		throatDiameterText.setTranslateX(20);
		throatDiameterText.setTranslateY(20);
		this.getChildren().add(throatDiameterText);
		
		throatDiameterTextField = new TextField();
		throatDiameterTextField.setTranslateX(20);
		throatDiameterTextField.setTranslateY(30);
		this.getChildren().add(throatDiameterTextField);
		
		
		entranceDiameterText = new Text(ENTRANCE_DIAMETER_PROMPT);
		entranceDiameterText.setTranslateX(20);
		entranceDiameterText.setTranslateY(100);
		this.getChildren().add(entranceDiameterText);
		
		entranceDiameterTextField = new TextField();
		entranceDiameterTextField.setTranslateX(20);
		entranceDiameterTextField.setTranslateY(110);
		this.getChildren().add(entranceDiameterTextField);
		
		
		exitDiameterText = new Text(EXIT_DIAMETER_PROMPT);
		exitDiameterText.setTranslateX(20);
		exitDiameterText.setTranslateY(180);
		this.getChildren().add(exitDiameterText);
		
		exitDiameterTextField = new TextField();
		exitDiameterTextField.setTranslateX(20);
		exitDiameterTextField.setTranslateY(190);
		this.getChildren().add(exitDiameterTextField);
		
		
		cfText = new Text(CF_PROMPT);
		cfText.setTranslateX(20);
		cfText.setTranslateY(260);
		this.getChildren().add(cfText);
		
		cfTextField = new TextField();
		cfTextField.setTranslateX(20);
		cfTextField.setTranslateY(270);
		this.getChildren().add(cfTextField);
	}
	
	
	
	
	
}
