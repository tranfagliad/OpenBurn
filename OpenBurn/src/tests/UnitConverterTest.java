package tests;

import static org.junit.Assert.*;
import org.junit.*;
import model.*;

/**
 * UnitConverterTest.java
 * 
 * Purpose: Contains unit testing for UnitConverter.
**/

public class UnitConverterTest
{
	// Tolerance constant for double testing
	private static final double TOLERANCE = 0.01;
	
	
	
	@Test
	public void testConvertLenghtMtoI ()
	{
		assertEquals(0.0, UnitConverter.convertLengthMtoI(0), TOLERANCE);
		assertEquals(0.393701, UnitConverter.convertLengthMtoI(1), TOLERANCE);
		assertEquals(1.0, UnitConverter.convertLengthMtoI(2.54), TOLERANCE);
	} // testConvertLenghtMtoI()
	
	
	
	@Test
	public void testConvertLenghtItoM ()
	{
		assertEquals(0.0, UnitConverter.convertLengthItoM(0), TOLERANCE);
		assertEquals(1.0, UnitConverter.convertLengthItoM(0.393701), TOLERANCE);
		assertEquals(2.54, UnitConverter.convertLengthItoM(1.0), TOLERANCE);
	} // testConvertLenghtItoM()
	
	
	
	@Test
	public void testConvertMassMtoI ()
	{
		assertEquals(0.0, UnitConverter.convertMassMtoI(0), TOLERANCE);
		assertEquals(0.00220462, UnitConverter.convertMassMtoI(1), TOLERANCE);
		assertEquals(1.0, UnitConverter.convertMassMtoI(453.592), TOLERANCE);
	} // testConvertMassMtoI()
	
	
	
	@Test
	public void testConvertMassItoM ()
	{
		assertEquals(0.0, UnitConverter.convertMassItoM(0), TOLERANCE);
		assertEquals(453.592, UnitConverter.convertMassItoM(1), TOLERANCE);
		assertEquals(1, UnitConverter.convertMassItoM(0.00220462), TOLERANCE);
	} // testConvertMassItoM()
	
	
	
	@Test
	public void testConvertForceMtoI ()
	{
		assertEquals(0.0, UnitConverter.convertForceMtoI(0), TOLERANCE);
		assertEquals(0.224809, UnitConverter.convertForceMtoI(1), TOLERANCE);
		assertEquals(1, UnitConverter.convertForceMtoI(4.44822), TOLERANCE);
	} // testConvertForceMtoI()
	
	
	
	@Test
	public void testConvertForceItoM ()
	{
		assertEquals(0.0, UnitConverter.convertForceItoM(0), TOLERANCE);
		assertEquals(1, UnitConverter.convertForceItoM(0.224809), TOLERANCE);
		assertEquals(4.44822, UnitConverter.convertForceItoM(1), TOLERANCE);
	} // testConvertForceItoM()
	
	
	
	@Test
	public void testConvertDensityMtoI ()
	{
		assertEquals(0.0, UnitConverter.convertDensityMtoI(0), TOLERANCE);
		assertEquals(1, UnitConverter.convertDensityMtoI(27.6799), TOLERANCE);
		assertEquals(0.0361273, UnitConverter.convertDensityMtoI(1), TOLERANCE);
	} // testConvertDensityMtoI()
	
	
	
	@Test
	public void testConvertDensityItoM ()
	{
		assertEquals(0.0, UnitConverter.convertDensityItoM(0), TOLERANCE);
		assertEquals(27.6799, UnitConverter.convertDensityItoM(1), TOLERANCE);
		assertEquals(1, UnitConverter.convertDensityItoM(0.0361273), TOLERANCE);
	} // testConvertDensityItoM()
	
	
	
	@Test
	public void testConvertAreaMtoI ()
	{
		assertEquals(0.0, UnitConverter.convertAreaMtoI(0), TOLERANCE);
		assertEquals(1, UnitConverter.convertAreaMtoI(6.4516), TOLERANCE);
		assertEquals(0.155, UnitConverter.convertAreaMtoI(1), TOLERANCE);
	} // testConvertAreaMtoI()
	
	
	
	@Test
	public void testConvertAreaItoM ()
	{
		assertEquals(0.0, UnitConverter.convertAreaItoM(0), TOLERANCE);
		assertEquals(6.4516, UnitConverter.convertAreaItoM(1), TOLERANCE);
		assertEquals(1, UnitConverter.convertAreaItoM(0.155), TOLERANCE);
	} // testConvertAreaItoM()
	
	
	
	@Test
	public void testConvertPressureMtoI ()
	{
		assertEquals(0.0, UnitConverter.convertPressureMtoI(0), TOLERANCE);
		assertEquals(1, UnitConverter.convertPressureMtoI(6894.76), TOLERANCE);
		assertEquals(0.000145038, UnitConverter.convertPressureMtoI(1), TOLERANCE);
	} //testConvertPressureMtoI()
	
	
	
	@Test
	public void testConvertPressureItoM ()
	{
		assertEquals(0.0, UnitConverter.convertPressureItoM(0), TOLERANCE);
		assertEquals(6894.74, UnitConverter.convertPressureItoM(1), TOLERANCE);
		assertEquals(1, UnitConverter.convertPressureItoM(0.000145038), TOLERANCE);
	} // testConvertPressureItoM()
	
} // test UnitConverterTest
