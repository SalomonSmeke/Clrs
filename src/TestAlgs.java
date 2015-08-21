import me.clrs.salomon.BridgeGen;
import me.clrs.salomon.DistillGen;
import me.clrs.salomon.LinearGen;
import me.clrs.salomon.ShadeGen;

public class TestAlgs {

	public static void main(String[] args) {

		LinearGen L = new LinearGen();
		String LB = "ff47a0";
		L.setBase(LB);
		L.setPivot(2);
		L.setStrength(60);
		L.setSteps(4);
		L.nextColors();
		System.out.println("Linear\n" + L);
		
		DistillGen D = new DistillGen();
		String PB = "FF6464";
		D.setBase(PB);
		D.setStrength(100);
		D.nextColors();
		System.out.println("Distill\n" + D);

		ShadeGen S = new ShadeGen();
		String SB = "ff9090";
		S.setBase(SB);
		S.setStrength(9);
		String test = S.nextColors();
		System.out.println("Shade");
		System.out.println(test);

		BridgeGen B = new BridgeGen();
		String[] BB = new String[2];
		B.setSteps(7);
		BB[0] = "CB4226";
		BB[1] = "1D616D";
		B.setBases(BB);
		B.nextColors();
		System.out.println("Bridge\n" + B.toString());
	}
}