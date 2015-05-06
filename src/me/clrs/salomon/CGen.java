package me.clrs.salomon;

import java.util.Vector;
//Functionality that all generators must have
public interface CGen {
	
	//Getters & Setters
	public boolean setSteps(int s);
	public Vector<int []> getGenerated();
	
	//Utilities
	@Override
	public String toString();
	public String nextColors();
	public void clear();

	//Helpers (internal use)
	default int[] colorToInts(String hex){
		int [] out = new int[3];
		
		for (int i = 0; i < 3; i++){
			out[i] = toInt(hex.substring(2*i, 2*(i+1)));
		}
		return out;
	}
	default String intsToColor(int[] color){
		String out = "";
		for (int i = 0; i < 3; i++){
			out += toHex(color[i],2);
		}
		return out;
	}
	default int toInt(String hex){
		  return Integer.parseInt(hex, 16);  
	}
	default String toHex(int decimal, int minLength){
		String out = Integer.toHexString(decimal);
		while (out.length()<minLength){
			out = "0" + out;
		}
		return out;
	}
}
