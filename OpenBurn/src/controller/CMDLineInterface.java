package controller;

import java.util.*;
import model.*;
import model.calculations.*;
import model.grains.*;
import model.propellant.EmpericalPropellant;
import model.propellant.Propellant;
import view.CSVConverter;
import view.RSEGenerator;

/**
 * CMDLineInterface.java
 * 
 * This class runs the command-line interface for iteration 1 of OpenBurn. The
 * goal is to be able to run and produce accurate results before the GUI is in
 * place.
 **/

public class CMDLineInterface {
	private static final String START_MSG = "OpenBurn: Iteration #1\n";
	private static final String GRAIN_NUM = "\nGrain number: ";
	private static final String SIM_OVER = "\nSimulation Complete";

	private static final String CSV_EXTENSION = ".csv";

	// General prompts
	private static final String GRAIN_PROMPT = "Enter number of grains (Must enter at least 1): ";
	private static final String DENSITY_PROMPT = "Enter propellant density (Must be positive): ";
	private static final String P_SLOPE_PROMPT = "Enter the slope of the pressure vs kn line";
	private static final String P_INTERCEPT_PROMPT = "Enter the intecept of the pressure vs kn line";
	private static final String BR_SLOPE_PROMPT = "Enter the slope of the br vs kn plot";
	private static final String BR_INTERCEPT_PROMPT = "Enter the intercept of the br vs kn plot";
	private static final String FILE_PROMPT = "\nEnter the desired name of the CSV file (Don't include \".csv\"): ";

	// Grain prompts
	private static final String OUTER_DIAMETER_PROMPT = "Enter grain outer diameter (Must be positive): ";
	private static final String INNER_DIAMETER_PROMPT = "Enter grain inner diameter (Must be positive): ";
	private static final String LENGTH_PROMPT = "Enter grain length (Must be positive): ";
	private static final String BURNING_ENDS_PROMPT = "Enter grain number of burning ends (Must be 0, 1, or 2): ";

	// Nozzle prompts
	private static final String THROAT_DIAMETER_PROMPT = "\nEnter nozzle throat diameter (Must be positive): ";
	private static final String ENTRANCE_DIAMETER_PROMPT = "Enter nozzle entrance diameter (Must be positive): ";
	private static final String EXIT_DIAMETER_PROMPT = "Enter nozzle exit diameter (Must be positive): ";
	private static final String CF_PROMPT = "Enter nozzle CF (Must be positive): ";

	// Time Delta prompt
	private static final String TIME_DELTA_PROMPT = "Enter change in time (Must be positive): ";

	// Case Prompts
	private static final String CASE_MASS_PROMPT = "Enter mass of the case (Must be positive): ";
	private static final String CASE_DIAMETER_PROMPT = "Enter diameter of the case (Must be positive): ";
	private static final String CASE_LENGTH_PROMPT = "Enter length of the case (Must be positive): ";

	// Error messages
	private static final String NULL_SCANNER_MSG = "\nERROR: Null scanner for input!\n";
	private static final String INPUT_ERROR_MSG = "\nERROR: Invalid input!\n";

	// Error status
	private static final int ERROR_OCCURRED = 1;

	/**
	 * main()
	 * 
	 * Purpose: Runs the command-line version of OpenBurn for iteration #1.
	 * Continuously prompts the user for data regarding the grains and the
	 * nozzle, then creates objects for both.
	 * 
	 * Finally, simulated results are calculated and displayed to the user.
	 * 
	 * Parameters: String[] args -- Command-line arguments. Not needed here.
	 * 
	 * Returns: void.
	 **/

	public static void main(String[] args) {
		System.out.println(START_MSG);

		// Scanner for keyboard input
		Scanner input = new Scanner(System.in);

		// Prompt user for number of grains
		// Prompt user for propellant density
		int numberOfGrains = promptInt(input, GRAIN_PROMPT);
		double density = promptDouble(input, DENSITY_PROMPT);
		double p_slope = promptDouble(input, P_SLOPE_PROMPT);
		double p_intercept = promptDouble(input, P_INTERCEPT_PROMPT);
		double br_slope = promptDouble(input, BR_SLOPE_PROMPT);
		double br_intercept = promptDouble(input, BR_INTERCEPT_PROMPT);

		Propellant p_model = new EmpericalPropellant(p_slope, p_intercept, br_slope, br_intercept, density);

		// Continuously prompt the user for input and create a list of Grains
		// Current implementation of the list is: LinkedList
		List<Grain> listOfGrains = new LinkedList<Grain>();
		for (int grainNum = 0; grainNum < numberOfGrains; grainNum++) {
			System.out.println(GRAIN_NUM + grainNum);
			listOfGrains.add(createGrain(input));
		}

		// // TEMP fix
		// for (int i = 0; i < listOfGrains.size(); i++){
		// listOfGrains.get(i).setPropellantDensity(density);
		// }

		// Prompt the user for input to create a nozzle
		Nozzle nozzle = createNozzle(input, numberOfGrains);

		// Prompt user for change in time
		double deltaTime = promptDouble(input, TIME_DELTA_PROMPT);

		double caseMass = promptDouble(input, CASE_MASS_PROMPT);
		double caseDiameter = promptDouble(input, CASE_DIAMETER_PROMPT);
		double caseLength = promptDouble(input, CASE_LENGTH_PROMPT);

		Case theCase = new Case(caseMass, caseDiameter, caseLength);

		// Simulate the rocket motor using the given data
		List<SimulationResults> theResults = RocketMath.simulate(listOfGrains, deltaTime, nozzle, theCase, p_model);

		// Prompt for CSV file name to send data
		System.out.println(FILE_PROMPT);
		if (input.hasNext() == false) {
			System.err.println(INPUT_ERROR_MSG);
			System.exit(ERROR_OCCURRED);
		}
		String fileName = input.next() + CSV_EXTENSION;

		//CSVConverter.writeResultsArr(theResults, fileName);

		input.close(); // Close keyboard input

		SimulationSummary summary = new SimulationSummary(theResults);
		System.out.println("\nImpulse " + summary.getImpulse());
		System.out.println("Max pressure " + summary.getmaxPressure());
		System.out.println("Max Thrust " + summary.getMaxThrust());
		System.out.println("Average thrust " + summary.getaverageThrust());
		System.out.format("Burntime %.2f\n", summary.getBurnTime());
		System.out.format("Classification %s\n", summary.getClassification());
		
		new RSEGenerator("UAWR",theResults,theCase,summary,nozzle);
		System.out.println(SIM_OVER);
	} // main()

