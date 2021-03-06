package model.grains;

/**
 * Grain.java
 * 
 * Contains data for an individual grain for a rocket motor.
 * Crucial to graph calculations. Includes methods that allow the
 * grain to change over time.
**/

abstract public class Grain implements Cloneable
{
	// Error messages
	protected static final String OUTER_DIAMETER_ERR_MSG  = "ERROR: Outer diameter must be positive!\n";
	protected static final String INNER_DIAMETER_ERR_MSG  = "ERROR: Inner diameter must be positive!\n";
	protected static final String OUTER_INNER_ERR_MSG     = "ERROR: Outer diameter must be greater than inner diameter.\n";
	protected static final String LENGTH_ERR_MSG          = "ERROR: Length must be positive.\n";
	protected static final String BURNING_ENDS_ERR_MSG    = "ERROR: Burning ends must be 0, 1, or 2.\n";
	protected static final String PROP_DENSITY_ERR_MSG    = "ERROR: Propellant density must be positive!\n";
	protected static final String NEGATIVE_VOLUME_ERR_MSG = "ERROR: Negative volume change occurred!\n";
	
	
	
	// Fields
	protected GrainType type;
	protected int grainID;
//	protected double propellantDensity;
	protected double length;
	protected double outerDiameter;
	protected double innerDiameter; 
	protected final double initialLength;
	protected int numBurningEnds;
	protected double burnoutTime;
	protected boolean isBurning;
	
	
	
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
	 * 
	 * 		NOTE: Grain is initialized to currently burning.
	**/
	
	protected Grain (GrainType type, double length, double outerDiameter, double innerDiameter, int numBurningEnds)
	{
		// Error check all inputs
		if (length <= 0)
			throw new IllegalArgumentException(LENGTH_ERR_MSG);
		if (outerDiameter <= 0)
			throw new IllegalArgumentException(OUTER_DIAMETER_ERR_MSG);
		if (innerDiameter <= 0)
			throw new IllegalArgumentException(INNER_DIAMETER_ERR_MSG);
		if (innerDiameter >= outerDiameter)
			throw new IllegalArgumentException(OUTER_INNER_ERR_MSG);
		if (numBurningEnds < 0 || numBurningEnds > 2)
			throw new IllegalArgumentException(BURNING_ENDS_ERR_MSG);
		
		// Set fields
		this.type           = type;
		this.grainID        = 0;
		this.outerDiameter  = outerDiameter;
		this.length         = length;
		this.innerDiameter  = innerDiameter;
		this.numBurningEnds = numBurningEnds;
		this.initialLength  = length;
		this.isBurning      = true;
		
		// Initialize burnout time to 0 seconds
		setBurnoutTime(0.0);
	} // Grain Constructor
	
	
	
	/**
	 * getType()
	 * 
	 * Purpose: Returns the type of the grain.
	 * 
	 * Parameters:
	 * 
	 * Returns: GrainType. The type of the grain.
	**/
	
	public GrainType getType ()
	{
		return type;
	} // getType()
	
	
	
	/**
	 * getGrainID()
	 * 
	 * Purpose: Returns the ID of the grain.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: int. The ID of the grain.
	**/
	
	public int getGrainID ()
	{
		return grainID;
	} // getGrainID()
	
	
	
	/**
	 * setGrainID()
	 * 
	 * Purpose: Changes the ID of the grain to a new value.
	 * 
	 * Parameters:
	 * 		int newID -- The ID value to set.
	 * 
	 * Returns: void.
	**/
	
	public void setGrainID (int newID)
	{
		this.grainID = newID;
	} // setGrainID()
	
	
	
	/**
	 * getPropellantDensity()
	 * 
	 * Purpose: Returns the propellant density.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The propellant density.
	**/
	
//	public double getPropellantDensity ()
//	{
//		return propellantDensity;
//	} // getPropellantDensity()
	
	
	
	/**
	 * setPropellantDensity()
	 * 
	 * Purpose: Changes the propellant density to a new value.
	 * 
	 * Parameters:
	 * 		double density -- New value to set the propellant density.
	 * 
	 * Returns: void.
	**/
	
//	public void setPropellantDensity (double density)
//	{
//		// Density must not be negative
//		if (density <= 0.0)
//			throw new IllegalArgumentException(PROP_DENSITY_ERR_MSG);
//				
//		// Set density
//		propellantDensity = density;
//	} // setPropellantDensity()

	
	
	/**
	 * getLength()
	 * 
	 * Purpose: Returns the length of the grain.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The length of the grain.
	**/
	
	public double getLength ()
	{
		return length;
	} // getLength()
	
	
	
	/**
	 * setLength()
	 * 
	 * Purpose: Changes the length of the grain to a new value.
	 * 
	 * Parameters:
	 * 		double newLength -- New length value to set.
	 * 
	 * Returns: void.
	**/
	
	public void setLength (double newLength)
	{
		length = newLength;
	} // setLength()
	
	
	
	/**
	 * getOuterDiameter()
	 * 
	 * Purpose: Returns the outer diameter of the grain.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The outer diameter of the grain.
	**/
	
