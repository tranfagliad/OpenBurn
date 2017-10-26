package model.calculations;

import java.util.*;

import model.*;
import model.grains.*;

/**
 * RocketMath.java
 * 
 * Contains methods to calculate simulation results for rocket motor
 * burning over time.
**/

public class RocketMath
{
	/**
	 * simulate()
	 * 
	 * Purpose: Takes a collection of grains and a nozzle for a rocket motor, and produces
	 * 		a set of simulation results. The results differ by the change in time given
	 * 		at every step.
	 * 
	 * Parameters:
	 * 		List<Grain> grainList -- List of grains in the rocket motor for the simulation.
	 * 		double deltaTime -- How much time will change at every step in the simulation.
	 * 		Nozzle theNozzle -- Nozzle of the rocket motor for the simulation.
	 * 
	 * Returns: List<SimulationResults>. A list of results from the burn simulation.
	**/
	
	public static List<SimulationResults> simulate (List<Grain> grainList, double deltaTime, Nozzle theNozzle, Case theCase)
	{
		// Initialize a list for results, and the time at zero
		List<SimulationResults> output = new LinkedList<SimulationResults>();
		double currentTime = 0;
		
		// Begin simulation loop
		boolean simRunning = true;
		while (simRunning)
		{
			// Update time
			currentTime += deltaTime;
			
			// Set up a set of results and enter in the updated time.
			SimulationResults currentTimeStep = new SimulationResults();
			currentTimeStep.setTime(currentTime);
			
			// Parts 1 through 8 in matlab file
			generateGeometry(grainList, currentTimeStep, theNozzle);
			regressGrains(grainList, currentTimeStep, deltaTime);
			double[] massFlow = generateMassFlow(grainList, currentTimeStep);
			portToThroatRatio(grainList, currentTimeStep, theNozzle);
			calculateMassFlowPerArea(grainList, currentTimeStep, massFlow, theNozzle);
			calculateLStar(grainList, currentTimeStep, theNozzle);
			massAndCenterOfGravity(grainList, currentTimeStep, theCase);
			calculateBurnout(grainList, currentTime);
			
			// Add final results to the result set
			output.add(currentTimeStep);

			simRunning = false;
			for (int i = 0; i < grainList.size(); i++)
				simRunning |= grainList.get(i).isBurning();
		} // End simulation loop
		
		return output;
	} // simulate()
	
	
	
	/**
	 * generateGeometry()
	 * 
	 * Purpose: Generates and saves geometry based data, including
	 * 		Kn, burn area, chamber pressure, and burn rate. Based on
	 * 		Part 1 of the matlab file motor_internal_balistics.m.
	 * 
	 * Parameters:
	 * 		List<Grain> theGrains -- List of grains for the motor.
	 * 		SimulationResults currentResult -- Result from a simulation.
	 * 		Nozzle theNozzle -- Nozzle of the rocket from the simulation.
	 * 
	 * Returns: void.
	**/
	
	public static void generateGeometry (List<Grain> theGrains, SimulationResults currentResult, Nozzle theNozzle)
	{
		// Gather the total burn area
		double motorAvailableArea = 0;
		for(Grain oneGrain: theGrains)
			motorAvailableArea += oneGrain.getBurnArea();
		
		// Calculate geometry based field values
		double currentKn = motorAvailableArea / theNozzle.getThroatArea();
		double currentPressure = pressureFromKn(currentKn);
		double currentBurnRate = burnRateFromKn(currentKn);
		
		// Set all geometry based fields
		currentResult.setKn(currentKn);
		currentResult.setBurnArea(motorAvailableArea);
		currentResult.setChamberPressure(currentPressure);
		currentResult.setBurnRate(currentBurnRate);
	} // generateGeometry()
	
	
	
	/**
	 * regressGrains()
	 * 
	 * Purpose: Regress grains to calculate and set mass flow generated
	 * 		per grain and overall. Updates the the simulation state.
	 * 		Based on Part 2 of the matlab file motor_internal_balistics.m.
	 * 
	 * Parameters:
	 * 		List<Grain> theGrains -- List of grains during a simulation.
	 * 		SimulationResults current -- Current results during a simulation.
	 * 		double deltaTime -- Change in time increment during a simulation.
	 * 
	 * Returns: void.
	**/
	