	/**
	 * promptInt()
	 * 
	 * Purpose: Prompts the user for integer input until a positive number is
	 * entered.
	 * 
	 * Parameters: Scanner input -- Input for data, preferably keyboard input.
	 * String promptMessage -- Prompt message to specify request.
	 * 
	 * Returns: int. A positive integer.
	 **/

	private static int promptInt(Scanner input, String promptMessage) {
		// Check for null scanner
		if (input == null)
			throw new IllegalArgumentException(NULL_SCANNER_MSG);

		// Prompt the user for input until a positive number or error
		int desiredInt = -1;
		while (desiredInt < 1) {
			System.out.print(promptMessage);

			// Response was not an integer, error
			if (input.hasNextInt() == false) {
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
	 * Purpose: Prompts the user for double input until a positive number is
	 * entered.
	 * 
	 * Parameters: Scanner input -- Input for data, preferably keyboard input.
	 * String promptMessage -- Prompt message to specify request.
	 * 
	 * Returns: double. A positive double.
	 **/

	private static double promptDouble(Scanner input, String promptMessage) {
		// Check for null scanner
		if (input == null)
			throw new IllegalArgumentException(NULL_SCANNER_MSG);

		double desiredDouble = 0;
		;
		System.out.print(promptMessage);

		// Response was not a double, error
		if (input.hasNextDouble() == false) {
			System.err.println(INPUT_ERROR_MSG);
			System.exit(ERROR_OCCURRED);
		}

		// Valid input
		else
			desiredDouble = input.nextDouble();

		return desiredDouble;
	} // promptDouble()

	/**
	 * promptBurningEnds()
	 * 
	 * Purpose: Special case prompting method that prompts the user to enter a
	 * number of burning ends. The only acceptable answers are 0, 1, or 2.
	 * 
	 * Parameters: Scanner input -- Input for data, preferably keyboard input.
	 * 
	 * Returns: int. 0, 1, or 2.
	 **/

	private static int promptBurningEnds(Scanner input) {
		// Check for null scanner
		if (input == null)
			throw new IllegalArgumentException(NULL_SCANNER_MSG);

		// Prompt the user for input until 0, 1, 2, or error
		int desiredInt = -1;
		while (desiredInt < 0 || desiredInt > 2) {
			System.out.print(BURNING_ENDS_PROMPT);

			// Response was not an integer, error
			if (input.hasNextInt() == false) {
				System.err.println(INPUT_ERROR_MSG);
				System.exit(ERROR_OCCURRED);
			}

			// Valid input
			else
				desiredInt = input.nextInt();
		}

		return desiredInt;
	} // promptBurningEnds()

	/**
	 * createGrain()
	 * 
	 * Purpose: Creates and returns a Grain object by prompting the user for
	 * input. It is recommended that the input is given by keyboard.
	 * 
	 * Parameters: Scanner input -- User input, preferably keyboard input.
	 * 
	 * Returns: Grain. A new Grain object with data from user input.
	 **/

	private static Grain createGrain(Scanner input) {
		// Initialize all dimensions for loops
		double outerDiameter = -1.0;
		double innerDiameter = -1.0;

		// Prompt the user for inner and outer diameters until the outer
		// diameter is greater than the inner diameter.
		while (innerDiameter >= outerDiameter) {
			outerDiameter = promptDouble(input, OUTER_DIAMETER_PROMPT);
			innerDiameter = promptDouble(input, INNER_DIAMETER_PROMPT);
		}

		// Prompt user for a length
		double length = promptDouble(input, LENGTH_PROMPT);

		// Prompt user for the number of burning ends
		// Allow 0, 1, or 2
		int numBurningEnds = promptBurningEnds(input);

		// Use new data to create and return a Grain
		return (new CylindricalGrain(length, outerDiameter, innerDiameter, numBurningEnds));
	} // createGrain()

	/**
	 * createNozzle()
	 * 
	 * Purpose: Creates and returns a Nozzle object by prompting the user for
	 * input. It is recommended that the input is given by keyboard.
	 * 
	 * Parameters: Scanner input -- User input, preferably keyboard input.
	 * 
	 * Returns: Nozzle. A new Nozzle object with data from user input.
	 **/

	private static Nozzle createNozzle(Scanner input, int numberOfGrains) {
		// Prompt user for throat diameter, entrance diameter, exit diameter,
		// and cf
		double throatDiameter = promptDouble(input, THROAT_DIAMETER_PROMPT);
		double entranceDiameter = promptDouble(input, ENTRANCE_DIAMETER_PROMPT);
		double exitDiameter = promptDouble(input, EXIT_DIAMETER_PROMPT);
		double cf = promptDouble(input, CF_PROMPT);

		// Use new data to create and return a Nozzle
		return (new Nozzle(throatDiameter, entranceDiameter, exitDiameter, cf, numberOfGrains));
	} // createNozzle()

} // class CMDLineInterface
