package mainPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;





public class Data {
	HashMap<String,DataMedlem> dataListe;
	ArrayList<DataMedlem> duplikater;
	ArrayList<String> feilLogg;

	public Data() {
		dataListe = new HashMap<String,DataMedlem>();
		duplikater = new ArrayList<DataMedlem>();
		feilLogg = new ArrayList<String>();
	}

	public void ReadData(BufferedReader reader) throws IOException {
		String current;
		while ((current = reader.readLine()) != null) {
			try {
				String[] tokens = current.split("\\s+");
				if (tokens.length != 4) {
					feilLogg.add(			"Wrong amount of arguments in a line. Supposed to be 4, was " + tokens.length);
					break;
				}
				if (tokens[1].length() !=1 || (tokens[1].charAt(0)!='1'&&tokens[1].charAt(0)!='2')) {
					feilLogg.add(			"Operator must be \"1\" or \"2\" token was " + tokens[1]);
					break;
				}
				DataMedlem medlem = new DataMedlem(tokens[0], tokens[1].charAt(0), tokens[2], tokens[3]);
				
				for (int i = 0; i < dataListe.size(); i++) {
					if(dataListe.containsKey(medlem.getId())){
						duplikater.add(medlem);
						feilLogg.add("TRIED TO ADD DUPLICATE TO LIST! id: " + medlem.id);
						break;
					}
				}
				dataListe.put(tokens[0], medlem);
				
			} catch (Exception e) {
				feilLogg.add(e.toString());
			}
		}
	}

	public HashMap<String,DataMedlem> getDataListe() {
		return dataListe;
	}

	public ArrayList<DataMedlem> getDuplikater() {
		return duplikater;
	}

	public ArrayList<String> getFeilLogg() {
		return feilLogg;
	}

	public void CalculateData() {
		for(String key: dataListe.keySet()){
			get(key).calculate();
		}
	}
	public DataMedlem get(String id) {
		DataMedlem dt = dataListe.get(id);
		
		if (dt == null) {
			feilLogg.add("Can't find the specified id in the database. id: " + id);
			return null;
		}
		
		return dt;
		
	}
}
