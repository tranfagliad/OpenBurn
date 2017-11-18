package controller;

import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import model.unitConversion.MassUnits;
import model.unitConversion.UnitConverter;

/*
 * 
 */

public class MassUnitsSelector extends ComboBox<String>
{
	//
	private MassUnits units;
	private NumberTextField valueField;
	
	
	
	/*
	 * 
	 */
	
	public MassUnitsSelector (NumberTextField valueField)
	{
		//
		super();
		
		this.valueField = valueField;
		
		//
		for (MassUnits units : MassUnits.values())
			this.getItems().add(units.getAbbr());
		
		// Initialize the 
		this.getSelectionModel().selectFirst();
		units = MassUnits.POUNDS_MASS;
		
		this.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) ->
		{
			if (!this.valueField.getText().equals(""))
			{
				MassUnits oldUnits = units;
				this.setUnits(newValue);
				MassUnits newUnits = units;
				
				System.out.println(newValue);
				//this.valueField.setText(String.valueOf(UnitConverter.unitLengthConverter(Double.parseDouble(this.valueField.getText()), oldUnits, newUnits)));
			}
			this.setUnits(newValue);
	    }); 
	} // 
	
	
	
	/*
	 * 
	 */
	
	private void setUnits (String newValue)
	{
		if (newValue.equals(MassUnits.GRAMS.getAbbr()))
			units = MassUnits.GRAMS;
		else if (newValue.equals(MassUnits.KILOGRAMS.getAbbr()))
			units = MassUnits.KILOGRAMS;
		else if (newValue.equals(MassUnits.POUNDS_MASS.getAbbr()))
			units = MassUnits.POUNDS_MASS;
	} // 
	
} // 
