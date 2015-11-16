package tester;

import static org.junit.Assert.*;

import org.junit.*;
import mainPackage.*;

public class TestKlasse {
	@Test
	public void HexToDec_AlotOfStrings_AlotOfInts() {
		assertEquals(15, 		Convert.HexToDec("F"));
		assertEquals(10, 		Convert.HexToDec("A"));
		assertEquals(100, 		Convert.HexToDec("64"));
		assertEquals(1000, 		Convert.HexToDec("3E8"));
		assertEquals(12345, 	Convert.HexToDec("3039"));
		assertEquals(99999, 	Convert.HexToDec("1869F"));
		assertEquals(957103, 	Convert.HexToDec("E9AAF"));
		assertEquals(817374, 	Convert.HexToDec("C78DE"));
		assertEquals(182837, 	Convert.HexToDec("2CA35"));
		assertEquals(15432098, 	Convert.HexToDec("EB79A2"));
		
		
	}
	@Test
	public void DecToHex_AlotOfInts_AlotOfStringss() {
		assertEquals("F", 		Convert.DecToHex(15));
		assertEquals("A", 		Convert.DecToHex(10));
		assertEquals("64", 		Convert.DecToHex(100));
		assertEquals("3E8", 	Convert.DecToHex(1000));
		assertEquals("3039", 	Convert.DecToHex(12345));
		assertEquals("1869F", 	Convert.DecToHex(99999));
		assertEquals("E9AAF", 	Convert.DecToHex(957103));
		assertEquals("C78DE", 	Convert.DecToHex(817374));
		assertEquals("2CA35", 	Convert.DecToHex(182837));
		assertEquals("EB79A2", 	Convert.DecToHex(15432098));
		
	}
	@Test
	public void DecToBin_AlotOfInts_AlotOfStringss() {
		assertEquals("000000000000000000000101", Convert.DecToBin(5));
		assertEquals("000000000000000000000111", Convert.DecToBin(7));
		assertEquals("000000000000000000000000", Convert.DecToBin(0));
		assertEquals("000000000000000000010000", Convert.DecToBin(16));
		assertEquals("000000000000000001100100", Convert.DecToBin(100));
		assertEquals("000000000011000000111001", Convert.DecToBin(12345));
		assertEquals("000000011000011010011111", Convert.DecToBin(99999));
		assertEquals("111010110111100110100010", Convert.DecToBin(15432098));
		assertEquals("111111111111111111111111", Convert.DecToBin(16777215));
	}
	@Test
	public void BinToDec_AlotOfStringss_AlotOfInts() {
		assertEquals(5, 		Convert.BinToDec("000000000000000000000101"));
		assertEquals(7, 		Convert.BinToDec("000000000000000000000111"));
		assertEquals(0, 		Convert.BinToDec("000000000000000000000000"));
		assertEquals(16, 		Convert.BinToDec("000000000000000000010000"));
		assertEquals(16, 		Convert.BinToDec("000000000000000000010000"));
		assertEquals(100, 		Convert.BinToDec("000000000000000001100100"));
		assertEquals(12345, 	Convert.BinToDec("000000000011000000111001"));
		assertEquals(99999, 	Convert.BinToDec("000000011000011010011111"));
		assertEquals(15432098, 	Convert.BinToDec("111010110111100110100010"));
		assertEquals(16777215, 	Convert.BinToDec("111111111111111111111111"));
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void DecToBin_Int_IllegalArgumentException() {
		Convert.DecToBin(2147483647);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void DecToHex_Int_IllegalArgumentException() {
		Convert.DecToHex(2147483647);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void HexToDec_String_IllegalArgumentException() {
		Convert.HexToDec("FFFFFFFFFFFFFF");
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void BinToDec_String__IllegalArgumentException() {
		Convert.BinToDec("1111111111111111111111111");
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void HexToDec_StringWithIllegalCharacters_IllegalArgumentException() {
		Convert.HexToDec("ØÆÅ");
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void TestBinToDecIllegalCharacters() {
		Convert.BinToDec("11118131111");
		
	}
}
