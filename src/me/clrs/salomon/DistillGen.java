package me.clrs.salomon;

public class DistillGen extends onePointGen {
	
	public String nextColors() {
		generatedColors.clear();
		int one = 0;
		int two = 0;
		//Selecting which colors are edited based on the pivot
		switch (pivot){
		case (0):
			one = 1; //g
			two = 2; //b
			break;
		case (1):
			one = 0; //r
			two = 2; //b
			break;
		case (2):
			one = 0; //r
			two = 1; //g
			break;
		default:
		}
		
		int []clrs = intervals(base[one]);
		int []clrs2 = intervals(base[two]);

		for (int i = 0; i < steps; i++){
			switch (pivot){
			case (0):
				generatedColors.addElement(new int []{base[0],clrs[i],clrs2[i]});
				break;
			case (1):
				generatedColors.addElement(new int []{clrs[i],base[1],clrs2[i]});
				break;
			case (2):
				generatedColors.addElement(new int []{clrs[i],clrs2[i],base[2]});
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
		
		int []clrs = intervalsR(base[one]);
		int []clrs2 = intervalsR(base[two]);

		for (int i = 0; i < steps; i++){
			switch (pivot){
			case (0):
				generatedColors.addElement(new int []{base[0],clrs[i],clrs2[i]});
				break;
			case (1):
				generatedColors.addElement(new int []{clrs[i],base[1],clrs2[i]});
				break;
			case (2):
				generatedColors.addElement(new int []{clrs[i],clrs2[i],base[2]});
				break;
			default:
			}
		}
		return toString();
	}
}