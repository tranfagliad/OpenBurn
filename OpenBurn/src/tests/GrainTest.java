package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.*;
import model.components.grains.CylindricalGrain;
import model.components.grains.Grain;

/**
 * GrainTest.java
 * 
 * Contains unit testing for the methods in Grain.java.
**/

public class GrainTest
{
	
	
	
	
	@Test (expected = IllegalArgumentException.class)
	public void testInnerDiameterConstructorException ()
	{
		@SuppressWarnings("unused")
		Grain errorTest = new CylindricalGrain(1.0, 2.0, 1.0, 1);
	} // testInnerDiameterConstructorException()

} // test GrainTest
