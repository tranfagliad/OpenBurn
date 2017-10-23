/*
 *  Metric units: cm, g, N, Pa
 * ImperialUnits: in, lbm, lbf, psi
 * 
 * Area and density are in appropriate combinations of the above units
 * 
 */

package model;

public class UnitConverter
{
	public static double convertLenghtMtoI(double centimeters)
	{
		return centimeters / 2.54;
	}
	
	public static double convertMassMtoI(double grams)
	{
		return grams * 0.00220462;		
	}
	
	public static double convertForceMtoI(double newton)
	{
		return newton * 0.224809;
	}
	
	public static double convertDensityMtoI(double gramsPerCmCubed)
	{
		gramsPerCmCubed = convertMassMtoI(gramsPerCmCubed);
		gramsPerCmCubed *= 2.54; // double division is multiplication
		gramsPerCmCubed *= 2.54;
		gramsPerCmCubed *= 2.54;
		return gramsPerCmCubed;
	}
	
	public static double convertAreaMtoI(double centmeterSquared)
	{
		centmeterSquared = convertLenghtMtoI(centmeterSquared);
		centmeterSquared = convertLenghtMtoI(centmeterSquared);
		return centmeterSquared;
	}
	
	public static double convertPressureMtoI(double pascal)
	{
		return pascal * 0.000145038;
	}
	
	public static double convertLenghtItoM(double inches)
	{
		return inches * 2.54;
	}
	
	public static double convertMassItoM(double lbm)
	{
		return lbm / 0.00220462;		
	}
	
	public static double convertForceItoM(double lbf)
	{
		return lbf / 0.224809;
	}
	
	public static double convertDensityItoM(double lbmPerInchesCubed)
	{
		lbmPerInchesCubed = convertMassItoM(lbmPerInchesCubed);
		lbmPerInchesCubed /= 2.54; // double division is multiplication
		lbmPerInchesCubed /= 2.54;
		lbmPerInchesCubed /= 2.54;
		return lbmPerInchesCubed;
	}
	
	public static double convertAreaItoM(double inchesSquared)
	{
		inchesSquared = convertLenghtItoM(inchesSquared);
		inchesSquared = convertLenghtItoM(inchesSquared);
		return inchesSquared;
	}
	
	public static double convertPressureItoM(double psi)
	{
		return psi / 0.000145038;
	}
}
