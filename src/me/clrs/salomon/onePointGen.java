package me.clrs.salomon;

import java.util.Vector;

abstract class onePointGen implements CGen{

	//Color Storage
	Vector<int []> generatedColors = new Vector<int []>();

	//Color Storage
	protected int[] rgb = new int[]{255,255,255};

	//Parameters
	protected int steps = 2;
	protected int strength = 100;
	protected int pivot = 0;

	protected int[] intervals(int in){
		int[] out = new int[steps];
		for (int i = 0; i < steps; i++) out[i] = in - ((in*strength/100)/steps)*i;
		return out;
	}
	
	protected int[] intervalsR(int in){
		int[] out = new int[steps];
		for (int i = 0; i < steps; i++) out[i] = in + (((255-in)*strength/100)/steps)*i;
		return out;
	}
	
	@Override
	public String toString(){
		String out = "";
		int [] temp;
		for (int i = 0; i < generatedColors.size(); i++){
			temp = generatedColors.get(i);
			for (int j = 0; j < rgb.length; j++){
				out += temp[j];
			}
			out += '\n';
		}
		return out;
	}
	
	public void clear() {
		generatedColors.clear();
		rgb = new int[]{255,255,255};
		steps = 2;
		strength = 100;
		pivot = 0;
	}

	//Setting/Getting parameters
	
	public boolean setBase(String hex){
		if (hex.length() == 6){
			int big = 0;
			rgb = colorToInts(hex);
			for (int i = 0; i < rgb.length; i++){
				if (rgb[i]>big){
					big = rgb[i];
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

	public String getBase(){return intsToColor(rgb);}
	public int getSteps(){return steps;}
	public int getStrength(){return strength;}
	public int getPivot(){return pivot;}
}
