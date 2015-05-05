import me.clrs.salomon.bridgeCGen;
import me.clrs.salomon.linearCGen;
import me.clrs.salomon.neighborCGen;
import me.clrs.salomon.pureCGen;
import me.clrs.salomon.shadesCGen;

public class TestAlgs {

	public static void main(String[] args) {

		/*
		 * Usage of one data point generators: SetBase - Will set the data point
		 * (starting point) SetEditable - Will select which color (RGB) will be
		 * edited. (Pure & Linear ONLY) SetHarshness - Will select the % of
		 * diversion from base color SetSteps - Will select the amount of colors
		 * (including base) NextColors - Will create the next set of colors
		 * based on ^ NextColorsR - Will create the reversed set of colors
		 * (reverse algorithm)
		 */
		
		//Set variation (50%) generate- R50GB R-50GB RG50B RG-50B RGB50 RGB-50 [RG]50B [RG]-50B R50GB50 R-50GB-50
		
		linearCGen L = new linearCGen();
		String LB = "FF6464";
		L.setBase(LB);
		L.setEditable((byte) 3);
		L.setHarshness(1);
		L.setSteps((byte) 5);
		L.nextColors();
		System.out.println("Linear\n" + L + "\n");
		

		pureCGen P = new pureCGen();
		String PB = "FF6464";
		P.setBase(PB);
		P.setHarshness(1);
		P.nextColors();
		System.out.println("Pure\n" + P + "\n");

		shadesCGen S = new shadesCGen();
		String SB = "D12236";
		S.setBase(SB);
		S.setHarshness(9);
		String[] test = S.nextColorsR();
		System.out.println("Shades");
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
		System.out.println();

		/*
		 * Usage of two data point generators:
		 */

		neighborCGen N = new neighborCGen();
		String[] NB = new String[2];
		N.setSteps((byte) 3);
		NB[0] = "C97186";
		NB[1] = "F5631A";
		N.setBases(NB);
		N.nextColors();
		System.out.println("Neighbor\n" + N.toString() + "\n");

		bridgeCGen B = new bridgeCGen();
		String[] BB = new String[2];
		B.setSteps((byte) 3);
		BB[0] = "5ED49D";
		BB[1] = "F567C3";
		B.setBases(BB);
		B.nextColors();
		System.out.println("Bridge\n" + B.toString() + "\n");
	}
}