package tester;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import mainPackage.DataCollector;
import mainPackage.DataMember;

public class DuplicateTest {
	@Test
	public void TestDuplicate() throws IOException {
		BufferedReader reader = mock(BufferedReader.class);
		when(reader.readLine()).thenReturn(
				"03ac0f 1 110101000000110111001101 001000011110011101001111",
				"03ac0f 1 110101000000110111001101 001000011110011101001111",
				"03ac0f 1 110101000000110111001101 001000011110011101001111",
				"03ac0f 1 110101000000110111001101 001000011110011101001111",
				"ac0e1e 2 001000011110011101001111 000101010101010101111001",
				"ac0e1e 2 001000011110011101001111 000101010101010101111001", 
				null
				);
		DataCollector errData = new DataCollector();
		errData.ReadData(reader);
		errData.CalculateData();
		ArrayList<DataMember> dupList = errData.getDuplicates();

		ArrayList<DataMember> res = new ArrayList<DataMember>();

		res.add(new DataMember("03ac0f", '1', "110101000000110111001101", "001000011110011101001111"));
		res.add(new DataMember("03ac0f", '1', "110101000000110111001101", "001000011110011101001111"));
		res.add(new DataMember("03ac0f", '1', "110101000000110111001101", "001000011110011101001111"));
		res.add(new DataMember("ac0e1e", '2', "001000011110011101001111", "000101010101010101111001"));

		for (int i = 0; i < dupList.size(); i++) {
			assertTrue(res.get(i).equals(dupList.get(i)));
		}

	}
}
