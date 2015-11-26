package tester;

import org.junit.Test;

import mainPackage.Utility;

public class HexToDecTester {

	@Test(expected = IllegalArgumentException.class)
	public void HexToDec_ToBigHex_IllegalArgumentException() {
		Utility.HexToDec("FFFFFFFFFFFFFF");

	}
	@Test(expected = IllegalArgumentException.class)
	public void HexToDec_StringWithIllegalCharacters_IllegalArgumentException() {
		Utility.HexToDec("ØÆÅ");

	}
}
