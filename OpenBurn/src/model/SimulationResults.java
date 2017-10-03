package model;

public class SimulationResults
{
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

	public double getTime()
	{
		return time;
	}

	public void setTime(double time)
	{
		this.time = time;
	}

	public double getMassGeneratedOverall()
	{
		return massGeneratedOverall;
	}

	public void setMassGeneratedOverall(double massGeneratedOverall)
	{
		this.massGeneratedOverall = massGeneratedOverall;
	}

	public double[] getMassGeneratedPerGrain()
	{
		return massGeneratedPerGrain;
	}

	public void setMassGeneratedPerGrain(double massGeneratedPerGrain[])
	{
		this.massGeneratedPerGrain = massGeneratedPerGrain;
	}

	public double[] getPortToThroat()
	{
		return portToThroat;
	}

	public void setPortToThroat(double portToThroat[])
	{
		this.portToThroat = portToThroat;
	}

	public double[] getMassFlowPerAreaGrain()
	{
		return massFlowPerAreaGrain;
	}

	public void setMassFlowPerAreaGrain(double massFlowPerAreaGrain[])
	{
		this.massFlowPerAreaGrain = massFlowPerAreaGrain;
	}

	public double getBurnArea()
	{
		return burnArea;
	}

	public void setBurnArea(double motorAvailabeArea)
	{
		this.burnArea = motorAvailabeArea;
	}

	public double getBurnRate()
	{
		return burnRate;
	}

	public void setBurnRate(double burnRate)
	{
		this.burnRate = burnRate;
	}

	public double getChamberPressure()
	{
		return chamberPressure;
	}

	public void setChamberPressure(double chamberPressure)
	{
		this.chamberPressure = chamberPressure;
	}

	public double getKn()
	{
		return kn;
	}

	public void setKn(double kn)
	{
		this.kn = kn;
	}

	public double getlStar()
	{
		return lStar;
	}

	public void setlStar(double lStar)
	{
		this.lStar = lStar;
	}

	public double getSystemMass()
	{
		return systemMass;
	}

	public void setSystemMass(double systemMass)
	{
		this.systemMass = systemMass;
	}

	public double getSystemCenterOfGravity()
	{
		return systemCenterOfGravity;
	}

	public void setSystemCenterOfGravity(double systemCenterOfGravity)
	{
		this.systemCenterOfGravity = systemCenterOfGravity;
	}

} // class 
