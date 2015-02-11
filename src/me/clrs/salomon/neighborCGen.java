package me.clrs.salomon;

import java.util.LinkedList;

public class neighborCGen extends DualPointGen {

	public neighborCGen() {
		this.reset();
		currentSteps++;
	}

	private boolean isValid(short[] check) {
		for (int i = 0; i < 3; i++)
			if (check[i] > 255 || check[i] < 0)
				return false;
		return true;
	}

	public String[] nextColors() {
		if (currentColors != null)
			previousColors.add(currentColors);

		if (currentBaseColor1.equals(currentBaseColor2))
			return null;

		float stepsR = (getValuePerRGB(1, currentBaseColor1) - getValuePerRGB(
				1, currentBaseColor2));
		float stepsG = (getValuePerRGB(2, currentBaseColor1) - getValuePerRGB(
				2, currentBaseColor2));
		float stepsB = (getValuePerRGB(3, currentBaseColor1) - getValuePerRGB(
				3, currentBaseColor2));

		int baseR = getValuePerRGB(1, currentBaseColor1);
		int baseG = getValuePerRGB(2, currentBaseColor1);
		int baseB = getValuePerRGB(3, currentBaseColor1);

		short[] testValues = new short[3];

		LinkedList<String> colors = new LinkedList<String>();

		String temp = "";

		int i = 0;
		while (true) {
			testValues[0] = (short) (baseR - (stepsR * i));
			testValues[1] = (short) (baseG - (stepsG * i));
			testValues[2] = (short) (baseB - (stepsB * i));
			if (isValid(testValues)) {
				for (int s = 0; s < 3; s++) {
					temp = temp + decToHex(testValues[s]);
				}
				colors.add(0, temp);
				i++;
				temp = "";
			} else {
				break;
			}
		}

		i = 1;
		while (true) {
			testValues[0] = (short) (baseR + (stepsR * i));
			testValues[1] = (short) (baseG + (stepsG * i));
			testValues[2] = (short) (baseB + (stepsB * i));
			if (isValid(testValues)) {
				for (int s = 0; s < 3; s++) {
					temp = temp + decToHex(testValues[s]);
				}
				colors.add(temp);
				i++;
				temp = "";
			} else {
				break;
			}
		}

		currentColors = colors.toArray(new String[colors.size()]);
		currentSteps = (byte) currentColors.length; // TODO LIMIT USING STEPS
		return currentColors;
	}

}
