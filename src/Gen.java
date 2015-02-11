import java.util.LinkedList;


abstract class Gen {
	protected LinkedList<String[]> previousColors;
	protected String [] currentColors;
	
	@Override
	public String toString() {
		if (currentColors == null) return null;
		String cat = "";
		for (int i = 0; i < currentColors.length; i++){
			cat+=currentColors[i]+'\n';
		}
		return cat.substring(0,cat.length()-1);
	}
	
	public String colorAt(int index) {
		if (index > previousColors.size()){
			return null;
		}
		String cat = "";
		for (int i = 0; i < previousColors.get(index).length; i++){
			cat+=previousColors.get(index)[i];
		}
		return cat;
	}
	
	public String[] colorsArray() {
		if (currentColors == null) return null;
		
		String[] out = new String [previousColors.size()+1];

		out[0] = this.toString();		
		for (int i = 0; i < previousColors.size(); i++){
			out[i+1] = this.colorAt(i);
		}
		return out;
	}

	protected short hexToDec(String hexadecimal){
		int d = Integer.valueOf(hexadecimal, 16);
		return (short)d;
	}
	
	protected String decToHex(int input){
		String out = Integer.toHexString(input);
		while (out.length()<2) out = "0"+out;
		return out;
	}
	
	protected short getValuePerRGB(int index, String inColorHex){
		String perRGBStr = inColorHex.substring((index-1)*2, (index)*2);
		return (short)hexToDec(perRGBStr);
	}
}
