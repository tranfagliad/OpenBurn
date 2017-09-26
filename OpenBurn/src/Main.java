/* hold the main method
 * reads input from the user
 * 
 */

import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		int numberOfGrains = -1; //initialize the while loop
		while(numberOfGrains < 1) // guarantees that we have at least one grain
		{
			System.out.print("How many grains do you want? must be atleast 1.  ");
			if(input.hasNextInt() == false)
			{
				System.err.println("\nERROR: Something went wrong with scanner.");
			}
			else
			{
				numberOfGrains = input.nextInt();
			}
		}
		
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
		
		
		
		input.close();
	}
	
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
}
