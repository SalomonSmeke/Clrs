package me.clrs.salomon;

public class LinearGen extends onePointGen {

	public String nextColors() {
		generatedColors.clear();
		
		int []clrs = new int[steps];
		clrs = intervals(rgb[pivot]);

		for (int i = 0; i < steps; i++){
			switch (pivot){
			case (0):
				generatedColors.addElement(new int []{clrs[i],rgb[1],rgb[2]});
				break;
			case (1):
				generatedColors.addElement(new int []{rgb[0],clrs[i],rgb[2]});
				break;
			case (2):
				generatedColors.addElement(new int []{rgb[0],rgb[1],clrs[i]});
				break;
			default:
			}
			
		}
		return toString();
	}
	
	public String nextColorsR() {
		generatedColors.clear();
		
		int []clrs = new int[steps];
		clrs = intervalsR(rgb[pivot]);

		for (int i = 0; i < steps; i++){
			switch (pivot){
			case (0):
				generatedColors.addElement(new int []{clrs[i],rgb[1],rgb[2]});
				break;
			case (1):
				generatedColors.addElement(new int []{rgb[0],clrs[i],rgb[2]});
				break;
			case (2):
				generatedColors.addElement(new int []{rgb[0],rgb[1],clrs[i]});
				break;
			default:
			}
			
		}
		return toString();
	}
}