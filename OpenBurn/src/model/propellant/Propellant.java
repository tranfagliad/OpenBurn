package model.propellant;

public abstract class Propellant {
	abstract public void setKn(double Kn);
	abstract public double getChamberPressure();
	abstract public double getBurnRate();
	abstract public double getPropellantDensity();
}
