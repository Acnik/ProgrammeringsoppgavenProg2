package tester;

import org.junit.Test;

import mainPackage.Utility;

public class BitWiseORTester {

	@Test(expected = IllegalArgumentException.class)
	public void BitWiseOR_ToLongString_IllegalArgumentException() {
		Utility.BitWiseOR("1111111111111111111111111", "1111111111111111111111111");

	}

	@Test(expected = IllegalArgumentException.class)
	public void BitWiseOR_FirstStringWithIllegalCharacters_IllegalArgumentException() {
		Utility.BitWiseOR("11121111111111111111", "1111111111111111111");

	}

	@Test(expected = IllegalArgumentException.class)
	public void BitWiseOR_SecondStringWithIllegalCharacters_IllegalArgumentException() {
		Utility.BitWiseOR("1111111111111111111", "111111a111111111111");

	}

	@Test(expected = IllegalArgumentException.class)
	public void BitWiseOR_FirstStringToLong_IllegalArgumentException() {
		Utility.BitWiseOR("111111111111101010111111", "11111111111111");

	}

	@Test(expected = IllegalArgumentException.class)
	public void BitWiseOR_SecondStringToLong_IllegalArgumentException() {
		Utility.BitWiseOR("111111111111111", "11111111111101010101111111");

	}
}
