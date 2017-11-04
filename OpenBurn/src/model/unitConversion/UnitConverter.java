package model.unitConversion;

/**
 * UnitConverter.java
 * 
 * Purpose: Contains static methods that are used to convert between
 * 		Imperial and Metric units. This will allow the user to use
 * 		the application in any measurement system.
 */

public class UnitConverter
{
	/**
	 * convertLengthToInternal()
	 * 
	 * Purpose: Converts and returns length from one of several external units to internal units.
	 * 
	 * Parameters:
	 * 		double input -- Length in inches, feet, centimeters or millimeters.
	 * 		LengthUnits units -- what unit the input is in
	 * 
	 * Returns: double. Length in the units used by rest of model (inches)
	**/
	
	public static double convertLengthToInternal (double input, LengthUnits units)
	{
		if(units == LengthUnits.INCHES)
		{
			return input;
		}
		else if(units == LengthUnits.CENTIMETERS)
		{
			return (input / 2.54);
		}
		else if(units == LengthUnits.MILLIMETERS)
		{
			input *= 10;
			return (input / 2.54);
		}
		else //if(units == LengthUnits.FEET)  compiler complains about last if statement because it thinks program could get past all if statements
		{
			return (input * 12);
		}
	} // convertLengthMtoI()
	
	
	
	/**
	 * convertLengthfromInternal()
	 * 
	 * Purpose: Converts and returns length from internal units to one of several external units.
	 * 
	 * Parameters:
	 * 		double input -- Length in the units used by rest of model (inches)
	 * 		LengthUnits units -- what unit the output is desired in
	 * 
	 * Returns: double. Length in inches, feet, centimeters or millimeters.
	**/
	
	public static double convertLengthfromInternal (double input, LengthUnits units)
	{
		if(units == LengthUnits.INCHES)
		{
			return input;
		}
		else if(units == LengthUnits.CENTIMETERS)
		{
			return (input * 2.54);
		}
		else if(units == LengthUnits.MILLIMETERS)
		{
			input /= 10;
			return (input * 2.54);
		}
		else //if(units == LengthUnits.FEET)  compiler complains about last if statement because it thinks program could get past all if statements
		{
			return (input / 12);
		}
	} // convertLengthItoM()
	
	
	
	/**
	 * convertMassToInternal()
	 * 
	 * Purpose: Converts and returns mass from one of several external units to internal units.
	 * 
	 * Parameters:
	 * 		double input -- Mass in pounds, grams, or kilograms.
	 * 		MassUnits units -- what unit the input is in
	 * 
	 * Returns: double. Mass in the units used by rest of model (pounds mass)
	**/
	
	public static double convertMassToInternal (double input, MassUnits units)
	{
		if(units == MassUnits.POUNDS_MASS)
		{
			return input;
		}
		if(units == MassUnits.KILOGRAMS)
		{
			input *= 1000;
		}
		return (input * 0.00220462);		
	} // convertMassMtoI()
	
	
	
	/**
	 * convertMassFromInternal()
	 * 
	 * Purpose: Converts and returns mass from internal units to one of several external units.
	 * 
	 * Parameters:
	 * 		double input -- Mass in the units used by rest of model (pounds mass)
	 * 		MassUnits units -- what unit the output is desired in
	 * 
	 * Returns: double. Mass in pounds, grams, or kilograms.
	**/
	
	public static double convertMassFromInternal (double input, MassUnits units)
	{
		if(units == MassUnits.POUNDS_MASS)
		{
			return input;
		}
		if(units == MassUnits.KILOGRAMS)
		{
			input /= 1000;
		}
		return (input / 0.00220462);		
	} // convertMassItoM()
	
	
	
	/**
	 * convertForcetoInternal()
	 * 
	 * Purpose: Converts and returns force from one of several external units to internal units.
	 * 
	 * Parameters:
	 * 		double input -- Force in pounds, or newtons.
	 * 		ForceUnits units -- what unit the input is in
	 * 
	 * Returns: double. force in the units used by rest of model (pounds)
	**/
	
	public static double convertForcetoInternal (double input, ForceUnits units)
	{
		if(units == ForceUnits.POUND_FORCE)
		{
			return input;
		}
		return (input * 0.224809);
	} // convertForceMtoI()
	
	/**
	 * convertForceFromInternal()
	 * 
	 * Purpose: Converts and returns force from internal units to one of several external units.
	 * 
	 * Parameters:
	 * 		double input -- Force in the units used by rest of model (pounds)
	 * 		ForceUnits units -- what unit the output is desired in
	 * 
	 * Returns: double. Force in pounds, or newtons.
	 * @param units TODO
	**/
	
	public static double convertForceFromInternal (double input, ForceUnits units)
	{
		if(units == ForceUnits.POUND_FORCE)
		{
			return input;
		}
		return (input / 0.224809);
	} // convertForceItoM()
	
	/**
	 * convertDensityToInternal()
	 * 
	 * Purpose: Converts and returns density from one of several external units to internal units.
	 * 
	 * Parameters:
	 * 		double input -- Density in 	g/cm3, lbm/ft3, lbm/in3, g/in3, kg/m3
	 * 		DensityUnits units -- what unit the input is in
	 * 
	 * Returns: double. Density in the units used by rest of model (lbm/in3)
	 * @param units TODO
	**/
	
