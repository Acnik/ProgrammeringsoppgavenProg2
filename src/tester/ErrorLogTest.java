package tester;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import mainPackage.DataCollector;

public class ErrorLogTest {
	@Test
	public void TestErrorLog() throws IOException {
		BufferedReader errReader = mock(BufferedReader.class);
		when(errReader.readLine()).thenReturn(
				"03ac0f 1 110101000000110111001101 001000011110011101001111",
				"ac0e1e 2 001000011110011101001111 000101010101010101111001",
				"ac0e1e 2 001000011110011101001111 000101010101010101111001",
				"ac0e1e 2 001000011110011101001111 000101010101010101111001",
				"asdasd 3 001000011110011101001111 000101010101010101111001",
				"asdas2 1 0010000111100111010011111 000101010101010101111001",
				"asdas3 1 001000011110011101001111 1000101010101010101111001",
				"asdasd 1 001000011110011101001111 000101010101010101111001", 
				"asdasd 000101010101010101111001",
				"asdasd 1 001000011110011101001111 000101010101010101111001 asd asd asd asd asdasdas a", null);
		DataCollector errData = new DataCollector();
		errData.ReadData(errReader);
		errData.CalculateData();
		ArrayList<String> log = errData.getErrorLog();

		ArrayList<String> res = new ArrayList<String>();
		res.add("TRIED TO ADD DUPLICATE TO LIST! id: ac0e1e");
		res.add("TRIED TO ADD DUPLICATE TO LIST! id: ac0e1e");
		res.add("Operator must be \"1\" or \"2\" token was 3");
		res.add("java.lang.IllegalArgumentException: Illegal characters in the argument. It must be from 0-9, A-Z. It was: S");

		for (int i = 0; i < log.size(); i++) {
			assertEquals(res.get(i), log.get(i));
		}

	}
}
