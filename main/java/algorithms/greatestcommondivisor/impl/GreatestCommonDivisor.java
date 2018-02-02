package algorithms.greatestcommondivisor.impl;

public class GreatestCommonDivisor {

	private GreatestCommonDivisor() {}

	public static int calculate(int a, int b) {
		validValue(a);
		validValue(b);

		return gcdRecursive(a, b);
	}

	private static void validValue(int v) {
		if (v == 0 || v < 0) {
			throw new RuntimeException("Values must be greater that zero.");
		}
	}

	private static int gcdRecursive(int a, int b) {
		if (b == 0) {
			return a;
		}

		return gcdRecursive(b, a % b);
	}
}
