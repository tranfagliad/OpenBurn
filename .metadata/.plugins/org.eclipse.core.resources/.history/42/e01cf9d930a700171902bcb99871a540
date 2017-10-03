/**
 * Author: Andrew Tarr
 * File: CSVConverter.java
 */
//package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * An instance of the CSVConverter object can be used to convert data 
 * in an array into a csv file. There are two methods, one for writing 
 * objects, the other for primitive ints.
 */
public class CSVConverter {

	/*
	 * This method takes an array of Objects and writes them to the 
	 * specified file in the second parameter in the form of a csv file. 
	 */
	public void writeObjArr(Object [] array, String fileTo){
		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(fileTo));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		for (Object element : array) {
		 sb.append(element);
		 sb.append(",");
		}

		try {
			br.write(sb.toString());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	/*
	 * This method takes an array of ints and writes them to the 
	 * specified file in the second parameter in the form of a csv file. 
	 */
	public void writeIntArr(int [] array, String fileTo){
		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(fileTo));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		for (int element : array) {
		 sb.append(element);
		 sb.append(",");
		}

		try {
			br.write(sb.toString());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
