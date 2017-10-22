package model;

public class Case {
	
	private double caseMass;
	private double diameter;

	public Case(double caseMass, double diameter){
		this.caseMass = caseMass;
		this.diameter = diameter;
	}
	
	public double getCaseMass(){
		return caseMass;
	}
	
	public double getDiameter(){
		return diameter;
	}
	
}
