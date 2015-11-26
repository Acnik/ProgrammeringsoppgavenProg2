package tester;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import mainPackage.Utility;

@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
public class BitWiseANDParaTest {
	private String input1;
	private String input2;
	private String result;

	public BitWiseANDParaTest( String input1, String input2, String result ) {
		this.input1 = input1;
		this.input2 = input2;
		this.result = result;
	} 

	@org.junit.runners.Parameterized.Parameters
	public static java.util.Collection< String[] > input() {
		return java.util.Arrays.asList( new String[][]{
			{ 	"000000000000000000000000", 
				"000000000000000000000000", 
				"000000000000000000000000"
				},
			{ 	"111111111111111111111111", 
				"000000000000000000000000", 
				"000000000000000000000000"
				},
			{ 	"000000000000000000000000", 
 				"111111111111111111111111", 
				"000000000000000000000000"
				},
			{ 	"010101010101010101010101", 
				"101010101010101010101010", 
				"000000000000000000000000"
				},
			{ 	"010101010001010100101011", 
				"110100010010100100101010", 
				"010100010000000100101010"
				},
			{ 	"000000011110101010101011", 
				"011110111011010101111010", 
				"000000011010000000101010"
				},
			{ 	"010111011010010101001000", 
				"001011011101011001010010", 
				"000011011000010001000000"
				},
			{ 	"101010000101010010100101", 
				"111010010000010101001011", 
				"101010000000010000000001"
				},
			{ 	"011100101010001010010101", 
				"000101011111010010110101", 
				"000100001010000010010101"
				},
			{ 	"111111111111111111111111", 
				"111111111111111111111111", 
				"111111111111111111111111"
				},
	} );
}

	@org.junit.Test
	public void testBinaryToIntConversion() {
		assertThat( Utility.BitWiseAND(input1, input2), is( result) );
	}
}