import java.util.LinkedList;
import java.util.Random;


abstract class SinglePointGen extends Gen{
	
	protected String currentBaseColor;//STR Storing the current HEX base.
	protected byte changeableRGB;//BYTE Containing the color set to change r(1)g(2)b(3).
	protected float harsh;//FLOAT Containing the multiplier for how much currentBaseColor's valRGB will change.
	
	protected byte calcMost(String inColor) {
		Short [] rgbSplit = new Short [3];

		byte index = 0;
		int big = 0;

		for (short i = 0; i < rgbSplit.length; i++){
			rgbSplit [i] = getValuePerRGB(i+1, inColor);
			if (rgbSplit [i]>big){
				big = rgbSplit [i];
				index = (byte)(i+1);
			}
		}
		return index;
	}
	
	protected String reorderHex(String in, int pullFront){
		LinkedList<String> rgb = new LinkedList<String>();

		for (short i = 0; i < 3; i++){
			if(i==pullFront-1){
				rgb.add(0, in.substring(i*2, (i+1)*2));
			} else {
				rgb.add(in.substring(i*2, (i+1)*2));
			}
		}
		return rgb.get(0)+rgb.get(1)+rgb.get(2);
	}

	protected String returnHex(String in, int returnPos){
		LinkedList<String> rgb = new LinkedList<String>();
		String val = in.substring(0,2);

		for (short i = 1; i < 3; i++) rgb.add(in.substring(i*2, (i+1)*2));

		rgb.add(returnPos-1, val);
		return rgb.get(0)+rgb.get(1)+rgb.get(2);
	}

	public void reset(){
		Random R = new Random();
		previousColors = new LinkedList<String[]>();
		previousSteps = new LinkedList<Byte>();
		currentColors = null;
		currentBaseColor = "ffffff";
		currentSteps = 5;
		changeableRGB = (byte)(R.nextInt(3)+1);
		harsh = 1;
	}

	protected short[] calcIntervals(short input){
		short [] out = new short[currentSteps];

		for (int i = 0; i < currentSteps; i++) out[i]=(short)(input-((input*harsh)/(currentSteps-1)*i));

		return out;
	}
	
	protected short[] calcIntervalsR(short input) {
		short [] out = new short[currentSteps];
		
		int mod = 255-input;

		for (int i = 0; i < currentSteps; i++) out[i]=(short)(input+((mod*harsh)/(currentSteps-1)*i));

		return out;
	}
	
	public boolean setBase(String HEX){
		HEX = HEX.trim();
		if (HEX.length()!=6)return false;
		try
		{
			@SuppressWarnings("unused")
			int value = Integer.parseInt(HEX, 16); 
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
		currentBaseColor = HEX.toLowerCase();
		changeableRGB = calcMost(currentBaseColor);
		return true;
	}
	
	public boolean setEditable(byte RGB){
		if (RGB == 1 || RGB == 2 || RGB == 3){
			changeableRGB = RGB;
			return true;
		}
		return false;
	}
	public boolean setHarshness(float harshness){
		while (harshness > 1)harshness = harshness/10;
		if (harshness < .2)return false;
		
		harsh = harshness;
		return true;
	}
	
	public String getBase(){return currentBaseColor;}
	public byte getEditable(){return changeableRGB;}
	public float getHarshness(){return harsh;}
}
