package me.clrs.salomon;

public class bridgeCGen extends DualPointGen {

	public bridgeCGen() {
		this.reset();
		currentSteps++;
	}

	public String[] nextColors() {
		if (currentColors != null)
			previousColors.add(currentColors);

		String[] out = new String[currentSteps + 1];

		float subtract1 = (getValuePerRGB(1, currentBaseColor1) - getValuePerRGB(
				1, currentBaseColor2)) / currentSteps;
		float subtract2 = (getValuePerRGB(2, currentBaseColor1) - getValuePerRGB(
				2, currentBaseColor2)) / currentSteps;
		float subtract3 = (getValuePerRGB(3, currentBaseColor1) - getValuePerRGB(
				3, currentBaseColor2)) / currentSteps;

		int baseR = getValuePerRGB(1, currentBaseColor1);
		int baseG = getValuePerRGB(2, currentBaseColor1);
		int baseB = getValuePerRGB(3, currentBaseColor1);

		for (int i = 0; i < out.length; i++) {

			out[i] = decToHex((int) (baseR - subtract1 * i));
			out[i] = out[i] + decToHex((int) (baseG - subtract2 * i));
			out[i] = out[i] + decToHex((int) (baseB - subtract3 * i));
		}

		currentColors = out;
		previousSteps.add(currentSteps);

		return currentColors;
	}

}
