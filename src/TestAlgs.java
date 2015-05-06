import me.clrs.salomon.BridgeGen;
import me.clrs.salomon.DistillGen;
import me.clrs.salomon.LinearGen;
import me.clrs.salomon.ShadeGen;

public class TestAlgs {

	public static void main(String[] args) {

		LinearGen L = new LinearGen();
		String LB = "FF6464";
		L.setBase(LB);
		L.setPivot(3);
		L.setStrength(100);
		L.setSteps(5);
		L.nextColors();
		System.out.println("Linear\n" + L);
		
		DistillGen D = new DistillGen();
		String PB = "FF6464";
		D.setBase(PB);
		D.setStrength(100);
		D.nextColors();
		System.out.println("Distill\n" + D);

		ShadeGen S = new ShadeGen();
		String SB = "D12236";
		S.setBase(SB);
		S.setStrength(9);
		String test = S.nextColors();
		System.out.println("Shade");
		System.out.println(test);

		BridgeGen B = new BridgeGen();
		String[] BB = new String[2];
		B.setSteps(255);
		BB[0] = "5ED49D";
		BB[1] = "F567C3";
		B.setBases(BB);
		B.nextColors();
		System.out.println("Bridge\n" + B.toString());
	}
}