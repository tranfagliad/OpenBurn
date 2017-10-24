package controller;

import java.util.*;
import model.*;

/**
 * CMDLineInterface.java
 * 
 * This class runs the command-line interface for iteration 1 of OpenBurn.
 * The goal is to be able to run and produce accurate results before the
 * GUI is in place.
**/

public class CMDLineInterface
{
	private static final String START_MSG = "OpenBurn: Iteration #1\n";
	private static final String GRAIN_NUM = "Grain number: ";
	
	// General prompts
	private static final String GRAIN_PROMPT   = "Enter number of grains (Must enter at least 1): ";
	private static final String DENSITY_PROMPT = "Enter propellant density (Must be positive): ";
	private static final String FILE_PROMPT    = "Enter the desired name of the CSV file.  (don't include \".csv\")";
	
	// Grain prompts
	private static final String OUTER_DIAMETER_PROMPT = "Enter grain outer diameter (Must be positive): ";
	private static final String INNER_DIAMETER_PROMPT = "Enter grain inner diameter (Must be positive): ";
	private static final String LENGTH_PROMPT         = "Enter grain length (Must be positive): ";
	private static final String BURNING_ENDS_PROMPT   = "Enter grain number of burning ends (Must be 0, 1, or 2): ";
	
	// Nozzle prompts
	private static final String THROAT_DIAMETER_PROMPT   = "Enter nozzle throat diameter (Must be positive): ";
	private static final String ENTRANCE_DIAMETER_PROMPT = "Enter nozzle entrance diameter (Must be positive): ";
	private static final String EXIT_DIAMETER_PROMPT     = "Enter nozzle exit diameter (Must be positive): ";
	private static final String CF_PROMPT                = "Enter nozzle CF (Must be positive): ";
	
	// Time Delta prompt
	private static final String TIME_DELTA_PROMPT = "Enter change in time (Must be positive): ";
	
	// Error messages
	private static final String NULL_SCANNER_MSG = "\nERROR: Null scanner for input!\n";
	private static final String INPUT_ERROR_MSG  = "\nERROR: Invalid input!\n";
	
	// Error status
	private static final int ERROR_OCCURRED = 1;
	
	
	
	/**
	 * main()
	 * 
	 * Purpose: Runs the command-line version of OpenBurn for iteration #1.
	 * 		Continuously prompts the user for data regarding the grains
	 * 		and the nozzle, then creates objects for both.
	 * 
	 * 		Finally, simulated results are calculated and displayed to
	 * 		the user.
	 * 		
	 * Parameters:
	 * 		String[] args -- Command-line arguments. Not needed here.
	 * 
	 * Returns: void.
	**/
	
	public static void main (String[] args)
	{
		System.out.println(START_MSG);
		
		// Scanner for keyboard input
		Scanner input = new Scanner(System.in);
		
		// Prompt user for number of grains
		// Prompt user for propellant density
		int numberOfGrains = promptInt(input, GRAIN_PROMPT);
		double density = promptDouble(input, DENSITY_PROMPT);
		Grain.setPropellantDensity(density);
		
		// Continuously prompt the user for input and create a list of Grains
		// Current implementation of the list is: LinkedList
		List<Grain> listOfGrains = new LinkedList<Grain>();
		for (int grainNum = 0; grainNum < numberOfGrains; grainNum++)
		{
			System.out.println(GRAIN_NUM + grainNum);
			listOfGrains.add(createGrain(input));
		}
		
		// Prompt the user for input to create a nozzle
		Nozzle nozzle = createNozzle(input, numberOfGrains);
		
		// Prompt user for change in time
		double deltaTime = promptDouble(input, TIME_DELTA_PROMPT);
		
		List<SimulationResults> theResults = RocketMath.simulate(listOfGrains, deltaTime, nozzle);
		
		System.out.println(FILE_PROMPT);
		if (input.hasNext() == false)
		{
			System.err.println(INPUT_ERROR_MSG);
			System.exit(ERROR_OCCURRED);
		}
		String fileName = input.next() + ".csv";
		
		CSVConverter.writeObjArr(theResults, fileName);
		
		input.close();   // Close keyboard input
	} // main()
	
	
	
