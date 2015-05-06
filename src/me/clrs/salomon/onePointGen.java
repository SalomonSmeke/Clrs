package me.clrs.salomon;

import java.util.Vector;
//Functionality available to onePointGenerators
abstract class onePointGen implements CGen{

	//Palette Storage
	Vector<int []> generatedColors = new Vector<int []>();

	//Color Storage
	protected int[] base = new int[]{255,255,255};

	//Parameters
	protected int steps = 2;
	protected int strength = 100;
	protected int pivot = 0;
	
	//Setting/Getting parameters
	public boolean setBase(String hex){
		if (hex.length() == 6){
			int big = 0;
			base = colorToInts(hex);
			for (int i = 0; i < base.length; i++){
				if (base[i]>big){
					big = base[i];
					pivot = i;
				}
			}
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
	public boolean setPivot(int p){
		if (p <= 3 && p >= 1){
			pivot = p-1;
			return true;
		}
		return false;
	}
	
	public Vector<int []> getGenerated(){return generatedColors;}
	public String getBase(){return intsToColor(base);}
	public int getSteps(){return steps;}
	public int getStrength(){return strength;}
	public int getPivot(){return pivot;}

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
		base = new int[]{255,255,255};
		steps = 2;
		strength = 100;
		pivot = 0;
	}
	
	//Helpers (internal use)
	protected int[] intervals(int in){
		int[] out = new int[steps];
		for (int i = 0; i < steps; i++) out[i] = (int) (in - ((in*strength/100.0)/(steps-1))*i);
		return out;
	}
	protected int[] intervalsR(int in){
		int[] out = new int[steps];
		for (int i = 0; i < steps; i++) out[i] = (int) (in + (((255-in)*strength/100.0)/(steps-1))*i);
		return out;
	}
}
