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
	private double burnTime;
	
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
		double m_prevThrust = prev.getThrust();//UnitConverter.convertForceFromInternal(prev.getThrust(),ForceUnits.NEWTONS);
		while(iter.hasNext())
		{
			count++;
			SimulationResults curr = iter.next();
			double m_thrust = curr.getThrust();//UnitConverter.convertForceFromInternal(curr.getThrust(), ForceUnits.NEWTONS);
			double imp_calc = (curr.getTime() - prev.getTime()) + ((m_thrust - m_prevThrust)/2);
			impulseCalc += imp_calc;
			averageThrustHelper += curr.getThrust();
			maxThrust = Math.max(maxThrust, curr.getThrust());
			maxPressure = Math.max(maxPressure, curr.getChamberPressure());
			m_prevThrust = m_thrust;
			prev = curr;
		}
		averageThrustHelper/=count;
		this.impulse = impulseCalc;
		this.ISP = impulse/mass;
		this.averageThrust = averageThrustHelper;
		this.maxPressure = maxPressure;
		this.maxThrust = maxThrust;
		this.massFrac = 65; // TODO: fix this!
		this.burnTime = prev.getTime();
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
