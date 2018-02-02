package algorithms.greatestcommondivisor;

import algorithms.greatestcommondivisor.impl.GreatestCommonDivisor;

public class Example {

	public static void main(String[] args) {
		int a = 42;
		int b = 56;

		System.out.print("GCD(" + a + ", " + b + ") = ");
		System.out.println(GreatestCommonDivisor.calculate(a, b));
	}
}
