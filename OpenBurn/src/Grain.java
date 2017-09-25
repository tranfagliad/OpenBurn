/* Holds data about the individual grain
 * 
 * 
 * 
 */
public class Grain
{
	private static float propellantDensity; // pounds per inches^3

	private float outerDiameter; // inches
	private float length; // inches
	private float innerDiameter; // inches
	private int burningEnds; // 0,1 or 2
	private float burnout;  // the time that this grain burned out
	
	public Grain(float outerDiameter, float length, float innerDiameter, int burningEnds)
	{
		if(outerDiameter <= 0)
		{
			throw new IllegalArgumentException("outer diameter must be positive");
		}
		if(innerDiameter <= 0)
		{
			throw new IllegalArgumentException("inner diameter must be positive");
		}
		if(innerDiameter >= outerDiameter)
		{
			throw new IllegalArgumentException("outer diameter must be greater than inner diameter");
		}
		if(length < 0)
		{
			throw new IllegalArgumentException("length must be positive");
		}
		if(burningEnds < 0 || burningEnds > 2)
		{
			throw new IllegalArgumentException("burning ends must be 0, 1, or 2");
		}
		
		this.outerDiameter = outerDiameter;
		this.length = length;
		this.innerDiameter = innerDiameter;
		this.burningEnds = burningEnds;
		setBurnout(0);
	}
	
	public static void setPropelentDensity(float density)
	{
		if(density <= 0)
		{
			throw new IllegalArgumentException("propellent density must be positive");
		}
		propellantDensity = density;
	}

	public static float getPropellantDensity()
	{
		return propellantDensity;
	}

	public float getOuterDiameter()
	{
		return outerDiameter;
	}
	
	public float getLength()
	{
		return length;
	}
	
	public float getInnerDiameter()
	{
		return innerDiameter;
	}
	
	public int getBurningEnds()
	{
		return burningEnds;
	}

	public float getBurnout()
	{
		return burnout;
	}

	public void setBurnout(float burnout)
	{
		this.burnout = burnout;
	}
}
