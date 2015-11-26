package tester;

import org.junit.Test;

import mainPackage.Utility;

public class DecToBinTester {
	@Test(expected = IllegalArgumentException.class)
	public void DecToBin_ToBigInt_IllegalArgumentException() {
		Utility.DecToBin(2147483647);

	}

	@Test(expected = IllegalArgumentException.class)
	public void DecToBin_NegativeInt_IllegalArgumentException() {
		Utility.DecToBin(-83647);

	}
}
