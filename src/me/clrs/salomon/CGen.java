package me.clrs.salomon;

public interface CGen {
	@Override
	public String toString();
	
	public void clear();
	
	public String nextColors();
	
	public boolean setSteps(int s);
	
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
