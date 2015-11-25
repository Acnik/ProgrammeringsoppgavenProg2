package tester;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)

@Suite.SuiteClasses({
  DecToHexParaTest.class, 
  HexToDecParaTest.class,
  SpesifikkeFeilTester.class,
  BinToDecParaTest.class,
  DecToBinParaTest.class,
  BitWiseORParaTest.class,
  BitWiseANDParaTest.class,
  TestData.class}
)
public class TestSuite {
}