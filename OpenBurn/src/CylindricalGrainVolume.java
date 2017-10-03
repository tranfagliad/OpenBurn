
//function [volume] = cylindrical_grain_volume(Do,Di,l)
//%cylindrical_grain_volume Volume of a cylindrical grain


import java.util.*;


public class CylindricalGrainVolume{
	public static void main(String [] args)
	{
;
	}
	public static double volume(double di, double doi, double l ){
double ri = di/2;
double ro = doi/2;
double volume = (Math.PI)*l*((Math.pow(ro, 2)) - (Math.pow(ri, 2)));
return volume;

}
}