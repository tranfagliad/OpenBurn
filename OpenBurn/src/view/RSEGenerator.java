
package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import model.Case;
import model.calculations.SimulationSummary;
import model.Nozzle;
import model.calculations.SimulationResults;

/**
 * RSEGenerator.java
 * 
 * Purpose: 
**/

public class RSEGenerator
{
	/**
	 * RSEGenerator Constructor
	 * 
	 * Purpose: 
	**/
	private static final String DIR_ERROR_MSG = "ERROR: Results folder could not be created!\n";
	
	// Other strings
	private static final String CSV_EXTENSION = ".csv";
	private static final String RESULTS_DIRECTORY = "./../OpenBurn_results/";
	private String classification;
	private double isp;
	private double massFrac;
	private double diameter;
	private double mass;
	private double time;
	private double throatDiameter;
	private double thrust;
	private double exitDiameter;
	private double caseMass;
	private double length;
	private double impulse;
	private double reloadable;
	
	public RSEGenerator( String teamName, List <SimulationResults> results, Case c, SimulationSummary classifier, Nozzle no)
	{
		classification ="Test";//classifier.getClassification(); 
		isp =0;//classifier.ISP();
		massFrac =0;//classifier.getMassFrac();
		diameter =0; //c.getDiameter();
		mass =0; //results.get(0).getSystemMass();
		time =5; //results.get(0).getTime();
		throatDiameter =0; //no.getThroatDiameter();
		thrust =0; //results.get(0).getThrust();
		exitDiameter =0; //no.getExitDiameter();
		caseMass =0; //c.getCaseMass();
		length =0; //c.getLength();
		impulse =0; //classifier.getImpulse();
		//reloadable =0; //0;
		
		File resultsDir = new File(RESULTS_DIRECTORY);
		if (!resultsDir.exists())
			if (resultsDir.mkdir() == false)
				throw new RuntimeException(DIR_ERROR_MSG);
		
		File file = new File(RESULTS_DIRECTORY+"results.rse");
		//file.getParentFile().mkdirs();

		try {
			PrintWriter printWriter = new PrintWriter(file);
		
		//Header stuff
		
		printWriter.println("<engine-database>");
		printWriter.println("  <engine-list>");

		//Engine data
		printWriter.print("    <engine  mfg=\"UAWR\" ");
		printWriter.print("code=\""+classification+"\" ");
		printWriter.print("Type=\"reloadable\" "); // set with null value, not in own file yet
		printWriter.print("dia=\""+diameter+".\" ");
		printWriter.println("len=\""+length+".\""); // case length? motor_length
		printWriter.print("initWt=\""+mass+"\" "); // mass at i?
		printWriter.print("propWt=\""+(mass - caseMass)+"\" ");
		printWriter.println("delays=\""+1000+"\" auto-calc-mass=\"1\"");
		printWriter.print("auto-calc-cg=\""+results.get(0).getCg()+"\" ");
		printWriter.print("avgThrust=\""+results.get(0).getThrust()+"\" "); //mean
		printWriter.print("peakThrust=\""+results.get(0).getThrust()+"\" "); //max
		printWriter.println("throatDia=\""+throatDiameter+"\"");
		printWriter.print("exitDia=\""+exitDiameter+"\" ");
		printWriter.print("Itot=\""+impulse+".\" "); // added null value
		printWriter.print("burn-time=\""+time+"\" "); //+time(length(time))+ original code
		printWriter.print("massFrac=\""+massFrac+"\" ");
		printWriter.println("Isp=\""+isp+"\"");
		printWriter.println("tDiv=\"20\" tStep=\"-1.\" tFix=\"1\" FDiv=\"20\" FStep=\"-1.\" FFix=\"1\" mDiv=\"10\""); // All hard coded values
		printWriter.print("mStep=\"-1.\" mFix=\"1\" cgDiv=\"10\" cgStep=\"-1.\" cgFix=\"1\">"); 
		printWriter.println("    <data>");

		//Need to remove the case mass to get the propellant mass
		mass = mass-caseMass;

		//Time dependant data
		for (int i = 0; i < time;i++){ // length(time)
		    printWriter.print("      <eng-data  ");
		    printWriter.print("t=\""+results.get(i).getTime()+"\" ");
		    printWriter.print("f=\""+results.get(i).getThrust()+"\" ");
		    printWriter.print("m=\""+results.get(i).getSystemMass()+"\" ");
		    printWriter.println("cg=\""+results.get(i).getCg()+"\"/>"); //?
		}
		
		

		//File close and cleanup
		printWriter.println("    </data>");
		printWriter.println("  </engine>");
		printWriter.println("</engine-list>");
		printWriter.println("</engine-database>");
		printWriter.close();
		}
catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	} 
	
	public static void main(String [] args){
		String teamName = "TestTeam";
		List <SimulationResults> results = new ArrayList<SimulationResults>();
		SimulationResults sim1 = new SimulationResults();
		SimulationResults sim2 = new SimulationResults();
		SimulationResults sim3 = new SimulationResults();
		SimulationResults sim4 = new SimulationResults();
		SimulationResults sim5 = new SimulationResults();
		sim1.setTime(0);
		sim1.setThrust(0);
		sim1.setSystemMass(0);
		sim1.setCg(0);

		sim2.setTime(0);
		sim2.setThrust(0);
		sim2.setSystemMass(0);
		sim2.setCg(0);

		sim3.setTime(0);
		sim3.setThrust(0);
		sim3.setSystemMass(0);
		sim3.setCg(0);
		
		sim4.setTime(0);
		sim4.setThrust(0);
		sim4.setSystemMass(0);
		sim4.setCg(0);
		
		sim5.setTime(0);
		sim5.setThrust(0);
		sim5.setSystemMass(0);
		sim5.setCg(0);
		
		results.add(sim1);
		results.add(sim2);
		results.add(sim3);
		results.add(sim4);
		results.add(sim5);
		
		Case c = new Case(0, 0, 0);
		SimulationSummary classifier = new SimulationSummary(results);
		Nozzle no = new Nozzle(0, 0, 0, 0, 0);
		
		RSEGenerator test = new RSEGenerator(teamName, results, c, classifier, no);
	}

} 