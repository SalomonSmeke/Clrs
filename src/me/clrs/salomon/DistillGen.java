package me.clrs.salomon;

public class DistillGen extends onePointGen {
	
	public String nextColors() {
		generatedColors.clear();
		
		int one = 0;
		int two = 0;

		switch (pivot){
		case (0):
			one = 1;
			two = 2;
		case (1):
			one = 0;
			two = 2;
		case (2):
			one = 0;
			two = 1;
		default:
		}
		
		int []clrs = new int[steps];
		int []clrs2 = new int[steps];
		
		clrs = intervalsR(rgb[one]);
		clrs2 = intervalsR(rgb[two]);

		for (int i = 0; i < steps; i++){
			switch (pivot){
			case (0):
				generatedColors.addElement(new int []{rgb[0],clrs[i],clrs2[i]});
				break;
			case (1):
				generatedColors.addElement(new int []{clrs[i],rgb[1],clrs2[i]});
				break;
			case (2):
				generatedColors.addElement(new int []{clrs[i],clrs2[i],rgb[2]});
				break;
			default:
			}
			
		}
		return toString();
	}
	
	public String nextColorsR() {
		generatedColors.clear();
		
		int one = 0;
		int two = 0;

		switch (pivot){
		case (0):
			one = 1;
			two = 2;
		case (1):
			one = 0;
			two = 2;
		case (2):
			one = 0;
			two = 1;
		default:
		}
		
		int []clrs = new int[steps];
		int []clrs2 = new int[steps];
		
		clrs = intervals(rgb[one]);
		clrs2 = intervals(rgb[two]);

		for (int i = 0; i < steps; i++){
			switch (pivot){
			case (0):
				generatedColors.addElement(new int []{rgb[0],clrs[i],clrs2[i]});
				break;
			case (1):
				generatedColors.addElement(new int []{clrs[i],rgb[1],clrs2[i]});
				break;
			case (2):
				generatedColors.addElement(new int []{clrs[i],clrs2[i],rgb[2]});
				break;
			default:
			}
			
		}
		return toString();
	}
}