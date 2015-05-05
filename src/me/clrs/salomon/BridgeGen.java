package me.clrs.salomon;

public class BridgeGen extends twoPointGen {

	@Override
	public String nextColors() {
		generatedColors.clear();
		
		int []clrs0 = new int[steps];
		int []clrs1 = new int[steps];
		int []clrs2 = new int[steps];
		
		clrs0 = intervals(rgb0[0],rgb1[0]);
		clrs1 = intervals(rgb0[1],rgb1[1]);
		clrs2 = intervals(rgb0[2],rgb1[2]);
		
		for (int i = 0; i < steps; i++){
			generatedColors.addElement(new int []{clrs0[i],clrs1[i],clrs2[i]});
		}

		return toString();
	}

}