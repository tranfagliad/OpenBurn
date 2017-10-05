package model;

/**
 * SimulationResults.java
 * 
 * Contains the data for a set of results from a grain simulation.
**/

public class SimulationResults
{
	// Private fields for the results
	// ADDME: comments stating the units for each field
	private double time;
	private double massGeneratedOverall;
	private double massGeneratedPerGrain[];
	private double portToThroat[];
	private double massFlowPerAreaGrain[];
	private double burnArea;
	private double burnRate;
	private double chamberPressure;
	private double kn;
	private double lStar;
	private double systemMass;
	private double systemCenterOfGravity;
	
	
	
	/**
	 * toString()
	 * 
	 * Purpose: Returns a textual representation of the results, which
	 * 		only includes the time and the chamber pressure.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: String. A textual representation of the results, which
	 * 		only includes the time and the chamber pressure.
	**/
	
	@Override
	public String toString ()
	{
		return time + "," + chamberPressure;
	} // toString()
	
	
	
	/**
	 * getTime()
	 * 
	 * Purpose: Returns the time for the results.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The time for the results.
	**/
	
	public double getTime ()
	{
		return time;
	}
	
	
	
	public void setTime(double time)
	{
		this.time = time;
	}
	
	
	
	/**
	 * getMassGeneratedOverall()
	 * 
	 * Purpose: Returns the mass generated overall.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. the mass generated overall.
	**/
	
	public double getMassGeneratedOverall ()
	{
		return massGeneratedOverall;
	} // getMassGeneratedOverall()
	
	
	
	public void setMassGeneratedOverall(double massGeneratedOverall)
	{
		this.massGeneratedOverall = massGeneratedOverall;
	}
	
	
	
	/**
	 * getMassGeneratedPerGrain()
	 * 
	 * Purpose: Returns an array containing the mass generated for all
	 * 		of the grains in a simulation.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double[]. The mass generated for each grain in a simulation.
	**/
	
	public double[] getMassGeneratedPerGrain ()
	{
		return massGeneratedPerGrain;
	} // getMassGeneratedPerGrain()
	
	
	
	public void setMassGeneratedPerGrain(double[] massGeneratedPerGrain)
	{
		this.massGeneratedPerGrain = massGeneratedPerGrain;
	}
	
	
	
	/**
	 * getPortToThroat()
	 * 
	 * Purpose: Returns the port-to-throat of each grain in a simulation.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double[]. The port-to-throat for each grain in a simulation.
	**/
	
	public double[] getPortToThroat ()
	{
		return portToThroat;
	} // getPortToThroat()
	
	
	
	public void setPortToThroat(double portToThroat[])
	{
		this.portToThroat = portToThroat;
	}
	
	
	
	/**
	 * getMassFlowPerAreaGrain()
	 * 
	 * Purpose: Returns an array that contains the mass flow per area
	 * 		grain for each grain in a simulation.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double[]. An array that contains the mass flow per area
	 * 		grain for each grain in a simulation.
	**/
	
	public double[] getMassFlowPerAreaGrain()
	{
		return massFlowPerAreaGrain;
	} // getMassFlowPerAreaGrain()
	
	
	
	public void setMassFlowPerAreaGrain(double massFlowPerAreaGrain[])
	{
		this.massFlowPerAreaGrain = massFlowPerAreaGrain;
	}
	
	
	
	/**
	 * getBurnArea()
	 * 
	 * Purpose: Returns the burn area of the results.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The burn area of the results.
	**/
	
	public double getBurnArea ()
	{
		return burnArea;
	} // getBurnArea()
	
	
	
	public void setBurnArea(double motorAvailabeArea)
	{
		this.burnArea = motorAvailabeArea;
	}
	
	
	
	/**
	 * getBurnRate()
	 * 
	 * Purpose: Returns the burn rate from the results.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The burn rate from the results.
	**/
	
	public double getBurnRate ()
	{
		return burnRate;
	} // getBurnRate()
	
	
	
	public void setBurnRate(double burnRate)
	{
		this.burnRate = burnRate;
	}
	
	
	
	/**
	 * getChamberPressure()
	 * 
	 * Purpose: Returns the chamber pressure of the results.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The chamber pressure of the results.
	**/
	
	public double getChamberPressure ()
	{
		return chamberPressure;
	} // getChamberPressure()
	
	
	
	public void setChamberPressure(double chamberPressure)
	{
		this.chamberPressure = chamberPressure;
	}
	
	
	
	/**
	 * getKn()
	 * 
	 * Purpose: Returns the ratio of the burn area of the propellant
	 * 		to the area of the nozzle throat (kn). 
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The ratio of the burn area of the propellant
	 * 		to the area of the nozzle throat (kn). 
	**/
	
	public double getKn ()
	{
		return kn;
	} // getKn()
	
	
	
	public void setKn(double kn)
	{
		this.kn = kn;
	}

	
	
	/**
	 * getLStar()
	 * 
	 * Purpose: Returns the characteristic length (L*) of the results.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The characteristic length (L*) of the results.
	**/
	
	public double getLStar ()
	{
		return lStar;
	} // getLStar()

	
	
	public void setlStar(double lStar)
	{
		this.lStar = lStar;
	}

	
	
	/**
	 * getSystemMass()
	 * 
	 * Purpose: Returns the system mass of the results.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The system mass of the results.
	**/
	
	public double getSystemMass ()
	{
		return systemMass;
	} // getSystemMass()
	
	
	
	public void setSystemMass(double systemMass)
	{
		this.systemMass = systemMass;
	}

	
	
	/**
	 * getSystemCenterOfGravity()
	 * 
	 * Purpose: Returns the system center of gravity for the results.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: double. The system center of gravity for the results.
	**/
	
	public double getSystemCenterOfGravity ()
	{
		return systemCenterOfGravity;
	} // getSystemCenterOfGravity()

	
	
	public void setSystemCenterOfGravity(double systemCenterOfGravity)
	{
		this.systemCenterOfGravity = systemCenterOfGravity;
	}

} // class SimulationResults
