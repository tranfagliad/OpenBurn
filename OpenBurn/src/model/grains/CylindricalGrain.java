package model.grains;

/**
 * CylindricalGrain.java
 * 
 * Purpose: 
**/

public class CylindricalGrain extends Grain
{
	/**
	 * 
	**/
	
	public CylindricalGrain(double length, double outerDiameter, double innerDiameter, int numBurningEnds)
	{
		super(length, outerDiameter, innerDiameter, numBurningEnds);
	}

	
	
	
	

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
		return Math.PI * Math.pow(this.innerDiameter / 2, 2);   // Area = pi*(d/2)^2
	}

	@Override
	public double getCurrentInnerFlowVolume() 
	{
		return this.getCurrentInnerFlowArea() * this.length;
	}

	@Override
	public double getLengthDifference()
	{
		return this.initialLength - this.length;
	}
	
	
	
} // class CylindricalGrain
