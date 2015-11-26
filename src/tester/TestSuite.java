package tester;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)

@Suite.SuiteClasses({
	BinToDecTester.class,
	DecToBinTester.class,
	HexToDecTester.class,
	DecToHexTester.class,
	BitWiseANDTester.class,
	BitWiseORTester.class,
	DecToHexParaTest.class, 
	HexToDecParaTest.class,
	BinToDecParaTest.class,
	DecToBinParaTest.class,
	BitWiseORParaTest.class,
	BitWiseANDParaTest.class,
	ErrorLogTest.class,
	DuplicateTest.class,
	TestData.class}
)
public class TestSuite {
}