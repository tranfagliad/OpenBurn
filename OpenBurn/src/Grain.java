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

	// public method that dose error checking for the constructor because constructors can't return null;
//	public static Grain getNewGrain(float outerDiameter, float length, float innerDiameter, int burningEnds)
//	{
//		if(outerDiameter <= 0)
//		{
//			return null;
//		}
//		if(innerDiameter <= 0)
//		{
//			return null;
//		}
//		if(innerDiameter >= outerDiameter)
//		{
//			return null;
//		}
//		if(length < 0)
//		{
//			return null;
//		}
//		if(burningEnds < 0 || burningEnds > 2)
//		{
//			return null;
//		}
//		
//		return new Grain(outerDiameter, length, innerDiameter, burningEnds);
//	}
//	
//	private Grain(float outDiameter, float lngth, float inDiameter, int burnEnds)
//	{
//		outerDiameter = outDiameter;
//		length = lngth;
//		innerDiameter = inDiameter;
//		burningEnds = burnEnds;
//	}
	
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
	}
	
	public static void setPropelentDensity(float density)
	{
		if(density <= 0)
		{
			throw new IllegalArgumentException("propellent density must be positive");
		}
		propellantDensity = density;
	}
	
//	public static boolean setPropelentDensity(float density)
//	{
//		if(density <= 0)
//		{
//			return false;
//		}
//		propellantDensity = density;
//		return true;
//	}

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
}
