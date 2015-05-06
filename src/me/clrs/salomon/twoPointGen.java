package me.clrs.salomon;

import java.util.Vector;

abstract class twoPointGen implements CGen{

	//Color Storage
	Vector<int []> generatedColors = new Vector<int []>();

	//Color Storage
	protected int[] rgb0 = new int[]{255,255,255};
	protected int[] rgb1 = new int[]{255,255,255};

	//Parameters
	protected int steps = 2;
	protected int strength = 100;
	
	protected int[] intervals(int in, int min){
		int[] out = new int[steps];
		int delta = in-min;
		for (int i = 0; i < steps; i++) out[i] = (int) (in - ((delta*strength/100.0)/(steps-1))*i);
		return out;
	}
	
	@Override
	public String toString(){
		String out = "";
		String temp;
		for (int i = 0; i < generatedColors.size(); i++){
			temp = intsToColor(generatedColors.get(i));
			out += temp + '\n';
		}
		return out;
	}
	
	public void clear() {
		generatedColors.clear();
		rgb0 = new int[]{255,255,255};
		rgb1 = new int[]{255,255,255};
		steps = 2;
		strength = 100;
	}

	//Setting/Getting parameters
	
	public boolean setBases(String [] hex){
		if (hex.length!=2){
			return false;
		}
		if (hex[0].length() == 6 && hex[1].length() == 6){
			rgb0 = colorToInts(hex[0]);
			rgb1 = colorToInts(hex[1]);
			return true;
		}
		return false;
	}

	public boolean setSteps(int s) {
		if (s>=2 && s<256){
			steps = s;
			return true;
		}
		return false;
	}

	public boolean setStrength(int s){
		if (s <= 100 && s >= 0){
			strength = s;
			return true;
		}
		return false;
	}

	public String []getBases(){return new String[]{intsToColor(rgb0),intsToColor(rgb1)};}
	public int getSteps(){return steps;}
	public int getStrength(){return strength;}
}
