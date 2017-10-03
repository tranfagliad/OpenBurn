//function [AB] = cylindrical_grain_burn_area(d,di,l,n)
/*%cylindrical_grain_burn_area Provides the current burn surface area for a
%cylindrical grain
%   This function provides the burn surface area for a cylindrical grain
%   when provided its geometry. No propellant charactersitics are used
%   here.
%Input arguments
%   d
 - Grain outer diameter
%   di
 - Grain inner diameter
%   l  - Grain segment length
%   n  - Number of burning faces
*/
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
//int AB_FACE;
// int AB_INNER;
// static 

public class CylindricalGrainBurnArea{
	public static void main(String [] args)
	{

	}
	
    public double burnArea(double d,double di,double l,double n){
 if (n < 0 || n > 2){
    System.out.println("Number of burning faces must be between 0 and 2");
    return 0;
  }
    
double AB_FACE = n*(Math.PI)*((Math.pow((d/2),2)) - (Math.pow((di/2),2)));           
double AB_INNER = 2*(Math.PI)*(di/2)*l;                      

double AB = AB_FACE + AB_INNER;
return AB;

    }
}