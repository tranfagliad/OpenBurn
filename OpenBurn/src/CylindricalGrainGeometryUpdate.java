
/*function [new_di,new_l,vol_change,new_volume] = cylindrical_grain_geomtetry_update(Do,Di,l,br,dt,n)
%cylindrical_grain_burn_update Updates bates grains for internal balistics
%   This script accepts the current geometry of a cylindrical grain and
%   computes the change in geometry of the grain 
%Input Arguments
%   Do - Outer grain diameter
%   Di - Inner grain diameter
%   l  - Grain segment length
%   br - Propellant burn rate
%   dt - time change
%   n  - number of burning faces
%Output
%   new_di - new inner grain diameter post burn
%   new__l - new grain length post burn
%   vol_change - volume change during burn
*/
import java.util.*;

public class CylindricalGrainGeometryUpdate
{
	public static double br;
	public static double dt;
	public static double n;
	public static double initial_volume;
	

	public static void main(String [] args)
	{

	}
	public double CylindricalGrainVolume(double doi, double di, double l){

double new_l = l - (n*br*dt);
double new_di = di + (2*br*dt);
new_l = Math.max(new_l,0);
new_di = Math.min(new_di,doi);
double new_volume = CylindricalGrainVolume(doi,new_di,new_l);
if(new_volume > initial_volume){
    System.out.print("Negative volume change occured!");
}
double vol_change = initial_volume - new_volume;
return vol_change;

}
}
	

