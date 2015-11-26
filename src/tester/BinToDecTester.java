package tester;

import org.junit.Test;
import mainPackage.Utility;

public class BinToDecTester {
	@Test(expected = IllegalArgumentException.class)
	public void BinToDec_ToLongString_IllegalArgumentException() {
		Utility.BinToDec("1111111111111111111111111");

	}

	@Test(expected = IllegalArgumentException.class)
	public void BinToDec_StringWithIllegalCharacters_IllegalArgumentException() {
		Utility.BinToDec("11118131111");

	}
}
