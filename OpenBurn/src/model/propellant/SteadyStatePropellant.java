package model.propellant;

/**
 * Propellant.java
 * 
 * Purpose: Represents the Propellant of a rocket during simulations.
 * 
 * Based on saint roberts law and standard propellant reporting
**/

public class SteadyStatePropellant extends Propellant
{
	private double burnRateCoefficient; // a
	private double burnRateExponent; // n
	private double density; // rho
	private double Cstar;
	private double Kn;
	private double pressure;
	
	
	
	/**
	 * Propellant Constructor
	 * 
	 * Purpose: Creates and initializes a case for the rocket during
	 * 		the simulation.
	**/
	public SteadyStatePropellant(double burnRateCoefficient, double burnRateExponent, double density, double Cstar)
	{
		this.burnRateCoefficient = burnRateCoefficient;
		this.burnRateExponent = burnRateExponent;
		this.density = density;
		this.Cstar = Cstar;
		//Prevent null pointer exceptions
		this.Kn = 0;
		this.pressure = 0;
	}//Propellant Constructor
	
	/**
	 * pressureFromKn()
	 * 
	 * Purpose: calculates and returns the case pressure at one instant of time.
	 * 
	 * Parameters: double -- the kn at one instant of time.
	 * 
	 * Returns: double. The case pressure at one instant of time.
	**/
	public double getChamberPressure()
	{
		//p = (Kn * a * rho * C* )^(1/(1-n))
	    double exponent = 1.0 / (1.0 - burnRateExponent);
	    double p1 = Kn * burnRateCoefficient * density * Cstar;
	    pressure =  Math.pow(p1, exponent);
	    return pressure;
	}//pressureFromKn()
	
	/**
	 * burnRateFromPressure()
	 * 
	 * Purpose: calculates and returns the burn rate at one instant of time.
	 * 
	 * Parameters: double -- the pressure at one instant of time.
	 * 
	 * Returns: double. The burn rate at one instant of time.
	**/
	public double getBurnRate()
	{
		// r = a * p^n
		return burnRateCoefficient * Math.pow(pressure, burnRateExponent);
	}//burnRateFromPressure()

	
	/**
	 * getPropellantDensity()
	 * 
	 * Purpose: Returns the propellant density.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The propellant density.
	**/
	public double getPropellantDensity()
	{
		return density;
	}//getPropellantDensity()

	public void setKn(double Kn) 
	{
		this.Kn = Kn;
		
	}
	
}//Propellant
