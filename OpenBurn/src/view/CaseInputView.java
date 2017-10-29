package view;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * 
**/

public class CaseInputView extends Pane
{
	// Labels
	private static final String CASE_MASS_PROMPT     = "Enter mass of the case";
	private static final String CASE_DIAMETER_PROMPT = "Enter diameter of the case";
	private static final String CASE_LENGTH_PROMPT   = "Enter length of the case";
	
	
	
	// Components
	private Text massText;
	private TextField massTextField;
	private Text diameterText;
	private TextField diameterTextField;
	private Text lengthText;
	private TextField lengthTextField;
	
	
	
	public CaseInputView ()
	{
		super();
		
		massText = new Text(CASE_MASS_PROMPT);
		massText.setTranslateX(20);
		massText.setTranslateY(20);
		this.getChildren().add(massText);
		
		massTextField = new TextField();
		massTextField.setTranslateX(20);
		massTextField.setTranslateY(30);
		this.getChildren().add(massTextField);
		
		
		diameterText = new Text(CASE_DIAMETER_PROMPT);
		diameterText.setTranslateX(20);
		diameterText.setTranslateY(100);
		this.getChildren().add(diameterText);
		
		diameterTextField = new TextField();
		diameterTextField.setTranslateX(20);
		diameterTextField.setTranslateY(110);
		this.getChildren().add(diameterTextField);
		
		
		lengthText = new Text(CASE_LENGTH_PROMPT);
		lengthText.setTranslateX(20);
		lengthText.setTranslateY(180);
		this.getChildren().add(lengthText);
		
		lengthTextField = new TextField();
		lengthTextField.setTranslateX(20);
		lengthTextField.setTranslateY(190);
		this.getChildren().add(lengthTextField);
		
	}
	
	
	
	
}
