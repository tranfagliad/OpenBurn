package model.calculations;

import java.util.Iterator;
import java.util.List;

import model.unitConversion.ForceUnits;
import model.unitConversion.UnitConverter;


/**
 * ImpulseClassifier.java
 * 
 * Purpose: 
**/

public class SimulationSummary
{
	// Private fields
	private String classification;
	private double ISP;
	private double massFrac;
	private double impulse;
	private double averageThrust;
	private double maxThrust;
	private double maxPressure;
	private double burnTime;
	
	public SimulationSummary(List<SimulationResults> results)
	{
		Iterator<SimulationResults> iter = results.iterator();
		double maxThrust = 0;
		double maxPressure = 0;
		double averageThrustHelper = 0;
		double count = 1;
		double a = 0;
		double b = 0;
		double trap_integral_helper = 0;
		while(iter.hasNext())
		{
			count++;
			SimulationResults curr = iter.next();
			if(count == 1)// First element
			{
				a = curr.getTime(); // Probably 0, but should be done this way
				trap_integral_helper += curr.getThrust();
			}else if(!iter.hasNext())//Last element
			{
				b = curr.getTime();
				trap_integral_helper += curr.getThrust();
			}else//Middle elements
			{

				trap_integral_helper += (2*curr.getThrust());
			}
			averageThrustHelper += curr.getThrust();
			maxThrust = Math.max(maxThrust, curr.getThrust());
			maxPressure = Math.max(maxPressure, curr.getChamberPressure());
		}
		double delta_x = (b-a)/count;
		this.impulse = trap_integral_helper * (delta_x/2);
		this.ISP = impulse/results.get(0).getSystemMass();
		this.averageThrust = averageThrustHelper/count;
		this.maxPressure = maxPressure;
		this.maxThrust = maxThrust;
		this.massFrac = 65; // TODO: fix this!
		this.burnTime = b;
		
		double metric_impulse = UnitConverter.convertForceFromInternal(impulse, ForceUnits.NEWTONS);
		
		//Classification generation
		int letter_code = 1;
		double lower_bound = 1.25;
		while (!((metric_impulse >= lower_bound) && (metric_impulse < (lower_bound * 2))))
		{
			letter_code++;
			lower_bound*=2;
		}
		char letter = (char) (64 + letter_code);
		double metric_average_thrust = UnitConverter.convertForceFromInternal(averageThrust, ForceUnits.NEWTONS);
		this.classification = String.format("%c%.0f", letter,metric_average_thrust);	
	}
	
	
	
	/**
	 * getClassification()
	 * 
	 * Purpose:
	 * 
	 * Parameters:
	 * 
	 * Returns:
	**/
	
	public String getClassification ()
	{
		return classification;
	} // getClassification()
	
	
	
	/**
	 * ISP()
	 * 
	 * Purpose:
	 * 
	 * Parameters:
	 * 
	 * Returns:
	**/
	
	public double ISP ()
	{
		return ISP;
	} // ISP()
	
	/**
	 * getImpulse()
	 * 
	 * Purpose:
	 * 
	 * Parameters:
	 * 
	 * Returns:
	**/
	public double getImpulse() {
		return impulse;
	}

	/**
	 * getMassFrac()
	 * 
	 * Purpose:
	 * 
	 * Parameters:
	 * 
	 * Returns:
	**/
	
	public double getMassFrac ()
	{
		return massFrac;
	} // getMassFrac()
	
	/**
	 * getMaxThrust()
	 * 
	 * Purpose:
	 * 
	 * Parameters:
	 * 
	 * Returns:
	**/
	
	public double getMaxThrust ()
	{
		return maxThrust;
	} // getMaxThrust()
	
	/**
	 * getaverageThrust()
	 * 
	 * Purpose:
	 * 
	 * Parameters:
	 * 
	 * Returns:
	**/
	
	public double getaverageThrust ()
	{
		return averageThrust;
	} // getaverageThrust()
	
	/**
	 * getmaxPressure()
	 * 
	 * Purpose:
	 * 
	 * Parameters:
	 * 
	 * Returns:
	**/
	
	public double getmaxPressure ()
	{
		return maxPressure;
	} // getmaxPressure()
	
	/**
	 * getBurnTime()
	 * 
	 * Purpose:
	 * 
	 * Parameters:
	 * 
	 * Returns:
	**/
	
	public double getBurnTime()
	{
		return burnTime;
	} // getmaxPressure()
	
} // class ImpulseClassifier