	/**
	 * promptInt()
	 * 
	 * Purpose: Prompts the user for integer input until a positive number
	 * 		is entered.
	 * 
	 * Parameters:
	 * 		Scanner input -- Input for data, preferably keyboard input.
	 * 		String promptMessage -- Prompt message to specify request.
	 * 
	 * Returns: int. A positive integer.
	**/
	
	private static int promptInt (Scanner input, String promptMessage)
	{
		// Check for null scanner
		if (input == null)
			throw new IllegalArgumentException(NULL_SCANNER_MSG);
		
		// Prompt the user for input until a positive number or error
		int desiredInt = -1;
		while (desiredInt < 1)
		{
			System.out.print(promptMessage);
			
			// Response was not an integer, error
			if (input.hasNextInt() == false)
			{
				System.err.println(INPUT_ERROR_MSG);
				System.exit(ERROR_OCCURRED);
			}
			
			// Valid input
			else
				desiredInt = input.nextInt();
		}
		
		return desiredInt;
	} // promptInt()
	
	
	
	/**
	 * promptDouble()
	 * 
	 * Purpose: Prompts the user for double input until a positive number
	 * 		is entered.
	 * 
	 * Parameters:
	 * 		Scanner input -- Input for data, preferably keyboard input.
	 * 		String promptMessage -- Prompt message to specify request.
	 * 
	 * Returns: double. A positive double.
	**/
	
	private static double promptDouble (Scanner input, String promptMessage)
	{
		// Check for null scanner
		if (input == null)
			throw new IllegalArgumentException(NULL_SCANNER_MSG);
		
		// Prompt the user for input until a positive number or error
		double desiredDouble = -1.0;
		while (desiredDouble <= 0.0)
		{
			System.out.print(promptMessage);
			
			// Response was not a double, error
			if (input.hasNextDouble() == false)
			{
				System.err.println(INPUT_ERROR_MSG);
				System.exit(ERROR_OCCURRED);
			}
			
			// Valid input
			else
				desiredDouble = input.nextDouble();
		}
		
		return desiredDouble;
	} // promptDouble()
	
	
	
	/**
	 * createGrain()
	 * 
	 * Purpose: Creates and returns a Grain object by prompting the
	 * 		user for input. It is recommended that the input is
	 * 		given by keyboard.
	 * 
	 * Parameters:
	 * 		Scanner input -- User input, preferably keyboard input.
	 * 
	 * Returns: Grain. A new Grain object with data from user input.
	**/
	
	private static Grain createGrain (Scanner input)
	{
		// Initialize all dimensions for loops
		double outerDiameter = -1.0;
		double innerDiameter = -1.0;
		
		// Prompt the user for inner and outer diameters until the outer
		// diameter is greater than the inner diameter.
		while (innerDiameter >= outerDiameter)
		{
			outerDiameter = promptDouble(input, OUTER_DIAMETER_PROMPT);
			innerDiameter = promptDouble(input, INNER_DIAMETER_PROMPT);
		}
		
		// Prompt user for a length
		double length = promptDouble(input, LENGTH_PROMPT);
		
		// Prompt user for the number of burning ends
		int numBurningEnds = promptInt(input, BURNING_ENDS_PROMPT);
		
		// Use new data to create and return a Grain
		return (new Grain(length, outerDiameter, innerDiameter, numBurningEnds));
	} // createGrain()
	
	
	
	/**
	 * createNozzle()
	 * 
	 * Purpose: Creates and returns a Nozzle object by prompting the
	 * 		user for input. It is recommended that the input is
	 * 		given by keyboard.
	 * 
	 * Parameters:
	 * 		Scanner input -- User input, preferably keyboard input.
	 * 
	 * Returns: Nozzle. A new Nozzle object with data from user input.
	**/
	
	private static Nozzle createNozzle (Scanner input, int numberOfGrains)
	{
		// Prompt user for throat diameter, entrance diameter, exit diameter, and cf
		double throatDiameter   = promptDouble(input, THROAT_DIAMETER_PROMPT);
		double entranceDiameter = promptDouble(input, ENTRANCE_DIAMETER_PROMPT);
		double exitDiameter     = promptDouble(input, EXIT_DIAMETER_PROMPT);
		double cf               = promptDouble(input, CF_PROMPT);
		
		// Use new data to create and return a Nozzle
		return (new Nozzle(throatDiameter, entranceDiameter, exitDiameter, cf, numberOfGrains));
	} // createNozzle()
	
} // class CMDLineInterface
