package tests;

import static org.junit.Assert.*;
import org.junit.*;
import model.*;

public class UnitConverterTest
{
	private final double tolerance = 0.01;
	
	@Test
	public void testConvertLenghtMtoI()
	{
		assertEquals(0.0, UnitConverter.convertLenghtMtoI(0), tolerance);
		assertEquals(0.393701, UnitConverter.convertLenghtMtoI(1), tolerance);
		assertEquals(1.0, UnitConverter.convertLenghtMtoI(2.54), tolerance);
	}
	
	@Test
	public void testConvertLenghtItoM()
	{
		assertEquals(0.0, UnitConverter.convertLenghtItoM(0), tolerance);
		assertEquals(1.0, UnitConverter.convertLenghtItoM(0.393701), tolerance);
		assertEquals(2.54, UnitConverter.convertLenghtItoM(1.0), tolerance);
	}
	
	@Test
	public void testConvertMassMtoI()
	{
		assertEquals(0.0, UnitConverter.convertMassMtoI(0), tolerance);
		assertEquals(0.00220462, UnitConverter.convertMassMtoI(1), tolerance);
		assertEquals(1.0, UnitConverter.convertMassMtoI(453.592), tolerance);
	}
	
	@Test
	public void testConvertMassItoM()
	{
		assertEquals(0.0, UnitConverter.convertMassItoM(0), tolerance);
		assertEquals(453.592, UnitConverter.convertMassItoM(1), tolerance);
		assertEquals(1, UnitConverter.convertMassItoM(0.00220462), tolerance);
	}
	
	@Test
	public void testConvertForceMtoI()
	{
		assertEquals(0.0, UnitConverter.convertForceMtoI(0), tolerance);
		assertEquals(0.224809, UnitConverter.convertForceMtoI(1), tolerance);
		assertEquals(1, UnitConverter.convertForceMtoI(4.44822), tolerance);
	}
	
	@Test
	public void testConvertForceItoM()
	{
		assertEquals(0.0, UnitConverter.convertForceItoM(0), tolerance);
		assertEquals(1, UnitConverter.convertForceItoM(0.224809), tolerance);
		assertEquals(4.44822, UnitConverter.convertForceItoM(1), tolerance);
	}
	
	@Test
	public void testConvertDensityMtoI()
	{
		assertEquals(0.0, UnitConverter.convertDensityMtoI(0), tolerance);
		assertEquals(1, UnitConverter.convertDensityMtoI(27.6799), tolerance);
		assertEquals(0.0361273, UnitConverter.convertDensityMtoI(1), tolerance);
	}
	
	@Test
	public void testConvertDensityItoM()
	{
		assertEquals(0.0, UnitConverter.convertDensityItoM(0), tolerance);
		assertEquals(27.6799, UnitConverter.convertDensityItoM(1), tolerance);
		assertEquals(1, UnitConverter.convertDensityItoM(0.0361273), tolerance);
	}
	
	@Test
	public void testConvertAreaMtoI()
	{
		assertEquals(0.0, UnitConverter.convertAreaMtoI(0), tolerance);
		assertEquals(1, UnitConverter.convertAreaMtoI(6.4516), tolerance);
		assertEquals(0.155, UnitConverter.convertAreaMtoI(1), tolerance);
	}
	
	@Test
	public void testConvertAreaItoM()
	{
		assertEquals(0.0, UnitConverter.convertAreaItoM(0), tolerance);
		assertEquals(6.4516, UnitConverter.convertAreaItoM(1), tolerance);
		assertEquals(1, UnitConverter.convertAreaItoM(0.155), tolerance);
	}
	
	@Test
	public void testConvertPressureMtoI()
	{
		assertEquals(0.0, UnitConverter.convertPressureMtoI(0), tolerance);
		assertEquals(1, UnitConverter.convertPressureMtoI(6894.76), tolerance);
		assertEquals(0.000145038, UnitConverter.convertPressureMtoI(1), tolerance);
	}
	
	@Test
	public void testConvertPressureItoM()
	{
		assertEquals(0.0, UnitConverter.convertPressureItoM(0), tolerance);
		assertEquals(6894.74, UnitConverter.convertPressureItoM(1), tolerance);
		assertEquals(1, UnitConverter.convertPressureItoM(0.000145038), tolerance);
	}
}
