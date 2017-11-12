package model.unitConversion;

public enum MassFlowRateUnits
{
	POUNDS_MASS_PER_SECOND ("lbm/s"),
	KILOGRAMS_PER_SECOND ("kg/s");
	
	private String abbr;
	
	private MassFlowRateUnits (String abbr)
	{
		this.abbr = abbr;
	}

	public String getAbbr() {
		return abbr;
	}
}
