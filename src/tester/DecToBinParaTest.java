package tester;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import mainPackage.Utility;

@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
public class DecToBinParaTest {
	private String binary;
	private int decimal;

	public DecToBinParaTest( String binary, String decimal ) {
		this.binary = binary;
		this.decimal = Integer.parseInt( decimal );
	}

	@org.junit.runners.Parameterized.Parameters
	public static java.util.Collection< String[] > input() {
		return java.util.Arrays.asList( new String[][]{
			{ "000000000000000000000000", "0" },
			{ "000000000000000000000101", "5" },
			{ "000000000000000000000111", "7" },
			{ "000000000000000000000000", "0" },
			{ "000000000000000000010000", "16" },
			{ "000000000000000001100100", "100" },
			{ "000000000011000000111001", "12345" },
			{ "000000011000011010011111", "99999" },
			{ "111010110111100110100010", "15432098" },
			{ "111111111111111111111111", "16777215" },
	} );
} 

	@org.junit.Test
	public void testBinaryToIntConversion() {
		assertThat( Utility.DecToBin( decimal ), is( binary ) );
	}
}