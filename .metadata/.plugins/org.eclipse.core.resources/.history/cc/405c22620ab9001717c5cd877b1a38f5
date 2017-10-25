package model;

public class CylindricalGrain extends Grain {
	
	// Propellant density is the same for all Grains
	private double propellantDensity;   // pounds per distance^3
	// Private fields
	private double length;          // Inches
	private double outerDiameter;   // Inches
	private double innerDiameter;   // Inches
	private final double initialLength; // Inches
	private int numBurningEnds;     // Must be 0, 1 or 2
	
	private double burnoutTime;     // Time that the grain burned out

	private boolean isBurning;
	
	private static final String OUTER_DIAMETER_ERR_MSG  = "ERROR: Outer diameter must be positive!\n";
	private static final String INNER_DIAMETER_ERR_MSG  = "ERROR: Inner diameter must be positive!\n";
	private static final String OUTER_INNER_ERR_MSG     = "ERROR: Outer diameter must be greater than inner diameter.\n";
	private static final String LENGTH_ERR_MSG          = "ERROR: Length must be positive.\n";
	private static final String BURNING_ENDS_ERR_MSG    = "ERROR: Burning ends must be 0, 1, or 2.\n";
	private static final String PROP_DENSITY_ERR_MSG    = "ERROR: Propellant density must be positive!\n";
	private static final String NEGATIVE_VOLUME_ERR_MSG = "ERROR: Negative volume change occurred!\n";

	public CylindricalGrain(double length, double outerDiameter, double innerDiameter, int numBurningEnds) {
		if (outerDiameter <= 0)
			throw new IllegalArgumentException(OUTER_DIAMETER_ERR_MSG);
		if (innerDiameter <= 0)
			throw new IllegalArgumentException(INNER_DIAMETER_ERR_MSG);
		if (innerDiameter >= outerDiameter)
			throw new IllegalArgumentException(OUTER_INNER_ERR_MSG);
		if (length < 0)
			throw new IllegalArgumentException(LENGTH_ERR_MSG);
		if (numBurningEnds < 0 || numBurningEnds > 2)
			throw new IllegalArgumentException(BURNING_ENDS_ERR_MSG);
		
		// Set fields
		this.outerDiameter  = outerDiameter;
		this.length         = length;
		this.innerDiameter  = innerDiameter;
		this.numBurningEnds = numBurningEnds;
		this.initialLength = length;
		this.isBurning = true;
		
		// Initialize burnout time to 0 seconds
		setBurnoutTime(0.0);
		
	}

	@Override
	public double getPropellantDensity() 
	{
		return this.propellantDensity;
	}

	@Override
	public void setPropellantDensity(double density)
	{
		// Density must not be negative
		if (density <= 0.0)
			throw new IllegalArgumentException(PROP_DENSITY_ERR_MSG);
		
		// Set density
		propellantDensity = density;
	}

	@Override
	public double getLength() 
	{
		return this.length;
	}

	@Override
	public double getOuterDiameter() 
	{
		return this.outerDiameter;
	}

	@Override
	public double getInnerDiameter() 
	{
			return innerDiameter;
	}

	@Override
	public int getNumBurningEnds() 
	{
		return numBurningEnds;
	}

	@Override
	public double getBurnoutTime() 
	{
		return burnoutTime;
	}

	@Override
	public void setBurnoutTime(double burnoutTime) 
	{
		this.burnoutTime = burnoutTime;
	} //

	@Override
	public double getVolume() 
	{
		// Use radius instead of diameter for volume calculation
		double innerRadius = innerDiameter / 2;
		double outerRadius = outerDiameter / 2;
		
		// Calculate and return the volume of the grain using inner properties
		return Math.PI * length * (outerRadius * outerRadius - innerRadius * innerRadius );
	} // getVolume()

	@Override
	public double getBurnArea() 
	{
		double innerRadius = innerDiameter / 2;
		double outerRadius = outerDiameter / 2;
		
		double face = Math.PI * numBurningEnds * (outerRadius * outerRadius - innerRadius * innerRadius );
		double innerBurnArea = 2 * Math.PI * innerRadius * length;
		double surfaceArea = face + innerBurnArea;
		
		// Guarantees we never have negative surface area.
		// Based on motor_internal_balistics.m, line 136
		return Math.max(surfaceArea, 0); 					 
	}

	@Override
	public double updateGeometry(double burnRate, double deltaTime)
	{
		// Get current volume for initial value
		double initialVolume = getVolume();
		
		// Calculate new value for length, ensure it never becomes negative
		length = length - numBurningEnds * burnRate * deltaTime;
		length = Math.max(length, 0);
		
		// Calculate new value for inner diameter, take the smallest diameter
		// of the inner and outer diameter
		innerDiameter = innerDiameter + 2 * burnRate * deltaTime;
		innerDiameter = Math.min(innerDiameter, outerDiameter);
		
		// Get new value for the volume after calculations are complete
		double newVolume = getVolume();
		
		// Error check for negative volume change, volume should expand
		if (newVolume > initialVolume)
			throw new ArithmeticException(NEGATIVE_VOLUME_ERR_MSG);
		if (innerDiameter == outerDiameter)
		{
			this.isBurning = false;
		}
		// Return the change in volume
		return (initialVolume - newVolume);
	} // updateGeometry()

	@Override
	public double getCurrentInnerFlowArea() 
	{
		return Math.PI * Math.pow(this.innerDiameter/2, 2); // Area = pi*(d/2)^2
	}

	@Override
	public double getCurrentInnerFlowVolume() 
	{
		return this.getCurrentInnerFlowArea()*this.length;
	}

	@Override
	public double getlengthDifference()
	{
		return this.initialLength - this.length;
	}

	@Override
	public boolean isBurning() 
	{
		return this.isBurning;
	}

}
