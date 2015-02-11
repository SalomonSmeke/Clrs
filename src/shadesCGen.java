
public class shadesCGen extends SinglePointGen {
	
	
	public shadesCGen(){
		this.reset();
	}
	
	public String[] nextColors(){ 
		if (currentColors != null)previousColors.add(currentColors);
		
		currentColors = new String[currentSteps];

		short [] intervals0 = calcIntervals(hexToDec(currentBaseColor.substring(0, 2)));
		short [] intervals1 = calcIntervals(hexToDec(currentBaseColor.substring(2, 4)));
		short [] intervals2 = calcIntervals(hexToDec(currentBaseColor.substring(4, 6)));

		for(int i = 0; i < currentSteps; i++)currentColors[i] =  decToHex(intervals0[i]) + decToHex(intervals1[i]) + decToHex(intervals2[i]);

		previousSteps.add(currentSteps);
		return currentColors;
	}
}