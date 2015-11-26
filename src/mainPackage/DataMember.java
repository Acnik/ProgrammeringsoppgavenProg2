package mainPackage;

import java.awt.IllegalComponentStateException;

public class DataMember implements Comparable<DataMember> {
	public String id;
	public Character operator;
	public String input1;
	public String input2;
	public String binRes;
	public Integer decRes;
	public String hexRes;
	public boolean calculated;

	public DataMember() {
		id = input1 = input2 = binRes = hexRes = null;
		decRes = null;
		operator = null;
		calculated = false;
	}

	public DataMember(String id, Character operator, String input1, String input2) {
		this.id = id;
		this.operator = operator;
		this.input1 = input1;
		this.input2 = input2;
		calculated = false;
	}

	public void calculate() {
		if (!calculated) {
			if (operator == '1') {
				binRes = Utility.BitWiseAND(input1, input2);
				decRes = Utility.BinToDec(binRes);
				hexRes = Utility.DecToHex(decRes);
				calculated = true;
			}
			if (operator == '2') {
				binRes = Utility.BitWiseOR(input1, input2);
				decRes = Utility.BinToDec(binRes);
				hexRes = Utility.DecToHex(decRes);
				calculated = true;

			}
		} else {
			throw new IllegalComponentStateException("Data id: " + id + " is already calculated. did nothing to it.");
		}

	}

	public String getId() {
		return id;
	}

	public Character getOperator() {
		return operator;
	}

	public String getInput1() {
		return input1;
	}

	public String getInput2() {
		return input2;
	}

	public String getBinRes() {
		return binRes;
	}

	public Integer getDecRes() {
		return decRes;
	}

	public String getHexRes() {
		return hexRes;
	}

	public boolean isCalculated() {
		return calculated;
	}

	@Override
	public int compareTo(DataMember o) {
		return Integer.compare(Utility.HexToDec(id), Utility.HexToDec(o.getId()));
	}

	public boolean equals(DataMember o) {
		return id.equals(o.id) && operator.equals(o.operator) && input1.equals(o.input1) && input2.equals(o.input2);
	}

	public String toString() {
		return ("ID: " + id + ", OP: " + operator + ", Input1: " + input1 + ", Input2: " + input2 + ", BIN: " + binRes
				+ ", DEC: " + decRes + ", HEX: " + hexRes + ", Calculated: " + calculated + ".");
	}
}