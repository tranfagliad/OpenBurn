package controller;

import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import model.unitConversion.LengthUnits;

/*
 * 
 */

public class LengthUnitsSelector extends ComboBox<String>
{
	//
	private LengthUnits units;
	
	
	
	/*
	 * 
	 */
	
	public LengthUnitsSelector ()
	{
		//
		super();
		
		//
		for (LengthUnits units : LengthUnits.values())
			this.getItems().add(units.getAbbr());
		
		// Initialize the 
		this.getSelectionModel().selectFirst();
		units = LengthUnits.INCHES;
		
		this.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) ->
		{
			
	    }); 
	} // 
	
	
	
	/*
	 * 
	 */
	
	public void setUnits (LengthUnits newUnits)
	{
		units = newUnits;
	}
	
} // 
