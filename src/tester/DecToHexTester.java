package tester;

import org.junit.Test;

import mainPackage.Utility;

public class DecToHexTester {
	@Test(expected = IllegalArgumentException.class)
	public void DecToHex_ToBigInt_IllegalArgumentException() {
		Utility.DecToHex(2147483647);

	}

	@Test(expected = IllegalArgumentException.class)
	public void DecToHex_NegativeInt_IllegalArgumentException() {
		Utility.DecToHex(-83647);

	}
}
