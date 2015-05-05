package me.clrs.salomon;

public class ShadeGen extends onePointGen{

	public String nextColors() {
		generatedColors.clear();
		
		int []clrs0 = new int[steps];
		int []clrs1 = new int[steps];
		int []clrs2 = new int[steps];
		
		clrs0 = intervals(rgb[0]);
		clrs1 = intervals(rgb[1]);
		clrs2 = intervals(rgb[2]);

		for (int i = 0; i < steps; i++){
			generatedColors.add(new int[]{clrs0[i],clrs1[i],clrs2[2]});
		}
		return toString();
	}
	
	public String nextColorsR() {
		generatedColors.clear();
		
		int []clrs0 = new int[steps];
		int []clrs1 = new int[steps];
		int []clrs2 = new int[steps];
		
		clrs0 = intervalsR(rgb[0]);
		clrs1 = intervalsR(rgb[1]);
		clrs2 = intervalsR(rgb[2]);

		for (int i = 0; i < steps; i++){
			generatedColors.add(new int[]{clrs0[i],clrs1[i],clrs2[2]});
		}
		return toString();
	}
}