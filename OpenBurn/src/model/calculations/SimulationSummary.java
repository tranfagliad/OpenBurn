package model.calculations;

import java.util.Iterator;
import java.util.List;


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
	
	public SimulationSummary(List<SimulationResults> results)
	{
		Iterator<SimulationResults> iter = results.iterator();
		SimulationResults prev = iter.next();
		double impulseCalc = 0;
		double maxThrust = 0;
		double maxPressure = 0;
		double averageThrustHelper = 0;
		double count = 1;
		double mass = prev.getSystemMass();
		while(iter.hasNext())
		{
			count++;
			SimulationResults curr = iter.next();
			double imp_calc = (curr.getTime() - prev.getTime()) + ((curr.getThrust() - prev.getThrust())/2);
			impulseCalc += imp_calc;
			averageThrustHelper += curr.getThrust();
			maxThrust = Math.max(maxThrust, curr.getThrust());
			maxPressure = Math.max(maxPressure, curr.getChamberPressure());
			prev = curr;
		}
		averageThrustHelper/=count;
		this.impulse = impulseCalc;
		this.ISP = impulse/mass;
		this.averageThrust = averageThrustHelper;
		this.maxPressure = maxPressure;
		this.maxThrust = maxThrust;
		this.massFrac = 65; // TODO: fix this!
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
	
} // class ImpulseClassifier