	public static double convertDensityToInternal (double input, DensityUnits units)
	{
		if(units == DensityUnits.POUNDS_MASS_PER_CUBIC_INCH)
		{
			return input;
		}
		
		if(units == DensityUnits.POUNDS_MASS_PER_CUBIC_FOOT)
		{
			input *= 12 *12 *12;
			return input;
		}
		
		if(units == DensityUnits.GRAMS_PER_CUBIC_INCH)
		{
			return convertMassToInternal(input, MassUnits.GRAMS);
		}
		
		if(units == DensityUnits.KILOGRAMS_PER_CUBIC_METER)
		{
			input *= 1000; //kg to gram
			input /= 100; // per meter to per cm
			input /= 100;
			input /= 100; // cubed
		} // unit is now g/cm3
		
		
		//if(units == DensityUnits.GRAMS_PER_CUBIC_CENTIMETER)
		
		input = convertMassToInternal(input, MassUnits.GRAMS);
		input *= 2.54 * 2.54 * 2.54;
		return input;
		
	} // convertDesityMtoI()
	
	/**
	 * convertDensityFromInternal()
	 * 
	 * Purpose: Converts and returns density from internal units to one of several external units.
	 * 
	 * Parameters:
	 * 		double input -- Density in the units used by rest of model (lbm/in3)
	 * 		DensityUnits units -- what unit the output is desired in
	 * 
	 * Returns: double. Density in 	g/cm3, lbm/ft3, lbm/in3, g/in3, kg/m3
	 * @param units TODO
	**/
	
	public static double convertDensityFromInternal (double input, DensityUnits units)
	{
		if(units == DensityUnits.POUNDS_MASS_PER_CUBIC_INCH)
		{
			return input;
		}
		
		if(units == DensityUnits.POUNDS_MASS_PER_CUBIC_FOOT)
		{
			input /= 12 *12 *12;
			return input;
		}
		
		if(units == DensityUnits.GRAMS_PER_CUBIC_INCH)
		{
			return convertMassFromInternal(input, MassUnits.GRAMS);
		}
		
		if(units == DensityUnits.KILOGRAMS_PER_CUBIC_METER)
		{
			input /= 1000; //gram to kg
			input *= 100; // per cm to per meter
			input *= 100;
			input *= 100; // cubed
		} // unit is now g/cm3
		
		
		//if(units == DensityUnits.GRAMS_PER_CUBIC_CENTIMETER)
		
		input = convertMassFromInternal(input, MassUnits.GRAMS);
		input /= 2.54 * 2.54 * 2.54;
		return input;
	} // convertDensityItoM()
	
	/**
	 * convertFlowRateToInternal()
	 * 
	 * Purpose: Converts and returns mass flow rate from one of several external units to internal units.
	 * 
	 * Parameters:
	 * 		double input -- Mass flow rate in pounds mass/ sec, kg/sec
	 * 		MassFlowRateUnits units -- what unit the input is in
	 * 
	 * Returns: double. Mass flow rate in the units used by rest of model (pounds mass/ sec)
	**/
	
	public static double convertFlowRateToInternal (double input, MassFlowRateUnits units)
	{
		if(units == MassFlowRateUnits.POUNDS_MASS_PER_SECOND)
		{
			return input;
		}
		
		return convertMassToInternal(input, MassUnits.KILOGRAMS);
	} // convertAreaItoM()
	
	/**
	 * convertFlowRateFromInternal()
	 * 
	 * Purpose: Converts and returns mass flow rate from internal units to one of several external units.
	 * 
	 * Parameters:
	 * 		double input -- Mass flow rate in the units used by rest of model (pounds mass/ sec)
	 * 		PressureUnits units -- what unit the output is desired in
	 * 
	 * Returns: double. Mass flow rate in pounds mass/ sec, kg/sec
	**/
	
	public static double convertFlowRateFromInternal (double input, MassFlowRateUnits units)
	{
		if(units == MassFlowRateUnits.POUNDS_MASS_PER_SECOND)
		{
			return input;
		}
		
		return convertMassFromInternal(input, MassUnits.KILOGRAMS);
	} // convertAreaItoM()
	
	/**
	 * convertPressureToInternal()
	 * 
	 * Purpose: Converts and returns Pressure from one of several external units to internal units.
	 * 
	 * Parameters:
	 * 		double input -- pressure in psi, pascal
	 * 		PressureUnits units -- what unit the input is in
	 * 
	 * Returns: double. Pressure in the units used by rest of model (psi)
	 * @param units TODO
	**/
	
	public static double convertPressureToInternal (double input, PressureUnits units)
	{
		if(units == PressureUnits.PSI)
		{
			return input;
		}
		return (input * 0.000145038);
	} // convertPressureMtoI()	
	
	
	
	/**
	 * convertPressureFromInternal()
	 * 
	 * Purpose: Converts and returns pressure from internal units to one of several external units.
	 * 
	 * Parameters:
	 * 		double input -- Pressure in the units used by rest of model (psi)
	 * 		PressureUnits units -- what unit the output is desired in
	 * 
	 * Returns: double. Pressure in psi, pascal
	 * @param units TODO
	**/
	
	public static double convertPressureFromInternal (double input, PressureUnits units)
	{
		if(units == PressureUnits.PSI)
		{
			return input;
		}
		return (input / 0.000145038);
	} // convertPressureItoM()
	
} // class UnitConverter
