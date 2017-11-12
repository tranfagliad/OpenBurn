package model.unitConversion;

public enum LengthUnits
{
	INCHES ("in"),
	FEET ("ft"),
	MILLIMETERS ("mm"),
	CENTIMETERS ("cm");
	
	
	
	private String abbr;
	
	private LengthUnits (String abbr)
	{
		this.abbr = abbr;
	}

	public String getAbbr() {
		return abbr;
	}
	
}
