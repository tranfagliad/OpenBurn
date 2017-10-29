
package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
	
	public RSEGenerator( String teamName, List <SimulationResults> results, Case c, SimulationSummary classifier, Nozzle no)
	{
		// list simresults object: mass, thrust, cg, time; nozzel object,case object: casemass, diameter, length, Classiferier: clasification, isp, mass_frac. string team name	
		String classification = classifier.getClassification(); 
		double isp = classifier.ISP();
		double massFrac = classifier.getMassFrac();
		double diameter = c.getDiameter();
		double  mass = results.get(0).getSystemMass();
		double time = results.get(0).getTime();
		double throatDiameter = no.getThroatDiameter();
		double thrust = results.get(0).getThrust();
		double exitDiameter = no.getExitDiameter();
		double caseMass = c.getCaseMass();
		double length = c.getLength();
	//	rse_file_name = sprintf("%s.rse",classification);
	//	rse_file_name = strrep(rse_file_name," ","_");
	//	fid = fopen(rse_file_name,"wt");
		File file = new File("C:/Users/EVHfa/Desktop/436workspace/GitHub/OpenBurn/OpenBurn_results/results.rse");
		file.getParentFile().mkdirs();

		try {
			PrintWriter printWriter = new PrintWriter(file);
		
		//%Header stuff
		
		printWriter.println("<engine-database>");
		printWriter.println("  <engine-list>");

		//%Engine data
		printWriter.print("    <engine  mfg='UAWR' ");
		printWriter.print("code="+classification+" ");
		//printWriter.print("Type="+reloadable+" "); //?
		printWriter.print("dia="+diameter+" ");
		printWriter.println("len="+length); // case length? motor_length
		printWriter.print("initWt="+mass+" "); // mass at i?
		printWriter.print("propWt="+(mass - caseMass)+" ");
		printWriter.println("delays="+1000+" auto-calc-mass='1'");
		printWriter.print("auto-calc-cg='1' ");
		printWriter.print("avgThrust="+thrust+" "); //mean
		printWriter.print("peakThrust="+thrust+" "); //max
		printWriter.println("throatDia="+throatDiameter);
		printWriter.print("exitDia="+exitDiameter+" ");
		//printWriter.print("Itot="impulse+" "); //?
		//printWriter.print("burn-time="+time(length(time))+" "); //?
		printWriter.print("massFrac="+massFrac+" ");
		printWriter.println("Isp="+isp);
		printWriter.println("tDiv='20' tStep='-1.' tFix='1' FDiv='20' FStep='-1.' FFix='1' mDiv='10'");
		printWriter.print("mStep='-1.' mFix='1' cgDiv='10' cgStep='-1.' cgFix='1'>");
		printWriter.println("    <data>");

		//%Need to remove the case mass to get the propellant mass
		mass = mass-caseMass;

		//%Time dependant data
		for (int i = 1; i < time;i++){ // length(time)
		    printWriter.print("      <eng-data  ");
		    printWriter.print("t="+results.get(i).getTime()+" ");
		    printWriter.print("f="+results.get(i).getThrust()+" ");
		    printWriter.print("m="+results.get(i).getSystemMass()+" ");
		    //printWriter.println("cg="+cg(i)+"/>"); //?
		}
		}
catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}


		//%File close and cleanup
		//printWriter.print(fid","    </data>\n  </engine>\n</engine-list>\n</engine-database>\n");
	} // RSEGenerator Constructor

} // class RSEGenerator