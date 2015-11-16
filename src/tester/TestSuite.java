package tester;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)

@Suite.SuiteClasses({
  DecToHexParaTest.class, 
  HexToDecParaTest.class,
  TestKlasse.class,}
)
public class TestSuite {
}