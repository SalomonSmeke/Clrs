package me.clrs.salomon;

import java.util.Vector;
//Functionality available to twoPointGenerators
abstract class twoPointGen implements CGen{

	//Palette Storage
	Vector<int []> generatedColors = new Vector<int []>();

	//Color Storage
	protected int[] base0 = new int[]{255,255,255};
	protected int[] base1 = new int[]{255,255,255};

	//Parameters
	protected int steps = 2;
	protected int strength = 100;

	//Setting/Getting parameters
	public boolean setBases(String [] hex){
		if (hex.length!=2){
			return false;
		}
		if (hex[0].length() == 6 && hex[1].length() == 6){
			base0 = colorToInts(hex[0]);
			base1 = colorToInts(hex[1]);
			if (base0==null || base1==null) return false;
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

	public Vector<int []> getGenerated(){return generatedColors;}
	public String []getBases(){return new String[]{intsToColor(base0),intsToColor(base1)};}
	public int getSteps(){return steps;}
	public int getStrength(){return strength;}

	//Utilities
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
		base0 = new int[]{255,255,255};
		base1 = new int[]{255,255,255};
		steps = 2;
		strength = 100;
	}

	//Helpers (internal use)
	protected int[] intervals(int in, int min){
		int[] out = new int[steps];
		int delta = in-min;
		for (int i = 0; i < steps; i++) out[i] = (int) (in - ((delta*strength/100.0)/(steps-1))*i);
		return out;
	}
}
