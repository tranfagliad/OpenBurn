package tests;

import static org.junit.Assert.*;
import org.junit.*;
import model.*;

public class UnitConverterTest
{
	@Test
	public void testConvertLenghtMtoI()
	{
		assertEquals(0.0, UnitConverter.convertLenghtMtoI(0), 0.0000000000000000001);
		assertEquals(1.0, UnitConverter.convertLenghtMtoI(2.54), 0.0000000000000000001);
	}
}