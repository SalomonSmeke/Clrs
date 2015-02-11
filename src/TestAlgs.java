public class TestAlgs {

	public static void main(String[] args) {

		/*
		 * Usage of one data point generators:
		 * SetBase - Will set the data point (starting point)
		 * SetEditable - Will select which color (RGB) will be edited. (Pure & Linear ONLY)
		 * SetHarshness - Will select the % of diversion from base color
		 * SetSteps - Will select the amount of colors (including base)
		 * NextColors - Will create the next set of colors based on ^
		 * NextColorsR - Will create the reversed set of colors (reverse algorithm) 
		 */
		linearCGen L = new linearCGen();
		String LB = "D91348";
		L.setBase(LB);
		L.setEditable((byte) 1);
		L.setHarshness(9);
		L.setSteps((byte) 5);
		L.nextColors();
		System.out.println(L);
		
		pureCGen P = new pureCGen();
		String PB = "D91348";
		P.setBase(PB);
		P.nextColorsR();
		System.out.println(P);
		
		shadesCGen S = new shadesCGen();
		String SB = "D91348";
		S.setBase(SB);
		String[] test = S.nextColors();
		for (int i = 0; i<test.length; i++){
			System.out.println(test[i]);
		}

		
		/*
		 * Usage of two data point generators: 
		 */
		
		
		
//		LWGenNeighbors N = new LWGenNeighbors();
//		String[] NB = new String[2];
//		NB[0] = "1CA6B0";
//		NB[1] = "09879E";
//		N.setNeighbors(NB);
//		
//		N.nextColors();
//		
//		System.out.println(N.toString());		
//		LWGenBridge B = new LWGenBridge();
//		String[] BB = new String[2];
//		B.setSteps((byte) 3);
//		BB[0] = "E5ABCD";
//		BB[1] = "19E417";
//		B.setBases(BB);
//		
//		B.nextColors();
//		
//		System.out.println(B.toString());
	}
}