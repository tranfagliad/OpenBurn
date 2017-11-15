package model.propellant;


/**
 * 
 *
 */
public class EmpericalPropellant extends Propellant {
	
	private double Kn;
	private double p_slope;
	private double p_intercept;
	private double br_slope;
	private double br_intercept;
	private double density;
	
	public EmpericalPropellant(double p_slope, double p_intercept, double br_slope, double br_intercept, double density)
	{
		this.p_slope = p_slope;
		this.p_intercept = p_intercept;
		this.br_slope = br_slope;
		this.br_intercept = br_intercept;
		this.density = density;
		this.Kn = 0; // Prevent null pointer exceptions 
	}
	
	/**
	 * setKn(double Kn)
	 * 
	 * Purpose: Set the Kn to be used in the model
	 */
	public void setKn(double Kn){
		this.Kn = Kn;
	}
	
	/**
	 * pressureFromKn()
	 * 
	 * Purpose: calculates and returns the case pressure at one instant of time.
	 * 
	 * Returns: double. The chamber pressure at one instant of time.
	**/
	public double getChamberPressure() {
		return (p_slope*Kn) + p_intercept;
	}

	/**
	 * burnRateFromPressure()
	 * 
	 * Purpose: calculates and returns the burn rate at one instant of time.
	 * 
	 * Parameters: double -- the pressure at one instant of time.
	 * 
	 * Returns: double. The burn rate at one instant of time.
	**/
	public double getBurnRate() {
		return (br_slope*Kn) + br_intercept;
	}

	public double getPropellantDensity() {
		return this.density;
	}

}