	public static void regressGrains (List<Grain> theGrains, SimulationResults current, double deltaTime)
	{
		double massGenerated[] = new double[theGrains.size()];
		double overallGenerated = 0;
		
		// Go through each grain
		for(int i = 0; i < theGrains.size(); i++)
		{
			double volumeChange = theGrains.get(i).updateGeometry(current.getBurnRate(), deltaTime);
			massGenerated[i] = volumeChange * theGrains.get(i).getPropellantDensity();
			overallGenerated += massGenerated[i];
		}
		
		// Set mass generated overall and per grain
		current.setMassGeneratedOverall(overallGenerated);
		current.setMassGeneratedPerGrain(massGenerated);
	} // regressGrains()
	
	
	
	/**
	 * generateMassFlow()
	 * 
	 * Purpose: Calculates and returns the mass flow for every grain
	 * 		in a simulation. Based on Part 3 of the matlab file
	 * 		motor_internal_balistics.m.
	 * 
	 * Parameters:
	 * 		List<Grain> theGrains -- List of grains in a simulation.
	 * 		SimulationResults current -- Current result in the simulation.
	 * 
	 * Returns: double[]. The mass flow for each grain.
	**/
	
	public static double[] generateMassFlow (List<Grain> theGrains, SimulationResults current)
	{
		// Initialize empty array
		double massFlow[] = new double[theGrains.size()];
		
		// Go through every grain in the simulation
		for (int i = 0; i < theGrains.size(); i++)
		{
			if (i == 0)
				massFlow[i] = current.getMassGeneratedPerGrain()[i];
			else
				massFlow[i] = massFlow[i-1] + current.getMassGeneratedPerGrain()[i];
		}
		
		return massFlow;
	} // generateMassFlow()
	
	
	
	/**
	 * portToThroatRatio()
	 * 
	 * Purpose: Calculates and sets the port to throat ratio. Based on
	 * 		Part 4 of the matlab file motor_internal_balistics.m.
	 * 
	 * Parameters:
	 * 		List<Grain> theGrains -- List of grains during a simulation.
	 * 		SimulationResults current -- Current results for a simulation.
	 * 		Nozzle theNozzle -- Nozzle for a ricket during a simulation.
	 * 
	 * Returns: void. 
	**/
	
	public static void portToThroatRatio (List<Grain> theGrains, SimulationResults current, Nozzle theNozzle)
	{
		/*
		 * TODO: 
		 * Remove cylindrical grain geometry
		 */
		double portToThroat[] = new double[theGrains.size()];
		
		for (int i =  0; i < theGrains.size(); i++)
		{
			if (i < theGrains.size() - 1)
				portToThroat[i] = theGrains.get(i).getCurrentInnerFlowArea()/theGrains.get(i+1).getCurrentInnerFlowArea();
			else
				portToThroat[i] = theGrains.get(i).getCurrentInnerFlowArea()/theNozzle.getThroatArea();
		}
		
		current.setPortToThroat(portToThroat);
	} // portToThroatRatio()
	
	
	
	/**
	 * calculateMassFlowPerArea()
	 * 
	 * Purpose: Calculates the mass flow over area at various locations in
	 * 		the motor during a simulation. Based on Part 5 of the matlab
	 * 		file motor_internal_balistics.m.
	 * 
	 * Parameters:
	 * 		List<Grain> theGrains -- List of grains during a simulation.
	 * 		SimulationResults current -- Current results for a simulation.
	 * 		double[] massFlow -- Mass flow for each grain.
	 * 		Nozzle theNozzle -- Nozzle for a ricket during a simulation.
	 * 
	 * Returns: void.
	**/
	
	public static void calculateMassFlowPerArea (List<Grain> theGrains, SimulationResults current, double[] massFlow, Nozzle theNozzle)
	{
		double massFlowPerArea[] = new double[theGrains.size() + 2];
		
		// Go through each grain
		for (int i = 0; i < theGrains.size(); i++)
			massFlowPerArea[i] = massFlow[i]/theGrains.get(i).getCurrentInnerFlowArea();
		
		massFlowPerArea[massFlowPerArea.length - 2] = massFlow[massFlow.length-1] / theNozzle.getEntranceArea();
		massFlowPerArea[massFlowPerArea.length - 1] = massFlow[massFlow.length-1] / theNozzle.getThroatArea();
		
		// Set the mass flow per area grain
		current.setMassFlowPerAreaGrain(massFlowPerArea);
	} // calculateMoreMassFlow()
	
	
	
