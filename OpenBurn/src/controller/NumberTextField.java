package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * NumberTextField.java
 * 
 * Purpose: Represents a text field that only allows digits and
 * 		a single decimal point.
**/

public class NumberTextField extends TextField
{
	/**
	 * NumberTextField Constructor
	 * 
	 * Purpose: Creates and initializes a NumberTextField with no text.
	**/
	
	public NumberTextField ()
	{
		super();
		
		this.textProperty().addListener(new ChangeListener<String>()
		{
			@Override
			public void changed (ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				if (!strIsNumeric(newValue) || numOccurrences(newValue, '.') == 2)
					setText(oldValue);
			}
		});
	} // NumberTextField Constructor
	
	
	
	/**
	 * NumberTextField Constructor (double)
	 * 
	 * Purpose: Creates and initializes a NumberTextField with the
	 * 		initial text set to the given value.
	**/
	
	public NumberTextField (double value)
	{
		this();
		setText(String.valueOf(value));
	} // NumberTextField Constructor (double)
	
	
	
	/**
	 * getValue()
	 * 
	 * Purpose: Returns the numeric value of the text.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The numeric value of the text.
	**/
	
	public double getValue ()
	{
		return Double.parseDouble(getText());
	} // getValue()
	
	
	
	/**
	 * setValue()
	 * 
	 * Purpose: Sets the text to the string equivalent of the
	 * 		given double value.
	 * 
	 * Parameters:
	 * 		double newValue -- New value to set the text.
	 * 
	 * Returns: void.
	**/
	
	public void setValue (double newValue)
    {
        this.setText(String.valueOf(newValue));
    } // setValue()
	
	
	
	/**
	 * strIsNumeric()
	 * 
	 * Purpose: Checks the contents of the given string to see
	 * 		if the string only contains numeric characters and
	 * 		decimal points.
	 * 
	 * Parameters:
	 * 		String s -- The string to check.
	 * 
	 * Returns: boolean. True if the entire string only contains
	 * 		numberic characters or decimal points.
	**/
	
	private boolean strIsNumeric (String s)
    {
		int charCode;
        for (int i = 0; i < s.length(); i++)
        {
        	charCode = (int)(s.charAt(i));
        	if (!((charCode < 58 && charCode > 47) || charCode == 46))
        		return false;
        }
		
        return true;
    } // strIsNumeric()
	
	
	
	/**
	 * numOccurrences()
	 * 
	 * Purpose: Checks the contents of the given string for the
	 * 		given character and counts the number of times the
	 * 		character is found. The total is returned.
	 * 
	 * Parameters:
	 * 		String s -- The string to check.
	 * 		char c -- The character to find in the string.
	 * 
	 * Returns: int. The number of occurrences of the character
	 * 		in the string.
	**/
	
	private int numOccurrences (String s, char c)
    {
        int numOccurrences = 0;
        for (int i = 0; i < s.length(); i++)
        	if (s.charAt(i) == c)
        		numOccurrences++;
        return numOccurrences;
    } // numOccurrences()
	
} // class NumberTextField
