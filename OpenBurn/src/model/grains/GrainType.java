package model.grains;

/**
 * GrainType.java
 * 
 * Purpose: Contains the different grain types as labels.
 * 
 * 		IMPORTANT: To add a grain type, you should add the
 * 		new type to this enum.
**/

public enum GrainType
{
	// Grain Categories
	Cylindrical,
	Star;
	
	
	
	/**
	 * toString()
	 * 
	 * Purpose: Returns the string representation of the grain type.
	 * 
	 * Parameters:
	 * 
	 * Returns: String. The string representation of the grain type.
	**/
	
	public String toString ()
	{
		return this.name();
	} // toString()
	
} // enum GrainType