	/**
	 * calculateLStar()
	 * 
	 * Purpose: Calculate and set the L* at the current point during
	 * 		a simulation. Based on Part 6 in motor_internal_balistics.m.
	 * 
	 * Parameters:
	 * 		List<Grain> theGrains -- List of grains during a simulation.
	 * 		SimulationResults current -- Current results for a simulation.
	 * 		Nozzle theNozzle -- Nozzle for a ricket during a simulation.
	 * 
	 * Returns: void.
	**/
	
	public static void calculateLStar (List<Grain> theGrains, SimulationResults current, Nozzle theNozzle)
	{
		double currentFreeVolume = 0.0;
		double currentFreeLength = 0.0;
		
		// Go through each grain
		for(int i = 0; i < theGrains.size(); i++)
		{
			currentFreeVolume += theGrains.get(i).getCurrentInnerFlowVolume();
			currentFreeLength += theGrains.get(i).getLengthDifference();
		}
		
		// Calculate L*
		currentFreeVolume += Math.PI * Math.pow(theGrains.get(0).getOuterDiameter()/2, 2) * currentFreeLength;
		double lstar = currentFreeVolume / theNozzle.getThroatArea();
		
		// Set L*
		current.setLStar(lstar);
	} // calculateLStar()
	
	
	
	/**
	 * massAndCenterOfGravity()
	 * 
	 * Purpose: Calculates and sets the current mass and center of gravity
	 * 		for rocksim. Based on Part 7 of the matlab file
	 * 		motor_internal_balistics.m.
	 * 
	 * Parameters:
	 * 		List<Grain> theGrains -- List of grains during the simulation.
	 * 		SimulationResults current -- Current results during a simulation.
	 * 
	 * Returns: void.
	**/
	
	public static void massAndCenterOfGravity (List<Grain> theGrains, SimulationResults current, Case theCase)
	{
		double grainMass = 0;
		double grainCg = 0;
		for(int i = 0; i < theGrains.size(); i++)
		{
			Grain aGrain = theGrains.get(i);
			grainMass += aGrain.getVolume() * aGrain.getPropellantDensity(); //line 166 in matlab
			double centerpoint = (aGrain.getLength() * i) - (aGrain.getLength()/2); //line 38 in matLab
			centerpoint += 1.9685; //line 41 in matlab.  TODO: make a variable, based off nozzle length?
			grainCg += grainMass * centerpoint; //line 224 in matlab
		}
		double systemMass = grainMass + theCase.getCaseMass();
		current.setSystemMass(systemMass);
		current.setSystemCenterOfGravity(grainCg / systemMass);
	} // massAndCenterOfGravity()
	
	
	
	/**
	 * calculateBurnout()
	 * 
	 * Purpose: Calculates the burnout with the list of grains and time for
	 * 		a simulation. Based on the matlab file motor_internal_balistics.m.
	 * 
	 * Parameters:
	 * 		List<Grain> theGrains -- List of grains in the simulation.
	 * 		double currentTime -- Current time in the simulation.
	 * 
	 * Returns: void.
	**/
	
	public static void calculateBurnout (List<Grain> theGrains, double currentTime)
	{
		// Go through all grains
		for (int i = 0; i < theGrains.size(); i++)
		{
			// Sets the burnout time for each grain
			if (!(theGrains.get(i).isBurning()) && theGrains.get(i).getBurnoutTime() == 0.0)
				theGrains.get(i).setBurnoutTime(currentTime);
		}
	} // calculateBurnout()
	
	
	
	/**
	 * pressureFromKn (double kn)
	 * 
	 * Purpose: Converts Kn to pressure. Based on the matlab file
	 * 		motor_internal_balistics.m and Pc_via_kn.
	 * 
	 * Parameters:
	 * 		double kn -- Ratio of the burn area of the propellant
	 * 			to the area of the nozzle throat.
	 * 
	 * Returns: double. Pressure, converted from Kn.
	**/
	
	public static double pressureFromKn (double kn)
	{
		return ((double)(2.725060 * kn - 236.099212));
	} // pressureFromKn()
	
	
	
	/**
	 * burnRateFromKn()
	 * 
	 * Purpose: Converts Kn to burn rate. Based on the matlab file
	 * 		motor_internal_balistics.m and Br_via_kn.
	 * 
	 * Parameters:
	 * 		double kn -- Ratio of the burn area of the propellant
	 * 			to the area of the nozzle throat.
	 * 
	 * Returns: double. Burn rate, converted from Kn.
	**/
	
	public static double burnRateFromKn (double kn)
	{
		return ((double)((0.000366 * kn) + 0.083967));
	} // burnRateFromKn()
	
} // class RocketMath
