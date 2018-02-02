package algorithms;

import algorithms.greatestcommondivisor.impl.GreatestCommonDivisor;
import org.junit.Assert;
import org.junit.Test;

public class GreatestCommonDivisiorTest {

	@Test
	public void calc_42_56_Test() {
		Assert.assertEquals(GreatestCommonDivisor.calculate(42, 56), 14);
	}

	@Test
	public void calc_192_348_Test() {
		Assert.assertEquals(GreatestCommonDivisor.calculate(192, 348), 12);
	}

	@Test
	public void calc_7_7_Test() {
		Assert.assertEquals(GreatestCommonDivisor.calculate(7, 7), 7);
	}

	@Test
	public void calc_20_30_Test() {
		Assert.assertEquals(GreatestCommonDivisor.calculate(20, 30), 10);
	}

	@Test(expected = RuntimeException.class)
	public void zeroAsFirstParameterTest() {
		GreatestCommonDivisor.calculate(0, 7);
	}

	@Test(expected = RuntimeException.class)
	public void zeroAsSecondParameterTest() {
		GreatestCommonDivisor.calculate(7, 0);
	}

	@Test(expected = RuntimeException.class)
	public void minusAsFirstParameterTest() {
		GreatestCommonDivisor.calculate(-7, 7);
	}

	@Test(expected = RuntimeException.class)
	public void minusAsSecondParameterTest() {
		GreatestCommonDivisor.calculate(7, -7);
	}
}
