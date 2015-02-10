
public class pureCGen extends SinglePointGen{
	public String[] nextColors(){ 
		if (currentColors != null)previousColors.add(currentColors);
		
		currentColors = new String[currentSteps];

		String tempColor = reorderHex(currentBaseColor,changeableRGB);
		short [] intervals1 = calcIntervals(hexToDec(tempColor.substring(2, 4)));
		short [] intervals2 = calcIntervals(hexToDec(tempColor.substring(4, 6)));

		for(int i = 0; i < currentSteps; i++){
			currentColors[i] = tempColor.substring(0, 2) + decToHex(intervals1[i]) + decToHex(intervals2[i]);
			currentColors[i] = returnHex(currentColors[i],changeableRGB);
		}

		previousSteps.add(currentSteps);
		return currentColors;
	}
}
