package me.clrs.salomon;

public class ShadeGen extends onePointGen{

	public String nextColors() {
		generatedColors.clear();
		//Create intervals on each value
		int []clrs0 = intervals(base[0]);
		int []clrs1 = intervals(base[1]);
		int []clrs2 = intervals(base[2]);

		for (int i = 0; i < steps; i++){
			generatedColors.add(new int[]{clrs0[i],clrs1[i],clrs2[i]});
		}
		return toString();
	}

	public String nextColorsR() {
		generatedColors.clear();

		int []clrs0 = intervals(base[0]);
		int []clrs1 = intervals(base[1]);
		int []clrs2 = intervals(base[2]);

		for (int i = 0; i < steps; i++){
			generatedColors.add(new int[]{clrs0[i],clrs1[i],clrs2[i]});
		}
		return toString();
	}
}
