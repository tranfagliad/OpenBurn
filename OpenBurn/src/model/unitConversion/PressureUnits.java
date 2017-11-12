package model.unitConversion;

public enum PressureUnits
{
	PSI ("Psi"),
	PASCALS ("Pa");
	
	private String abbr;
	
	private PressureUnits (String abbr)
	{
		this.abbr = abbr;
	}

	public String getAbbr() {
		return abbr;
	}
}
