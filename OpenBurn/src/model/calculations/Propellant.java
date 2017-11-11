package model.calculations;

public class Propellant
{
	private double burnRateCoefficient; // a
	private double burnRateExponent; // n
	private double density; // rho
	private double Cstar;
	
	public Propellant(double burnRateCoefficient, double burnRateExponent, double density, double Cstar)
	{
		this.burnRateCoefficient = burnRateCoefficient;
		this.burnRateExponent = burnRateExponent;
		this.density = density;
		this.Cstar = Cstar;
	}
	
	public double pressureFromKn(double Kn)
	{
		//p = (Kn * a * rho * C* )^(1/(1-n))
	    double exponent = 1.0f / (1.0f - burnRateExponent);
	    double p1 = Kn * burnRateCoefficient * density * Cstar;
	    return Math.pow(p1, exponent);
	}
	
	public double burnRateFromPressure(double pressure)
	{
		// r = a * p^n
		return burnRateCoefficient * Math.pow(pressure, burnRateExponent);
	}
}
