
public class linearCGen extends SinglePointGen{
	
	public linearCGen(){
		this.reset();
	}
	
	public String[] nextColors(){
		if (currentColors != null)previousColors.add(currentColors);
		
		String tempColor = reorderHex(currentBaseColor,changeableRGB);
		short [] intervals = calcIntervals(hexToDec(tempColor.substring(0, 2)));

		currentColors = new String [currentSteps];

		for(int i = 0; i < currentSteps; i++){
			currentColors[i]= decToHex(intervals[i])+tempColor.substring(2, 6);
			currentColors[i] = returnHex(currentColors[i],changeableRGB);
		}
		
		previousSteps.add(currentSteps);
		return currentColors;
	}
	
	public String[] nextColorsR(){
		if (currentColors != null)previousColors.add(currentColors);
		
		String tempColor = reorderHex(currentBaseColor,changeableRGB);
		short [] intervals = calcIntervalsR(hexToDec(tempColor.substring(0, 2)));

		currentColors = new String [currentSteps];

		for(int i = 0; i < currentSteps; i++){
			currentColors[i]= decToHex(intervals[i])+tempColor.substring(2, 6);
			currentColors[i] = returnHex(currentColors[i],changeableRGB);
		}
		
		previousSteps.add(currentSteps);
		return currentColors;
	}
}
