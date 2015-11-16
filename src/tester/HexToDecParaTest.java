package tester;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import mainPackage.Convert;

@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
public class HexToDecParaTest {
	private String binary;
	private int decimal;

	public HexToDecParaTest( String binary, String decimal ) {
		this.binary = binary;
		this.decimal = Integer.parseInt( decimal );
	}

	@org.junit.runners.Parameterized.Parameters
	public static java.util.Collection< String[] > input() {
		return java.util.Arrays.asList( new String[][]{
				{ "F", "15" },
				{ "A", "10" },
				{ "64", "100" },
				{ "3E8", "1000" },
				{ "3039", "12345" },
				{ "1869F", "99999" },
				{ "E9AAF", "957103" },
				{ "C78DE", "817374" },
				{ "2CA35", "182837" },
				{ "EB79A2", "15432098" },
		} );
	}

	@org.junit.Test
	public void testBinaryToIntConversion() {
		assertThat( Convert.HexToDec( binary ), is( decimal ) );
	}
}