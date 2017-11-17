package controller;

import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import model.unitConversion.DensityUnits;
import model.unitConversion.LengthUnits;
import model.unitConversion.UnitConverter;

/*
 * 
 */

public class DensityUnitsSelector extends ComboBox<String>
{
	//
	private DensityUnits units;
	private NumberTextField valueField;
	
	
	
	/*
	 * 
	 */
	
	public DensityUnitsSelector (NumberTextField valueField)
	{
		//
		super();
		
		this.valueField = valueField;
		
		//
		for (DensityUnits units : DensityUnits.values())
			this.getItems().add(units.getAbbr());
		
		// Initialize the 
		this.getSelectionModel().selectFirst();
		units = DensityUnits.GRAMS_PER_CUBIC_CENTIMETER;
		
		this.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) ->
		{
			if (!this.valueField.getText().equals(""))
			{
				DensityUnits oldUnits = units;
				this.setUnits(newValue);
				DensityUnits newUnits = units;
				
				this.valueField.setText(String.valueOf(UnitConverter.convertDensityToInternal(Double.parseDouble(valueField.getText()),units)));
			}
			this.setUnits(newValue);
	    }); 
	} // 
	
	
	
	/*
	 * 
	 */
	
	private void setUnits (String newValue)
	{
		if (newValue.equals(DensityUnits.GRAMS_PER_CUBIC_CENTIMETER.getAbbr()))
			units = DensityUnits.GRAMS_PER_CUBIC_CENTIMETER;
		else if (newValue.equals(DensityUnits.GRAMS_PER_CUBIC_INCH.getAbbr()))
			units = DensityUnits.GRAMS_PER_CUBIC_INCH;
		else if (newValue.equals(DensityUnits.KILOGRAMS_PER_CUBIC_METER.getAbbr()))
			units = DensityUnits.KILOGRAMS_PER_CUBIC_METER;
		else if (newValue.equals(DensityUnits.POUNDS_MASS_PER_CUBIC_FOOT.getAbbr()))
			units = DensityUnits.POUNDS_MASS_PER_CUBIC_FOOT;
		else if (newValue.equals(DensityUnits.POUNDS_MASS_PER_CUBIC_INCH.getAbbr()))
			units = DensityUnits.POUNDS_MASS_PER_CUBIC_INCH;
	} // 
	
} // 
