package controller;

import java.util.*;

/* hold the main method
 * reads input from the user
 * 
 */

import model.Grain;
import model.Nozzle;
import model.Result;
import model.RocketMotor;

/**
 * CMDLineInterface.java
 * 
 * This class runs the command-line interface for iteration 1 of OpenBurn.
 * The goal is to be able to run and produce accurate results before the
 * GUI is in place.
**/

public class CMDLineInterface
{
	// Private string constants
	private static final String GRAIN_PROMPT = "Enter number of grains (Must enter at least 1): ";
	
	private static final String NULL_SCANNER_MSG  = "Null scanner for input.\n";
	private static final String SCANNER_ERROR_MSG = "\nERROR: Invalid input.\n";
	
	
	// Error status
	private static final int ERROR_OCCURRED = 1;
	
	
	
	/**
	 * main()
	 * 
	 * Purpose:
	 * 
	 * Parameters:
	 * 		String[] args -- Command-line arguments. Not needed here.
	 * 
	 * Returns: void.
	**/
	
	public static void main (String[] args)
	{
		// Scanner for keyboard input
		Scanner input = new Scanner(System.in);
		
		
		int numberOfGrains = getNumGrains(input);
		
		
		/*
		float density = -1; //initialize the while loop
		while(density <= 0) // guarantees that density makes sense
		{
			System.out.print("What is the propelant density? must be positive.  ");
			if(input.hasNextFloat() == false)
			{
				System.err.println("\nERROR: Something went wrong with scanner.");
			}
			else
			{
				density = input.nextFloat();
			}
		}
		Grain.setPropelentDensity(density);
		
		
		
		
		Grain[] listOfGrains = new Grain[numberOfGrains];
		for(int i = 0; i < listOfGrains.length; i++)
		{
			System.out.println("Grain number: " + i);
			listOfGrains[i] = getCMDinput(input); // ask input for each grain will ask more questions
		}
		
		Nozzle noz = getCMDnizzel(input, numberOfGrains);
		
		float deltaTime = -1;
		while(deltaTime <= 0)
		{
			System.out.print("What time step do you want to use? must be positive.  ");
			if(input.hasNextInt() == false)
			{
				System.err.println("\nERROR: Something went wrong with scanner.");
			}
			else
			{
				deltaTime = input.nextInt();
			}
		}
		
		LinkedList<Result> theResults = RocketMotor.simulate(listOfGrains, deltaTime, noz);
		
		
		// more stuff here eventually
		
		
		*/
		input.close();
	} // main()
	
	
	
	/**
	 * getNumGrains()
	 * 
	 * Purpose: Prompts the user for a number of motor grains, then
	 * 		returns the answer.
	 * 
	 * Arguments:
	 * 		Scanner input -- User input, preferrably keyboard input.
	 * 
	 * Returns: int. The number of grains given by the user.
	**/
	
	private static int getNumGrains (Scanner input)
	{
		// Check for null scanner
		if (input == null)
			throw new IllegalArgumentException(NULL_SCANNER_MSG);
		
		// Prompt the user for input until a positive number or error
		int numberOfGrains = -1;
		while (numberOfGrains < 1)
		{
			System.out.print(GRAIN_PROMPT);   // Prompt message
			
			// Response was not an integer, error
			if (input.hasNextInt() == false)
			{
				System.err.println(SCANNER_ERROR_MSG);
				System.exit(ERROR_OCCURRED);
			}
			
			// Valid input
			else
				numberOfGrains = input.nextInt();
		}
		
		return numberOfGrains;
	} // getNumGrains()
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	private static Nozzle getCMDnizzel(Scanner input, int numberOfGrains)
	{
		
		float throatDiameter = -1;
		float entranceDiameter = -1;
		float exitDiameter = -1;
		float cf = -1;
		
		while(throatDiameter <= 0)
		{
			System.out.print("What is the Nozzle's throat Diameter? must be positive.  ");
			if(input.hasNextInt() == false)
			{
				System.err.println("\nERROR: Something went wrong with scanner.");
			}
			else
			{
				throatDiameter = input.nextInt();
			}
		}
		
		while(entranceDiameter <= 0)
		{
			System.out.print("What is the Nozzle's entrance Diameter? must be positive.  ");
			if(input.hasNextInt() == false)
			{
				System.err.println("\nERROR: Something went wrong with scanner.");
			}
			else
			{
				entranceDiameter = input.nextInt();
			}
		}
		while(exitDiameter <= 0)
		{
			System.out.print("What is the Nozzle's exit Diameter? must be positive.  ");
			if(input.hasNextInt() == false)
			{
				System.err.println("\nERROR: Something went wrong with scanner.");
			}
			else
			{
				exitDiameter = input.nextInt();
			}
		}
		while(cf <= 0)
		{
			System.out.print("What is the Nozzle's cf? must be positive.  ");
			if(input.hasNextInt() == false)
			{
				System.err.println("\nERROR: Something went wrong with scanner.");
			}
			else
			{
				cf = input.nextInt();
			}
		}
		
		return new Nozzle(throatDiameter, entranceDiameter, exitDiameter, cf, numberOfGrains);
	}
	*/
	
	
	/*
	private static Grain getCMDinput(Scanner input)
	{
		float outerDiameter = -1;
		float length = -1; 
		float innerDiameter = -1;
		int burningEnds = -1; 
		
		while(innerDiameter >= outerDiameter)
		{
			outerDiameter = -1;
			innerDiameter = -1;
			while(outerDiameter <= 0)
			{
				System.out.print("What is the outer diameter? must be positive.  ");
				if(input.hasNextFloat() == false)
				{
					System.err.println("\nERROR: Something went wrong with scanner.");
				}
				else
				{
					outerDiameter = input.nextFloat();
				}
			}
			
			while(innerDiameter <= 0)
			{
				System.out.print("What is the inner diameter? must be positive.  ");
				if(input.hasNextFloat() == false)
				{
					System.err.println("\nERROR: Something went wrong with scanner.");
				}
				else
				{
					innerDiameter = input.nextFloat();
				}
			}
		}
		
		while(length <= 0 )
		{
			System.out.print("What is the length? must be positive.  ");
			if(input.hasNextFloat() == false)
			{
				System.err.println("\nERROR: Something went wrong with scanner.");
			}
			else
			{
				length = input.nextFloat();
			}
		}
		
		while(burningEnds < 0 || burningEnds > 2)
		{
			System.out.print("How many burning ends are there? must be positive.  ");
			if(input.hasNextInt() == false)
			{
				System.err.println("\nERROR: Something went wrong with scanner.");
			}
			else
			{
				burningEnds = input.nextInt();
			}
		}
		
		return new Grain(outerDiameter, length, innerDiameter, burningEnds);
//		return Grain.getNewGrain(outerDiameter, length, innerDiameter, burningEnds);
	}
	*/
} // class Main
