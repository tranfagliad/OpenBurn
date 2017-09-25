import java.util.*;

public class RocketMotor
{
	public static LinkedList<Result> simulate(Grain[] theGrains, float deltaTime, Nozzle theNozzle)
	{
		LinkedList<Result> output = new LinkedList<Result>();
		float currentTime = 0;
		boolean run = true;
		
		while(run)
		{
			currentTime += deltaTime;
			
			Result currentTimeStep = new Result();
			currentTimeStep.setTime(currentTime);
			
			// part 1, part 2, ... part 8
			
			output.addLast(currentTimeStep);
			
			// if (some stuff)
			// {
			//  run = false
			// }
		}
		
		return output;
	}
	
	// Generate and save current geometry based data
	// based off of Part 1 in motor_internal_balistics.m
	public void generateGometry(Grain[] theGrains, Result current)
	{
		
	}
	
	// Regress grains and calculate the mass flow. Save said data and update the sim state
	// based off of Part 2 in motor_internal_balistics.m
	public void regressGrains(Grain[] theGrains, Result current, float deltaTime)
	{
		
	}
	
	// Generate the mass flowing per each grain
	// based off of Part 3 in motor_internal_balistics.m
	public float[] generateMassFlow(Result current)
	{
		return null;
	}
	
	// Calculate the port to throat ratio
	// based off of Part 4 in motor_internal_balistics.m
	public void portToThroatRatio(Grain[] theGrains, Result current)
	{
		
	}
	
	// Calculate the mass flow over area at various locations in the motor
	// based off of Part 5 in motor_internal_balistics.m
	// the last parameter is the return value form generateMassFlow()
	public void claculateMoreMassFlow(Grain[] theGrains, Result current, float[] massFlow)
	{
		
	}
	
	// Calculate the l star at the current point in the sim
	// based off of Part 6 in motor_internal_balistics.m
	public void calculateLstar(Grain[] theGrains, Result current)
	{
		
	}
	
	// Calculate the current mass and center of gravity for rocksim
	// based off of Part 7 in motor_internal_balistics.m
	public void massAndCenterOfGravity(Grain[] theGrains, Result current)
	{
		
	}
	
	// Calculate burnout locations
	// based off of Part 8 in motor_internal_balistics.m
	public void calculateBurnout(Grain[] theGrains, float currentTime)
	{
		
	}
	
	// converts kn to pressure
	// based on Pc_via_kn
	// motor_internal_balistics.m line 53
	public double pressureFromKn(float kn)
	{
		return 2.725060 * kn - 236.099212;
	}

	// converts kn to burn rate
	// based on Br_via_kn
	// motor_internal_balistics.m line 54
	public double burnRateFromKn(float kn)
	{
		return 0.000366*kn + 0.083967;
	}
}
