package model;

public class Nozzle
{
	private double throatDiameter;
	private double throatArea;
	private double entranceArea;
	private double exitDiameter;
	private double cf;
	private int entranceId;
	private int throatId;
	
	public Nozzle(float throatDiameter, float entranceDiameter, float exitDiameter, float cf, int numberOfGrains)
	{
		this.throatDiameter = throatDiameter;
		this.throatArea = Math.PI * (throatDiameter/2) * (throatDiameter/2);
		this.entranceArea = Math.PI * (entranceDiameter/2) * (entranceDiameter/2);
		this.cf = cf;
		this.exitDiameter = exitDiameter;
		this.entranceId = numberOfGrains + 1;
		this.throatId = numberOfGrains + 2;
	}

	public double getThroatDiameter()
	{
		return throatDiameter;
	}

	public double getExitDiameter()
	{
		return exitDiameter;
	}

	public double getCf()
	{
		return cf;
	}

	public int getEntranceId()
	{
		return entranceId;
	}

	public int getThroatId()
	{
		return throatId;
	}

	public double getThroatArea()
	{
		return throatArea;
	}

	public double getEntranceArea()
	{
		return entranceArea;
	}
}
