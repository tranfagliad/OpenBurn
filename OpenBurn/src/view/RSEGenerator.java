
package view;

import model.Case;
import model.calculations.ImpulseClassifier;
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
	
	public RSEGenerator( String teamName, SimulationResults results, Case c, ImpulseClassifier classifier)
	{
		// list simresults object: mass, thrust, cg, time; nozzel object,case object: casemass, diameter, length, Classiferier: clasification, isp, mass_frac. string team name	
		String classification = classifier.getClassification(); 
		double isp = classifier.ISP();
		double mass_frac = classifier.getMassFrac();
		double diameter = c.getDiameter();
		double [] mass = results.getMassFlowPerAreaGrain();
		double time = results.getTime();
		/*
		rse_file_name = sprintf("%s.rse",classification);
		rse_file_name = strrep(rse_file_name," ","_");
		fid = fopen(rse_file_name,"wt");

		//%Header stuff
		System.out.println(fid+"<engine-database>");
		System.out.println(fid+"  <engine-list>");

		//%Engine data
		System.out.print(fid+"    <engine  mfg='UAWR' ");
		System.out.print(fid+"code="+classification+" ");
		System.out.print(fid+"Type="+reloadable+" ");
		System.out.print(fid+"dia="+diameter+" ");
		System.out.println(fid+"len="+motor_length);
		System.out.print(fid+"initWt="+mass(1)+" ");
		System.out.print(fid+"propWt="+mass(1) - case_weight+" ");
		System.out.println(fid+"delays="1000" auto-calc-mass='1'");
		System.out.print(fid+"auto-calc-cg='1' ");
		System.out.print(fid+"avgThrust="+mean(thrust)+" ");
		System.out.print(fid+"peakThrust="+max(thrust)+" ");
		System.out.println(fid+"throatDia="+throat_diameter);
		System.out.print(fid+"exitDia="+exit_diameter+" ");
		System.out.print(fid+"Itot="impulse+" ");
		System.out.print(fid+"burn-time="+time(length(time))+" ");
		System.out.print(fid+"massFrac="+mass_frac+" ");
		System.out.println(fid+"Isp="isp);
		System.out.println(fid+"tDiv='20' tStep='-1.' tFix='1' FDiv='20' FStep='-1.' FFix='1' mDiv='10'");
		System.out.print(fid+"mStep='-1.' mFix='1' cgDiv='10' cgStep='-1.' cgFix='1'>");
		System.out.println(fid+"    <data>");

		//%Need to remove the case mass to get the propellant mass
		mass = mass-case_weight;

		//%Time dependant data
		for (i = 1; i < length(time);i++){
		    System.out.print(fid+"      <eng-data  ");
		    System.out.print(fid+"t="+time(i)+" ");
		    System.out.print(fid+"f="+thrust(i)+" ");
		    System.out.print(fid+"m="+mass(i)+" ");
		    System.out.println(fid+"cg="+cg(i)+"/>");
		}
*/
		//%File close and cleanup
		//System.out.print(fid","    </data>\n  </engine>\n</engine-list>\n</engine-database>\n");
	} // RSEGenerator Constructor

} // class RSEGenerator