	public double getOuterDiameter ()
	{
		return outerDiameter;
	} // getOuterDiameter()
	
	
	
	/**
	 * setOuterDiameter()
	 * 
	 * Purpose: Changes the outer diameter of the grain to a new value.
	 * 
	 * Parameters:
	 * 		double newOuterDiameter -- New outer diameter value to set.
	 * 
	 * Returns: void.
	**/
	
	public void setOuterDiameter (double newOuterDiameter)
	{
		outerDiameter = newOuterDiameter;
	} // setOuterDiameter()
	
	
	
	/**
	 * getInnerDiameter()
	 * 
	 * Purpose: Returns the inner diameter of the grain.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The inner diameter of the grain.
	**/
	
	public double getInnerDiameter ()
	{
		return innerDiameter;
	} // getInnerDiameter()
	
	
	
	/**
	 * setInnerDiameter()
	 * 
	 * Purpose: Changes the inner diameter of the grain to a new value.
	 * 
	 * Parameters:
	 * 		double newInnerDiameter -- New inner diameter value to set.
	 * 
	 * Returns: void.
	**/
	
	public void setInnerDiameter (double newInnerDiameter)
	{
		innerDiameter = newInnerDiameter;
	} // setInnerDiameter()
	
	
	
	/**
	 * getNumBurningEnds()
	 * 
	 * Purpose: Returns the number of burning ends.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: int. The number of burning ends.
	**/
	
	public int getNumBurningEnds ()
	{
		return numBurningEnds;
	} // getNumBurningEnds()
	
	
	
	/**
	 * setNumBurningEnds()
	 * 
	 * Purpose: Changes the amount of burning ends to
	 * 		a new value.
	 * 
	 * Parameters:
	 * 		int newNumBurningEnds -- New amount
	 * 			of burning ends to set.
	 * 
	 * Returns: void.
	**/
	
	public void setNumBurningEnds (int newNumBurningEnds)
	{
		numBurningEnds = newNumBurningEnds;
	} // setNumBurningEnds()
	
	
	
	/**
	 * getBurnoutTime()
	 * 
	 * Purpose: Returns the burnout time.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The burnout time.
	**/
	
	public double getBurnoutTime ()
	{
		return burnoutTime;
	} // getBurnoutTime()
	
	
	
	/**
	 * setBurnoutTime()
	 * 
	 * Purpose: Changes the burnout time to a new value.
	 * 
	 * Parameters:
	 * 		double burnoutTime -- New value to set the burnout time.
	 * 
	 * Returns: void.
	**/
	
	public void setBurnoutTime (double newBurnoutTime)
	{
		this.burnoutTime = newBurnoutTime;
	} // setBurnoutTime()
	
	
	
	/**
	 * isBurning()
	 * 
	 * Purpose: Getter for the isBurning boolean. This is set initially as
	 * 		true. The update geometry method is responsible for setting
	 * 		this to false.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: boolean. The status on if the grain is burning or not.
	**/
	
	public boolean isBurning ()
	{
		return isBurning;
	} // isBurning()
	
	
	
	/**
	 * setIsBurning()
	 * 
	 * Purpose: Changes the burning status of the Grain to a
	 * 		new value.
	 * 
	 * Parameters:
	 * 		boolean isBurning -- New value to set burn status.
	 * 
	 * Returns: void.
	**/
	
	public void setIsBurning (boolean isBurning)
	{
		this.isBurning = isBurning;
	} // setIsBurning()
	
	
	
	/**
	 * getVolume()
	 * 
	 * Purpose: Uses the current values of the grain properties to calculate
	 * 		and return the volume of the grain.
	 * 
	 * 		NOTE: Implementation depends on shape.
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
	 * 		NOTE: Implementation depends on shape.
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
	 * 		The overall change in volume is returned.
	 * 
	 * 		NOTE: Implementation depends on shape.
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
	 * 		NOTE: Implementation depends on shape.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The inner flow area of the motor
	**/
	
	abstract public double getCurrentInnerFlowArea();
	
	
	
	/**
	 * getCurrentInnerFlowVolume()
	 * 
	 * Purpose: Uses the current geometry state to get the inner flow
	 * 		volume of the motor. This is provided in the grains standard unit.
	 * 		This is used for l* calculations.
	 * 
	 * 		NOTE: Implementation depends on shape.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The inner flow volume of the motor.
	**/
	
	abstract public double getCurrentInnerFlowVolume();
	
	
	
	/**
	 * clone()
	 * 
	 * Purpose: Fulfills the requirements of the clonable interface.
	 * 		Returns a clone of the grain. Implementation and
	 * 		specifications will differ for different grain types.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: Grain. A copy of the grain.
	**/
	
	abstract public Grain clone();
	
	
	
	/**
	 * getLengthDifference()
	 * 
	 * Purpose: Compares the current length of the motor with the its
	 * 		initial length and returns the difference. Used in l* calculation.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The difference between the initial and current 
	 * 		grain length.
	**/
	
	public double getLengthDifference()
	{
		return (initialLength - length);
	} // getLengthDifference()
	
} // abstract class Grain
