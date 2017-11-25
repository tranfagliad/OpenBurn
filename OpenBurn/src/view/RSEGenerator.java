
package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import model.Case;
import model.calculations.SimulationSummary;
import model.Nozzle;
import model.calculations.SimulationResults;

import model.unitConversion.*;

/**
 * RSEGenerator.java
 * 
 * Purpose:
 **/

public class RSEGenerator {
	/**
	 * RSEGenerator Constructor
	 * 
	 * Purpose:
	 **/


	private String teamName;
	private List<SimulationResults> results;
	private Case theCase;
	private SimulationSummary classifier;
	private Nozzle theNozzle;

	public RSEGenerator(String teamName, List<SimulationResults> simResults, Case theCase, SimulationSummary summary,
			Nozzle theNozzle) {
		this.teamName = teamName;
		this.results = simResults;
		this.theCase = theCase;
		this.classifier = summary;
		this.theNozzle = theNozzle;
	}

	public void generateRSEToFile(File file) {
		String classification = classifier.getClassification();
		double isp = classifier.ISP();
		double massFrac = classifier.getMassFrac();
		double diameter = UnitConverter.unitLengthConverter(theCase.getDiameter(), LengthUnits.INCHES,
				LengthUnits.MILLIMETERS);
		double mass = UnitConverter.convertMassFromInternal(results.get(0).getSystemMass(), MassUnits.GRAMS);
		double burnTime = classifier.getBurnTime();
		double throatDiameter = UnitConverter.unitLengthConverter(theNozzle.getThroatDiameter(), LengthUnits.INCHES,
				LengthUnits.MILLIMETERS);
		double exitDiameter = UnitConverter.unitLengthConverter(theNozzle.getExitDiameter(), LengthUnits.INCHES,
				LengthUnits.MILLIMETERS);
		double caseMass = UnitConverter.convertMassFromInternal(theCase.getCaseMass(), MassUnits.GRAMS);
		double length = UnitConverter.unitLengthConverter(theCase.getLength(), LengthUnits.INCHES, LengthUnits.MILLIMETERS);
		double impulse = classifier.getImpulse();
		double averageThrust = UnitConverter.convertForceFromInternal(classifier.getaverageThrust(),
				ForceUnits.NEWTONS);
		// reloadable =0; //0;

		try {
			PrintWriter printWriter = new PrintWriter(file);

			// Header stuff

			printWriter.println("<engine-database>");
			printWriter.println("  <engine-list>");

			// Engine data
			printWriter.format("    <engine  mfg=\"%s\" ", teamName);
			printWriter.format("code=\"%s\" ", classification);
			printWriter.print("Type=\"reloadable\" "); // Hard coded
			printWriter.format("dia=\"%.1f\" ", diameter);
			printWriter.format("len=\"%.1f\"\n", length);
			printWriter.format("initWt=\"%.1f\" ", mass);
			printWriter.format("propWt=\"%.2f\" ", mass - caseMass);
			printWriter.println("delays=\"" + 1000 + "\" auto-calc-mass=\"1\"");// Defaults
			printWriter.print("auto-calc-cg=\"1\" ");
			printWriter.format("avgThrust=\"%.2f\" ", averageThrust); // mean
			printWriter.print("peakThrust=\"" + results.get(0).getThrust() + "\" "); // max
			printWriter.println("throatDia=\"" + throatDiameter + "\"");
			printWriter.format("exitDia=\"%.1f\" ", exitDiameter);
			printWriter.format("Itot=\"%.1f.\" ", impulse);
			printWriter.format("burn-time=\"%.2f\" ", burnTime); // +time(length(time))+
																	// original
																	// code
			printWriter.format("massFrac=\"%.2f\" ", massFrac);
			printWriter.format("Isp=\"%.2f\" \n", isp);
			printWriter
					.println("tDiv=\"20\" tStep=\"-1.\" tFix=\"1\" FDiv=\"20\" FStep=\"-1.\" FFix=\"1\" mDiv=\"10\""); // All
																														// hard
																														// coded
																														// values
			printWriter.println("mStep=\"-1.\" mFix=\"1\" cgDiv=\"10\" cgStep=\"-1.\" cgFix=\"1\">");
			printWriter.println("    <data>");

			// Time dependant data
			for (int i = 0; i < results.size(); i++) {
				printWriter.print("      <eng-data  ");
				printWriter.format("t=\"%.3f\" ", results.get(i).getTime());
				printWriter.format("f=\"%.2f\" ",
						UnitConverter.convertForceFromInternal(results.get(i).getThrust(), ForceUnits.NEWTONS));
				printWriter.format("m=\"%.2f\" ", UnitConverter
						.convertMassFromInternal(results.get(i).getSystemMass() - theCase.getCaseMass(), MassUnits.GRAMS));
				printWriter.format("cg=\"%.0f\"/>\n", UnitConverter.unitLengthConverter(results.get(i).getCg(),
						LengthUnits.INCHES, LengthUnits.MILLIMETERS));
			}

			// File close and cleanup
			printWriter.println("    </data>");
			printWriter.println("  </engine>");
			printWriter.println("</engine-list>");
			printWriter.println("</engine-database>");
			printWriter.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
}