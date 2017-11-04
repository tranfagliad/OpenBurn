package tests;

import static org.junit.Assert.*;
import org.junit.*;
import model.unitConversion.*;

/**
 * UnitConverterTest.java
 * 
 * Purpose: Contains unit testing for UnitConverter.
 **/

public class UnitConverterTest
{
	// Tolerance constant for double testing
	private static final double TOLERANCE = 0.0000001;

	// used in for loops to test metric to imperial to metric
	private static final double INTERVAL = 0.1;
	private static final double MAX = 20;

	@Test
	public void testConvertLengthMtoItoM()
	{
		for (LengthUnits units : LengthUnits.values())
		{
			for (double i = 0; i < MAX; i += INTERVAL)
			{
				double input = i;
				double output = UnitConverter.convertLengthToInternal(input, units);
				assertEquals(input, UnitConverter.convertLengthfromInternal(output, units), TOLERANCE);
			}
		}
	}

	@Test
	public void testConvertMassMtoItoM()
	{
		for (MassUnits units : MassUnits.values())
		{
			for (double i = 0; i < MAX; i += INTERVAL)
			{
				double input = i;
				double output = UnitConverter.convertMassToInternal(input, units);
				assertEquals(input, UnitConverter.convertMassFromInternal(output, units), TOLERANCE);
			}
		}
	}

	@Test
	public void testConvertForceMtoItoM()
	{
		for (ForceUnits units : ForceUnits.values())
		{
			for (double i = 0; i < MAX; i += INTERVAL)
			{
				double input = i;
				double output = UnitConverter.convertForcetoInternal(input, units);
				assertEquals(input, UnitConverter.convertForceFromInternal(output, units), TOLERANCE);
			}
		}
	}

	@Test
	public void testConvertDensityMtoItoM()
	{
		for (DensityUnits units : DensityUnits.values())
		{
			for (double i = 0; i < MAX; i += INTERVAL)
			{
				double input = i;
				double output = UnitConverter.convertDensityToInternal(input, units);
				assertEquals(input, UnitConverter.convertDensityFromInternal(output, units), TOLERANCE);
			}
		}
	}

	@Test
	public void testConvertPressureMtoItoM()
	{
		for (PressureUnits units : PressureUnits.values())
		{
			for (double i = 0; i < MAX; i += INTERVAL)
			{
				double input = i;
				double output = UnitConverter.convertPressureToInternal(input, units);
				assertEquals(input, UnitConverter.convertPressureFromInternal(output, units), TOLERANCE);
			}
		}
	}
	
	@Test
	public void testConvertMassFlowMtoItoM()
	{
		for (MassFlowRateUnits units : MassFlowRateUnits.values())
		{
			for (double i = 0; i < MAX; i += INTERVAL)
			{
				double input = i;
				double output = UnitConverter.convertFlowRateToInternal(input, units);
				assertEquals(input, UnitConverter.convertFlowRateFromInternal(output, units), TOLERANCE);
			}
		}
	}

} // test UnitConverterTest
