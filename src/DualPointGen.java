import java.util.LinkedList;


abstract class DualPointGen extends Gen{

	protected String currentBaseColor1;//STR Storing the current HEX1 base.
	protected String currentBaseColor2;//STR Storing the current HEX2 base.
	protected byte currentSteps;//BYTE Containing current step amount;
	
	public void reset(){
		previousColors = new LinkedList<String[]>();
		currentColors = null;
		currentBaseColor1 = "aa56ff";
		currentBaseColor2 = "ba59dd";
		currentSteps = 5;
	}
	
	public boolean setBases(String[] HEX){ 
		if (HEX.length!=2)return false;
		HEX[0] = HEX[0].trim();
		HEX[1] = HEX[1].trim();
		if (HEX[0].length()!=6 || HEX[1].length()!=6)return false;
		if (HEX[0] == HEX[1])return false;
		try
		{
			@SuppressWarnings("unused")
			int value1 = Integer.parseInt(HEX[0], 16); 
			@SuppressWarnings("unused")
			int value2 = Integer.parseInt(HEX[1], 16);
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
		currentBaseColor1 = HEX[0].toLowerCase();
		currentBaseColor2 = HEX[1].toLowerCase();
		return true;
	}

	public String[] getBase(){ 
		String[] out = new String[2];
		out[0]=currentBaseColor1;
		out[1]=currentBaseColor2;
		return out;
	}
	
	public byte getSteps(){return currentSteps;}
	
	
}
