package model.calculations;

/**
 * Propellant.java
 * 
 * Purpose: Represents the Propellant of a rocket during simulations.
**/

public class Propellant
{
	private double burnRateCoefficient; // a
	private double burnRateExponent; // n
	private double density; // rho
	private double Cstar;
	
	
	/**
	 * Propellant Constructor
	 * 
	 * Purpose: Creates and initializes a case for the rocket during
	 * 		the simulation.
	**/
	public Propellant(double burnRateCoefficient, double burnRateExponent, double density, double Cstar)
	{
		this.burnRateCoefficient = burnRateCoefficient;
		this.burnRateExponent = burnRateExponent;
		this.density = density;
		this.Cstar = Cstar;
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
	public double pressureFromKn(double Kn)
	{
		//p = (Kn * a * rho * C* )^(1/(1-n))
	    double exponent = 1.0 / (1.0 - burnRateExponent);
	    double p1 = Kn * burnRateCoefficient * density * Cstar;
	    return Math.pow(p1, exponent);
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
	public double burnRateFromPressure(double pressure)
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
	
}//Propellant
