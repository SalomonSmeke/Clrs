package me.clrs.salomon;

public class LinearGen extends onePointGen {

	public String nextColors() {
		generatedColors.clear();
		
		int []clrs = new int[steps];
		clrs = intervals(base[pivot]);

		for (int i = 0; i < steps; i++){
			switch (pivot){
			case (0):
				generatedColors.addElement(new int []{clrs[i],base[1],base[2]});
				break;
			case (1):
				generatedColors.addElement(new int []{base[0],clrs[i],base[2]});
				break;
			case (2):
				generatedColors.addElement(new int []{base[0],base[1],clrs[i]});
				break;
			default:
			}
			
		}
		return toString();
	}
	
	public String nextColorsR() {
		generatedColors.clear();
		
		int []clrs = new int[steps];
		clrs = intervalsR(base[pivot]);

		for (int i = 0; i < steps; i++){
			switch (pivot){
			case (0):
				generatedColors.addElement(new int []{clrs[i],base[1],base[2]});
				break;
			case (1):
				generatedColors.addElement(new int []{base[0],clrs[i],base[2]});
				break;
			case (2):
				generatedColors.addElement(new int []{base[0],base[1],clrs[i]});
				break;
			default:
			}
			
		}
		return toString();
	}
}