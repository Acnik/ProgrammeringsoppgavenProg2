package tester;

import static org.junit.Assert.*;

import org.junit.*;
import mainPackage.*;

public class TestKlasse {
	@Test
	public void TestHexToDec() {
		assertEquals(15, Convert.HexToDec("F"));
		assertEquals(10, Convert.HexToDec("A"));
		assertEquals(100, Convert.HexToDec("64"));
		assertEquals(1000, Convert.HexToDec("3E8"));
		assertEquals(12345, Convert.HexToDec("3039"));
		assertEquals(99999, Convert.HexToDec("1869F"));
		assertEquals(957103, Convert.HexToDec("E9AAF"));
		assertEquals(817374, Convert.HexToDec("C78DE"));
		assertEquals(182837, Convert.HexToDec("2CA35"));
		assertEquals(15432098, Convert.HexToDec("EB79A2"));
		
		
	}
	@Test
	public void TestDecToHex() {
		assertEquals("F", Convert.DecToHex(15));
		assertEquals("A", Convert.DecToHex(10));
		assertEquals("64", Convert.DecToHex(100));
		assertEquals("3E8", Convert.DecToHex(1000));
		assertEquals("3039", Convert.DecToHex(12345));
		assertEquals("1869F", Convert.DecToHex(99999));
		assertEquals("E9AAF", Convert.DecToHex(957103));
		assertEquals("C78DE", Convert.DecToHex(817374));
		assertEquals("2CA35", Convert.DecToHex(182837));
		assertEquals("EB79A2", Convert.DecToHex(15432098));
		
	}
	@Test
	public void TestDecToBin() {
		assertEquals("101", Convert.DecToBin(5));
		assertEquals("111", Convert.DecToBin(7));
		assertEquals("0", Convert.DecToBin(0));
		assertEquals("10000", Convert.DecToBin(16));
		assertEquals("1100100", Convert.DecToBin(100));
		assertEquals("11000000111001", Convert.DecToBin(12345));
		assertEquals("11000011010011111", Convert.DecToBin(99999));
		assertEquals("111010110111100110100010", Convert.DecToBin(15432098));
		assertEquals("111111111111111111111111", Convert.DecToBin(16777215));
	}
	@Test
	public void TestBinToDec() {
		assertEquals(5, Convert.BinToDec("101"));
		assertEquals(7, Convert.BinToDec("111"));
		assertEquals(0, Convert.BinToDec("0"));
		assertEquals(16, Convert.BinToDec("00010000"));
		assertEquals(16, Convert.BinToDec("10000"));
		assertEquals(100, Convert.BinToDec("1100100"));
		assertEquals(12345, Convert.BinToDec("11000000111001"));
		assertEquals(99999, Convert.BinToDec("11000011010011111"));
		assertEquals(15432098, Convert.BinToDec("111010110111100110100010"));
		assertEquals(16777215, Convert.BinToDec("111111111111111111111111"));
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void TestDecToBinToLargeInt() {
		Convert.DecToBin(2147483647);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void TestDecToHexToLargeInt() {
		Convert.DecToHex(2147483647);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void TestHexToDecToLargeInt() {
		Convert.HexToDec("FFFFFFFFFFFFFF");
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void TestBinToDecToLargeInt() {
		Convert.BinToDec("1111111111111111111111111");
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void TestHexToDecIllegalCharacters() {
		Convert.HexToDec("ØÆÅ");
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void TestBinToDecIllegalCharacters() {
		Convert.BinToDec("11118131111");
		
	}
}
