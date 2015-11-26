package mainPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DataCollector {
	HashMap<String, DataMember> dataMap;
	ArrayList<DataMember> duplicates;
	ArrayList<String> errorLog;

	public DataCollector() {
		dataMap = new HashMap<String, DataMember>();
		duplicates = new ArrayList<DataMember>();
		errorLog = new ArrayList<String>();
	}

	public void ReadData(BufferedReader reader) throws IOException {
		String current;
		while ((current = reader.readLine()) != null) {
			try {
				String[] tokens = current.split("\\s+");
				if (tokens.length != 4) {
					errorLog.add("Wrong amount of arguments in a line. Supposed to be 4, was " + tokens.length);
					break;
				}
				if (tokens[1].length() != 1 || (tokens[1].charAt(0) != '1' && tokens[1].charAt(0) != '2')) {
					errorLog.add("Operator must be \"1\" or \"2\" token was " + tokens[1]);
					break;
				}
				DataMember member = new DataMember(tokens[0], tokens[1].charAt(0), tokens[2], tokens[3]);

				for (int i = 0; i < dataMap.size(); i++) {
					if (dataMap.containsKey(member.getId())) {
						duplicates.add(member);
						errorLog.add("TRIED TO ADD DUPLICATE TO LIST! id: " + member.id);
						break;
					}
				}
				dataMap.put(tokens[0], member);

			} catch (Exception e) {
				errorLog.add(e.toString());
			}
		}
	}

	public HashMap<String, DataMember> getDataMap() {
		return dataMap;
	}

	public ArrayList<DataMember> getDuplicates() {
		return duplicates;
	}

	public ArrayList<String> getErrorLog() {
		return errorLog;
	}

	public void CalculateData() {
		for (String key : dataMap.keySet()) {
			get(key).calculate();
		}
	} 

	public DataMember get(String id) {
		DataMember dt = dataMap.get(id);

		if (dt == null) {
			errorLog.add("Can't find the specified id in the database. id: " + id);
			return null;
		}

		return dt;

	}
}
