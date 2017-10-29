package model.calculations;

/**
 * UnitConverter.java
 * 
 * Purpose: Contains static methods that are used to convert between
 * 		Imperial and Metric units. This will allow the user to use
 * 		the application in any measurement system.
 * 
 * 		Metric units: cm, g, N, Pa
 * 		ImperialUnits: in, lbm, lbf, psi
 * 
 * 		Area and density are in appropriate combinations of the above units.
 */

public class UnitConverter
{
	/**
	 * convertLengthMtoI()
	 * 
	 * Purpose: Converts and returns length from Metric to Imperial units.
	 * 
	 * Parameters:
	 * 		double centimeters -- Length in centimeters.
	 * 
	 * Returns: double. Length in Imperial units.
	**/
	
	public static double convertLengthMtoI (double centimeters)
	{
		return ((double)(centimeters / 2.54));
	} // convertLengthMtoI()
	
	
	
	/**
	 * convertMassMtoI()
	 * 
	 * Purpose: Converts and returns mass from Metric to Imperial units.
	 * 
	 * Parameters:
	 * 		double grams -- Mass in Metric units.
	 * 
	 * Returns: double. Mass in Imperial units.
	**/
	
	public static double convertMassMtoI (double grams)
	{
		return ((double)(grams * 0.00220462));		
	} // convertMassMtoI()
	
	
	
	/**
	 * convertForceMtoI()
	 * 
	 * Purpose: Converts force from Metric to Imperial units.
	 * 
	 * Parameters:
	 * 		double newton -- Force in Metric units.
	 * 
	 * Returns: double. Force in Imperial units.
	**/
	
	public static double convertForceMtoI (double newton)
	{
		return ((double)(newton * 0.224809));
	} // convertForceMtoI()
	
	
	
	/**
	 * convertDensityMtoI()
	 * 
	 * Purpose: Converts and returns the density from Metric to Imperial units.
	 * 
	 * Parameters:
	 * 		double gramsPerCmCubed -- Density in Metric units.
	 * 
	 * Returns: double. Density in Imperial units.
	**/
	
	public static double convertDensityMtoI (double gramsPerCmCubed)
	{
		gramsPerCmCubed = convertMassMtoI(gramsPerCmCubed);
		
		gramsPerCmCubed *= 2.54;   // double division is multiplication
		gramsPerCmCubed *= 2.54;
		gramsPerCmCubed *= 2.54;
		
		return gramsPerCmCubed;
	} // convertDesityMtoI()
	
	
	
	/**
	 * convertAreaMtoI()
	 * 
	 * Purpose: Converts and returns area from Metric to Imperial units.
	 * 
	 * Parameters:
	 * 		double centimeterSquared -- Area in Metric units.
	 * 
	 * Returns: double. Area in Imperial units.
	**/
	
	public static double convertAreaMtoI (double centimeterSquared)
	{
		centimeterSquared = convertLengthMtoI(centimeterSquared);
		centimeterSquared = convertLengthMtoI(centimeterSquared);
		
		return centimeterSquared;
	} // convertAreaMtoI()
	
	
	
	/**
	 * convertPressureMtoI()
	 * 
	 * Purpose: Converts and returns the pressure from Metric to Imperial units.
	 * 
	 * Parameters:
	 * 		double pascal -- Pressure in Metric units.
	 * 
	 * Returns: double. Pressure in Imperial units.
	**/
	
	public static double convertPressureMtoI (double pascal)
	{
		return ((double)(pascal * 0.000145038));
	} // convertPressureMtoI()
	
	
	
	/**
	 * convertLengthItoM()
	 * 
	 * Purpose: Converts and returns length from Imperial to Metric units.
	 * 
	 * Parameters:
	 * 		double inches -- Length in Imperial units.
	 * 
	 * Returns: double. Length in Imperial units.
	**/
	
	public static double convertLengthItoM (double inches)
	{
		return ((double)(inches * 2.54));
	} // convertLengthItoM()
	
	
	
	/**
	 * convertMassItoM()
	 * 
	 * Purpose: Converts and returns mass from Imperial to Metric units.
	 * 
	 * Parameters:
	 * 		double lbm -- Mass in Imperial units.
	 * 
	 * Returns: double. Mass in Metric units.
	**/
	
	public static double convertMassItoM (double lbm)
	{
		return ((double)(lbm / 0.00220462));		
	} // convertMassItoM()
	
	
	
	/**
	 * convertForceItoM()
	 * 
	 * Purpose: Converts and returns force from Imperial to Metric units.
	 * 
	 * Parameters:
	 * 		double lbf -- Force in Imperial units.
	 * 
	 * Returns: double. Force in Imperial units.
	**/
	
	public static double convertForceItoM (double lbf)
	{
		return ((double)(lbf / 0.224809));
	} // convertForceItoM()
	
	
	
	/**
	 * convertDensityItoM()
	 * 
	 * Purpose: Converts and returns density from Imperial to Metric units.
	 * 
	 * Parameters:
	 * 		double lbmPerInchesCubed -- Density in Imperial units.
	 * 
	 * Returns: double. Density in Metric units.
	**/
	
	public static double convertDensityItoM (double lbmPerInchesCubed)
	{
		lbmPerInchesCubed = convertMassItoM(lbmPerInchesCubed);
		
		lbmPerInchesCubed /= 2.54;   // double division is multiplication
		lbmPerInchesCubed /= 2.54;
		lbmPerInchesCubed /= 2.54;
		
		return lbmPerInchesCubed;
	} // convertDensityItoM()
	
	
	
	/**
	 * convertAreaItoM()
	 * 
	 * Purpose: Converts and returns area from Imperial to Metric units.
	 * 
	 * Parameters:
	 * 		double inchesSquared -- Area in Imperial units.
	 * 
	 * Returns: double. Area in Metric units.
	**/
	
	public static double convertAreaItoM (double inchesSquared)
	{
		inchesSquared = convertLengthItoM(inchesSquared);
		inchesSquared = convertLengthItoM(inchesSquared);
		
		return inchesSquared;
	} // convertAreaItoM()
	
	
	
	/**
	 * convertPressureItoM()
	 * 
	 * Purpose: Converts and returns PSI from Imperial to Metric units.
	 * 
	 * Parameters:
	 * 		double psi -- PSI in imperial units.
	 * 
	 * Returns: double. Pressure in metric units.
	**/
	
	public static double convertPressureItoM (double psi)
	{
		return ((double)(psi / 0.000145038));
	} // convertPressureItoM()
	
} // class UnitConverter