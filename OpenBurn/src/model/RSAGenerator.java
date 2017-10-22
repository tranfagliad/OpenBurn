
package model;

public class RSAGenerator {



function [rse_file] = rse_generator(time,thrust,mass,cg,diameter,...
    case_weight,throat_diameter,exit_diameter,isp,impulse,classification,...
    motor_length,mass_frac)
//individual inputs

/*%rse_generator Generates a Rocksim XML format engine file
%   Generates a rocksim format engine file that can be used to simulate
%   motors generated
%   This DOES NOT do input sanitization. Odd stuff may happen without
%   proper units. 
%   The first data point must have zero thrust and time but the correct
%   mass and cg points
%   The code assumes that the motor is a reloadable pligged motor. It gives
%   it the manufacturer designation of "UA Wildcat Rocketry". 
%   This output will generate the output ans = [data: null]. Your data is
%   there and the warning can be safely ignored.
%   Inputs:
%   time: An array of time points (s)
%   thrust: Thrust force (N)
%   mass: Mass of the system (propellant + weight) (g)
%   cg: Center of gravity location from nozzle end (mm)
%   diameter: Motor diameter (mm)
%   motor_length: Motor length (mm)
%   case_weight: Weight of the em[ty case (g)
%   throat_diameter: Throat diameter (mm)
%   exit_diameter: Exit diameter (mm)
%   classification: Amature motor classification (string format)
%   mass_frac: Fraction of propellant in the motor
%   Output:
%   rse_file: The name of the file generated 

%While this may look like XML formatting Rocksim wont read true XML. So we
%do this the hard way!

%File naming
*/
rse_file_name = sprintf('%s.rse',classification); // creating sting
rse_file_name = strrep(rse_file_name,' ','_'); // create the file
fid = fopen(rse_file_name,'wt'); //make the file and open

//%Header stuff
System.out.print(fid,'<engine-database>\n');
System.out.print(fid,'  <engine-list>\n');

//%Engine data
System.out.print(fid,'    <engine  mfg="UAWR" ');
System.out.print(fid,'code="%s" ',classification);
System.out.print(fid,'Type="reloadable" ');
System.out.print(fid,'dia="%.0f." ' ,diameter);
System.out.print(fid,'len="%.0f."\n',motor_length);
System.out.print(fid,'initWt="%.1f" ',mass(1));
System.out.print(fid,'propWt="%.2f" ',mass(1) - case_weight);
System.out.print(fid,'delays="1000" auto-calc-mass="1"\n');
System.out.print(fid,'auto-calc-cg="1" ');
System.out.print(fid,'avgThrust="%.2f" ',mean(thrust));
System.out.print(fid,'peakThrust="%.2f" ',max(thrust));
System.out.print(fid,'throatDia="%.1f"\n',throat_diameter);
System.out.print(fid,'exitDia="%.1f" ',exit_diameter);
System.out.print(fid,'Itot="%.0f." ',impulse);
System.out.print(fid,'burn-time="%.2f" ',time(length(time)));
System.out.print(fid,'massFrac="%.2f" ',mass_frac);
System.out.print(fid,'Isp="%.2f" \n',isp);
System.out.print(fid,'tDiv="20" tStep="-1." tFix="1" FDiv="20" FStep="-1." FFix="1" mDiv="10"\n');
System.out.print(fid,'mStep="-1." mFix="1" cgDiv="10" cgStep="-1." cgFix="1">\n');
System.out.print(fid,'    <data>\n');

//%Need to remove the case mass to get the propellant mass
mass = mass-case_weight;

//%Time dependant data
for i = 1:length(time)
    System.out.print(fid,'      <eng-data  ');
    System.out.print(fid,'t="%.3f" ',time(i));
    System.out.print(fid,'f="%.2f" ',thrust(i));
    System.out.print(fid,'m="%.2f" ',mass(i));
    System.out.print(fid,'cg="%.0f"/>\n',cg(i));
end

//%File close and cleanup
System.out.print(fid','    </data>\n  </engine>\n</engine-list>\n</engine-database>\n');
rse_file = rse_file_name;
fclose(fid);


/*% %Header fluffs
% %Data node start
% data_node = docNode.createElement('data');
% 
% %Need to offset the mass for output
% mass = mass-mass(length(mass));
% 
% %Main data dump loop
% for i = 1:length(time)
%     engine_data_node = docNode.createElement('eng-data');
%     data = sprintf('Hook t="%.3f" f="%.2f" m="%.2f" cg="%.2f"',time(i)...
%                                                 ,thrust(i),mass(i),cg(i));
%     engine_data_node.setTextContent(data);
%     data_node.appendChild(engine_data_node);
% end
% 
% %Link all the nodes back
% engine_list_ode.appendChild(engine_node);
% engine_list_ode.appendChild(data_node);
% 
% %Cleanup fluff Rocksim XML isnt true XML so the output of the Java DOM
% %needs to be modified.
% tmp = xmlwrite(docNode);
% tmp = strrep(tmp,'<?xml version="1.0" encoding="utf-8"?>','');
% tmp = strrep(tmp,'>Hook','');
% tmp = strrep(tmp,'</eng-data>','/>');
% rse_file = strtrim(tmp);
*/
}