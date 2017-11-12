package model.unitConversion;

public enum MassUnits
{
	POUNDS_MASS ("lbm"),
	GRAMS ("g"),
	KILOGRAMS ("kg");
	
	private String abbr;
	
	private MassUnits (String abbr)
	{
		this.abbr = abbr;
	}

	public String getAbbr() {
		return abbr;
	}
}
