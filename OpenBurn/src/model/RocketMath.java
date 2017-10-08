package model;

import java.util.LinkedList;
import java.util.List;

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
	
	public static List<SimulationResults> simulate (List<Grain> grainList, double deltaTime, Nozzle theNozzle)
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
			calculateMassFlowPerArea(grainList, currentTimeStep, massFlow);
			calculateLStar(grainList, currentTimeStep, theNozzle);
			massAndCenterOfGravity(grainList, currentTimeStep);
			calculateBurnout(grainList, currentTime);
			
			// Add final results to the result set
			output.add(currentTimeStep);

			simRunning = false;
			for (int i = 0; i < grainList.size(); i++){
				simRunning |= grainList.get(i).isBurning();
			}
		} // End simulation loop
		
		return output;
	} // simulate()
	
	
	
	// Generate and save current geometry based data
	// based off of Part 1 in motor_internal_balistics.m
	public static void generateGeometry (List<Grain> theGrains, SimulationResults currentResult, Nozzle theNozzle)
	{
		double motorAvailabeArea = 0;
		for(Grain oneGrain: theGrains)
			motorAvailabeArea += oneGrain.getBurnArea();
		
		double currentKn = motorAvailabeArea / theNozzle.getThroatArea();
		double currentPressure = pressureFromKn(currentKn);
		double currentBurnRate = burnRateFromKn(currentKn);
		currentResult.setBurnArea(motorAvailabeArea);
		currentResult.setChamberPressure(currentPressure);
		currentResult.setBurnRate(currentBurnRate);
	} // generateGeometry()
	
	
	
	// Regress grains and calculate the mass flow. Save said data and update the sim state
	// based off of Part 2 in motor_internal_balistics.m
	public static void regressGrains (List<Grain> theGrains, SimulationResults current, double deltaTime)
	{
		double massGenerated[] = new double[theGrains.size()];
		for(int i = 0; i < theGrains.size(); i++)
		{
			double volumeChange = theGrains.get(i).updateGeometry(current.getBurnRate(), deltaTime);
			massGenerated[i] = volumeChange * theGrains.get(i).getPropellantDensity();
		}
		current.setMassGeneratedPerGrain(massGenerated);
	} // regressGrains()
	
	
	
	// Generate the mass flowing per each grain
	// based off of Part 3 in motor_internal_balistics.m
	public static double[] generateMassFlow (List<Grain> theGrains, SimulationResults current)
	{
		double massFlow[] =new double[theGrains.size()];
		for (int i = 0; i < theGrains.size(); i++)
		{
			if (i == 0)// Mass flow depends only on it
			{
				massFlow[i] = current.getMassGeneratedPerGrain()[i];
			}else // Mass flow includes all the mass generated in grains above it 
			{
				massFlow[i] = massFlow[i-1] + current.getMassGeneratedPerGrain()[i];
			}
		}
		return massFlow;
	} // generateMassFlow()
	
	
	
	// Calculate the port to throat ratio
	// based off of Part 4 in motor_internal_balistics.m
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
			{
			portToThroat[i] = theGrains.get(i).getCurrentInnerFlowArea()/theGrains.get(i+1).getCurrentInnerFlowArea();
			}
			else
			{
				portToThroat[i] = theGrains.get(i).getCurrentInnerFlowArea()/theNozzle.getThroatArea();
			}
		}
		current.setPortToThroat(portToThroat);
	} // portToThroatRatio()
	
	
	
	// Calculate the mass flow over area at various locations in the motor
	// based off of Part 5 in motor_internal_balistics.m
	// the last parameter is the return value form generateMassFlow()
	public static void calculateMassFlowPerArea (List<Grain> theGrains, SimulationResults current, double[] massFlow)
	{
		double massFlowPerArea[] = new double[theGrains.size() + 2];
		int i;
		for(i = 0; i < theGrains.size(); i++)
		{
			massFlowPerArea[i] = massFlow[i]/theGrains.get(i).getCurrentInnerFlowArea();
		}
		current.setMassFlowPerAreaGrain(massFlowPerArea);
	} // calculateMoreMassFlow()
	
	
	
	// Calculate the l star at the current point in the sim
	// based off of Part 6 in motor_internal_balistics.m
	public static void calculateLStar (List<Grain> theGrains, SimulationResults current, Nozzle theNozzle)
	{
		double currentFreeVolume = 0.0;
		double currentFreeLength = 0.0;
		for(int i = 0; i < theGrains.size(); i++)
		{
			currentFreeVolume += theGrains.get(i).getCurrentInnerFlowVolume();
			currentFreeLength += theGrains.get(i).getlengthDifference();
		}
		currentFreeVolume += Math.PI * Math.pow(theGrains.get(0).getOuterDiameter()/2, 2) * currentFreeLength;
		double lstar = currentFreeVolume / theNozzle.getThroatArea();
		current.setLStar(lstar);
	} // calculateLStar()
	
	
	
	// Calculate the current mass and center of gravity for rocksim
	// based off of Part 7 in motor_internal_balistics.m
	public static void massAndCenterOfGravity (List<Grain> theGrains, SimulationResults current)
	{
		// Need some more info for this one. This will be done after grain refactoring.
	} // massAndCenterOfGravity()
	
	
	
	// Calculate burnout locations
	// based off of Part 8 in motor_internal_balistics.m
	public static void calculateBurnout (List<Grain> theGrains, double currentTime)
	{
		for (int i = 0; i < theGrains.size(); i++){
			if(!theGrains.get(i).isBurning() && theGrains.get(i).getBurnoutTime() == 0.0)
			{
				theGrains.get(i).setBurnoutTime(currentTime);
			}
		}
		
	} // calculateBurnout()
	
	
	
	// converts kn to pressure
	// based on Pc_via_kn
	// motor_internal_balistics.m line 53
	public static double pressureFromKn (double kn)
	{
		return ((double)(2.725060 * kn - 236.099212));
	} // pressureFromKn()
	
	
	
	// converts kn to burn rate
	// based on Br_via_kn
	// motor_internal_balistics.m line 54
	public static double burnRateFromKn (double kn)
	{
		return ((double)(0.000366*kn + 0.083967));
	} // burnRateFromKn()
	
} // class RocketMath
