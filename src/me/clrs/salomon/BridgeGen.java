package me.clrs.salomon;

public class BridgeGen extends twoPointGen {

	@Override
	public String nextColors() {
		generatedColors.clear();
		
		int []clrs0 = new int[steps]; //r
		int []clrs1 = new int[steps]; //g
		int []clrs2 = new int[steps]; //b
		
		clrs0 = intervals(base0[0],base1[0]); //r interval between one base and the other
		clrs1 = intervals(base0[1],base1[1]); //g ""
		clrs2 = intervals(base0[2],base1[2]); //b ""
		
		for (int i = 0; i < steps; i++){
			generatedColors.addElement(new int []{clrs0[i],clrs1[i],clrs2[i]});
		}
		return toString();
	}
}