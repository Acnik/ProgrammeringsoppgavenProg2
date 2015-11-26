package mainPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;



public class Data {
	SortedSet<DataMedlem> dataListe;
	ArrayList<DataMedlem> duplikater;
	ArrayList<String> feilLogg;

	public Data() {
		dataListe = new TreeSet<DataMedlem>();
		duplikater = new ArrayList<DataMedlem>();
		feilLogg = new ArrayList<String>();
	}

	public void ReadData(BufferedReader reader) throws IOException {
		String current = reader.readLine();
		outside:
		while ((current = reader.readLine()) != null) {
			try {
				String[] tokens = current.split("\\s+");
				if (tokens.length != 4) {
					feilLogg.add(			"Wrong amount of arguments in a line. Supposed to be 4, was " + tokens.length);
				}
				if (tokens[1].length() !=1 || (tokens[1].charAt(0)!='1'&&tokens[1].charAt(0)!='2')) {
					feilLogg.add(			"Operator must be \"1\" or \"2\" token was " + tokens[1]);
				}
				DataMedlem medlem = new DataMedlem(tokens[0], tokens[1].charAt(0), tokens[2], tokens[3]);
				tokens = null;
				//skjekke om duplikat
				if (dataListe == null) {
					dataListe.headSet(medlem).tailSet(medlem);
				}
				
				
				for (int i = 0; i < dataListe.size(); i++) {
					if(dataListe.contains(medlem)){
						duplikater.add(medlem);
						feilLogg.add("TRIED TO ADD DUPLICATE TO LIST! id: " + medlem.id);
					}
				}
				dataListe.add(medlem);
				
				
				
				
			} catch (Exception e) {
				feilLogg.add(e.toString());
				break outside;
				
			}
		}
	}

	public SortedSet<DataMedlem> getDataListe() {
		return dataListe;
	}

	public ArrayList<DataMedlem> getDuplikater() {
		return duplikater;
	}

	public ArrayList<String> getFeilLogg() {
		return feilLogg;
	}

	public void CalculateData() {
		for(DataMedlem d: dataListe ){
			try {
				d.calculate();
			} catch (Exception e) {
				feilLogg.add(e.toString());
			}
		}
	}
	public DataMedlem get(String id) {
		Iterator<DataMedlem> iterator = dataListe.iterator();
		while(iterator.hasNext()){
			DataMedlem dt = iterator.next();
			if (dt.getId().equals(id)) {
				return dt;
			}
		}
//		for(DataMedlem d: dataListe ){
//			if (id.equals(d.id)) {
//				return d;
//			}
//		}
		feilLogg.add("Can't find the specified id in the database. id: " + id);
		return null;
	}
}
