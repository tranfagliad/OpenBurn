package model;

/**
 * Grain.java
 * 
 * Contains data for an individual grain for a rocket motor.
 * Crucial to graph calculations. Includes methods that allow the
 * grain to change over time.
**/

abstract public class Grain
{
	// Error messages
	

	
	/**
	 * Grain Constructor
	 * 
	 * Purpose: Creates and initializes a Grain object using the given
	 * 		values for outer diameter, inner diameter, and the number of
	 * 		burning ends. Burnout time is initialized to 0 seconds.
	 * 
	 * 		Requirements:
	 * 		- Outer and inner diameters MUST be positive.
	 * 		- Outer diameter MUST be greater than inner diameter.
	 * 		- Length MUST be positive.
	 * 		- Number of burning ends must be 0, 1, or 2.
	 * 
	 * 		NOTE: Propellant density is not set here, user must call
	 * 			setPropellantDensity() to set it.
	**/
	
	public Grain ()
	{
		// Error check all inputs
		
	} // Grain Constructor
	
	
	
	/**
	 * getPropellantDensity()
	 * 
	 * Purpose: Returns the current value for propellant density.
	 * 
	 * Arguments: None.
	 * 
	 * Returns: double. Propellant density value.
	**/
	
	abstract public double getPropellantDensity ();
	
	
	
	/**
	 * setPropellantDensity()
	 * 
	 * Purpose: Change the propellant density to a new value.
	 * 
	 * 		Throws an IllegalArgumentException if the new value
	 * 		is negative.
	 * 
	 * Arguments:
	 * 		double density -- New value for propellant density.
	 * 
	 * Returns: void.
	**/
	
	abstract public void setPropellantDensity (double density);

	
	
	/**
	 * getLength()
	 * 
	 * Purpose: Returns the current value for length.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The current value for length.
	**/
	
	abstract public double getLength ();
	
	
	
	/**
	 * getOuterDiameter()
	 * 
	 * Purpose: Returns the current value for outer diameter.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The current value for outer diameter.
	**/
	
	abstract public double getOuterDiameter ();
	
	
	
	/**
	 * getInnerDiameter()
	 * 
	 * Purpose: Returns the current value for inner diameter.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The current value for inner diameter.
	**/
	
	abstract public double getInnerDiameter();
	
	
	
	/**
	 * getNumBurningEnds()
	 * 
	 * Purpose: Returns the number of burning ends.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: int. The number of burning ends.
	**/
	
	abstract public int getNumBurningEnds();
	
	
	/**
	 * getBurnoutTime()
	 * 
	 * Purpose: Returns the burnout time, in seconds.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The burnout time, in seconds.
	**/
	
	abstract public double getBurnoutTime ();

	
	
	/**
	 * setBurnoutTime()
	 * 
	 * Purpose: Changes the burnout time to a new value.
	 * 
	 * Parameters:
	 * 		double burnoutTime -- The new value for the burnout time.
	 * 
	 * Returns: void.
	**/
	
	abstract public void setBurnoutTime (double burnoutTime);
	
	
	
	/**
	 * getVolume()
	 * 
	 * Purpose: Uses the current values of the grain properties to calculate
	 * 		and return the volume of the grain.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The volume of the grain.
	**/
	
	abstract public double getVolume ();
	
	
	
	/**
	 * getBurnArea()
	 * 
	 * Purpose: Uses the current values of the grain properties to calculate
	 * 		and return the burnable surface area of the grain. All calculations
	 * 		are based on those performed in cylindrical_grain_burn_area.m.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The burnable surface area of the grain.
	**/
	
	abstract public double getBurnArea ();
	
	
	
	/**
	 * updateGeometry()
	 * 
	 * Purpose: Updates the Grain object using calculations based on
	 * 		those performed in cylindrical_grain_geomtetry_update.m,
	 * 		using the given burn rate and change in time (seconds).
	 * 		
	 * 		The overall change in volume is returned.
	 * 
	 * Parameters:
	 * 		double burnRate -- Burn rate affecting the grain.
	 * 		double deltaTime -- Change in time.
	 * 
	 * Returns: double. The change in volume after calculations.
	**/
	
	abstract public double updateGeometry (double burnRate, double deltaTime);
	
	
	
	/**
	 * getCurrentInnerFlowArea()
	 * 
	 * Purpose: Uses the current geometry state to get the inner flow
	 * 		area of the motor. This is provided in the grains standard unit.
	 * 		This is used for mass flow per area and port to throat ratio
	 * 		calculations.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The inner flow area of the motor
	 */
	abstract public double getCurrentInnerFlowArea();
	
	
	
	/**
	 * getCurrentInnerFlowVolume()
	 * 
	 * Purpose: Uses the current geometry state to get the inner flow
	 * 		volume of the motor. This is provided in the grains standard unit.
	 * 		This is used for l* calculations.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The inner flow volume of the motor.
	 */
	abstract public double getCurrentInnerFlowVolume();
	
	
	
	/**
	 * getlengthDifference()
	 * 
	 * Purpose: Compares the current length of the motor with the its
	 * 		initial length and returns the difference. Used in l* calculation
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The difference between the initial and current 
	 * 		grain length.
	 */
	abstract public double getlengthDifference();
	
	
	
	/**
	 * isBurning()
	 * 
	 * Purpose: Getter for the isBurning boolean. This is set initially as
	 * 			true. The update geometry method is responsible for setting
	 * 			this to false.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: boolean. The status on if the grain is burning or not.
	 */
	abstract public boolean isBurning();
	
} // class Grain
