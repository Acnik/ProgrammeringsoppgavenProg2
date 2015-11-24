package tester;

import org.junit.*;
import mainPackage.*;

public class TestKlasse {

	 @Test(expected = IllegalArgumentException.class)
	public void DecToBin_ToBigInt_IllegalArgumentException() {
		Utility.DecToBin(2147483647);

	}
	 @Test(expected = IllegalArgumentException.class)
	public void DecToBin_NegativeInt_IllegalArgumentException() {
		Utility.DecToBin(-83647);

	}
	@Test(expected = IllegalArgumentException.class)
	public void DecToHex_ToBigInt_IllegalArgumentException() {
		Utility.DecToHex(2147483647);

	}
	 @Test(expected = IllegalArgumentException.class)
	public void DecToHex_NegativeInt_IllegalArgumentException() {
		Utility.DecToHex(-83647);

	}
	@Test(expected = IllegalArgumentException.class)
	public void HexToDec_ToBigHex_IllegalArgumentException() {
		Utility.HexToDec("FFFFFFFFFFFFFF");

	}
	@Test(expected = IllegalArgumentException.class)
	public void BinToDec_ToLongString_IllegalArgumentException() {
		Utility.BinToDec("1111111111111111111111111");

	}
	@Test(expected = IllegalArgumentException.class)
	public void BinToDec_StringWithIllegalCharacters_IllegalArgumentException() {
		Utility.BinToDec("11118131111");

	}
	@Test(expected = IllegalArgumentException.class)
	public void HexToDec_StringWithIllegalCharacters_IllegalArgumentException() {
		Utility.HexToDec("ØÆÅ");

	}
	@Test(expected = IllegalArgumentException.class)
	public void BitWiseOr_ToLongString_IllegalArgumentException() {
		Utility.BitWiseOR("1111111111111111111111111", "1111111111111111111111111");

	}
	@Test(expected = IllegalArgumentException.class)
	public void BitWiseAnd_ToLongString_IllegalArgumentException() {
		Utility.BitWiseAND("1111111111111111111111111", "1111111111111111111111111");

	}
	@Test(expected = IllegalArgumentException.class)
	public void BitWiseOr_FirstStringWithIllegalCharacters_IllegalArgumentException() {
		Utility.BitWiseOR("11121111111111111111", "1111111111111111111");

	}
	@Test(expected = IllegalArgumentException.class)
	public void BitWiseAnd_FirstStringWithIllegalCharacters_IllegalArgumentException() {
		Utility.BitWiseAND("1111115411111111111111", "11111111111111111");

	}
	@Test(expected = IllegalArgumentException.class)
	public void BitWiseOr_SecondStringWithIllegalCharacters_IllegalArgumentException() {
		Utility.BitWiseOR("1111111111111111111", "111111a111111111111");

	}
	@Test(expected = IllegalArgumentException.class)
	public void BitWiseAnd_SecondStringWithIllegalCharacters_IllegalArgumentException() {
		Utility.BitWiseAND("11111111111111111", "11111111111.111111");

	}
}
