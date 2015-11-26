package tester;

import org.junit.Test;

import mainPackage.Utility;

public class BitWiseANDTester {

	@Test(expected = IllegalArgumentException.class)
	public void BitWiseAND_SecondStringWithIllegalCharacters_IllegalArgumentException() {
		Utility.BitWiseAND("11111111111111111", "11111111111.111111");

	}

	@Test(expected = IllegalArgumentException.class)
	public void BitWiseAND_FirstStringToLong_IllegalArgumentException() {
		Utility.BitWiseAND("111111111111101010111111", "11111111111111");

	}

	@Test(expected = IllegalArgumentException.class)
	public void BitWiseAND_SecondStringToLong_IllegalArgumentException() {
		Utility.BitWiseAND("111111111111111", "11111111111101010101111111");

	}

	@Test(expected = IllegalArgumentException.class)
	public void BitWiseAnd_ToLongString_IllegalArgumentException() {
		Utility.BitWiseAND("1111111111111111111111111", "1111111111111111111111111");

	}

	@Test(expected = IllegalArgumentException.class)
	public void BitWiseAnd_FirstStringWithIllegalCharacters_IllegalArgumentException() {
		Utility.BitWiseAND("1111115411111111111111", "11111111111111111");

	}
}
