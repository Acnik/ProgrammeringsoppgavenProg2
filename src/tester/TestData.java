package tester;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.*;
import mainPackage.*;
import static org.junit.Assert.*;

public class TestData {
	private static Data data;
	@Before
	public void Initializer() throws IOException{
		BufferedReader reader = mock(BufferedReader.class); 
		when( reader.readLine() ).thenReturn(
			    "03ac0f 1 110101000000110111001101 001000011110011101001111",
			    "ac0e1e 2 001000011110011101001111 000101010101010101111001", 
			    null 
		); 
		data = new Data();
		data.ReadData(reader);
		data.CalculateData();
	}
	@Test
	public void GetId() {
		assertEquals(data.get("03ac0f").getId(),"03ac0f");
		assertEquals(data.get("ac0e1e").getId(),"ac0e1e");
		
	}
	@Test
	public void GetInput1() {
		assertEquals(data.get("03ac0f").getInput1(), "110101000000110111001101");
		assertEquals(data.get("ac0e1e").getInput1(), "001000011110011101001111");
		
	}
	@Test
	public void GetInput2() {
		assertEquals(data.get("03ac0f").getInput2(), "001000011110011101001111");
		assertEquals(data.get("ac0e1e").getInput2(), "000101010101010101111001");
		
	}
	@Test
	public void GetBinRes() {
		assertEquals("000000000000010101001101",	data.get("03ac0f").getBinRes());
		assertEquals("001101011111011101111111",	data.get("ac0e1e").getBinRes());
		
	}
	@Test
	public void GetDecRes() {
		assertEquals((int)data.get("03ac0f").getDecRes(), 1357);
		assertEquals((int)data.get("ac0e1e").getDecRes(), 3536767);
		
	}
	@Test
	public void GetHexRes() {
		assertEquals("54D",		data.get("03ac0f").getHexRes());
		assertEquals("35F77F",	data.get("ac0e1e").getHexRes());
		
	}

}
