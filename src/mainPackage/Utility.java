package mainPackage;

public class Utility {
	public Utility() {
		// TODO Auto-generated constructor stub
	}
	public static int HexToDec(String s) {
		if (s.length()>6) {
			throw new IllegalArgumentException("Argument larger than max limit");
		}

		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			int value = s.charAt(s.length()-i-1);
			switch (value) {
			case 48:
				value =0;
				break;
				
			case 49:
				value =1;
				break;
				
			case 50:
				value =2;
				break;
				
			case 51:
				value =3;
				break;
				
			case 52:
				value =4;
				break;
				
			case 53:
				value =5;
				break;
				
			case 54:
				value =6;
				break;
				
			case 55:
				value =7;
				break;
				
			case 56:
				value =8;
				break;
				
			case 57:
				value =9;
				break;
				
			case 65:
				value =10;
				break;

			case 66:
				value =11;
				break;

			case 67:
				value =12;
				break;

			case 68:
				value =13;
				break;

			case 69:
				value =14;
				break;

			case 70:
				value =15;
				break;

			default:
				throw new IllegalArgumentException("Illegal characters in the argument.");
			}
			res += value*Math.pow(16, (i));
		}
		return res;
	}
	public static String DecToHex(int d) {
		if (d>16777215) {
			throw new IllegalArgumentException("Argument larger than max limit");
		}
		if (d<0) {
			throw new IllegalArgumentException("Argument smaller than 0");
		}
		if (d==0) {
			return "0";
		}
		int rem;
		String res = "";
		char[] hex = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		while (d>0){
			rem=d%16;
			res=hex[rem]+res;
			d=d/16;
		}
		return res;
	}
	public static String DecToBin(int d) {
		int bit24 = (int) Math.pow(2, 24);
		if (d>bit24) {
			throw new IllegalArgumentException("Argument larger than max limit");
		}
		if (d<0) {
			throw new IllegalArgumentException("Argument smaller than 0");
		}
		if (d == 0) {
			return "000000000000000000000000";
		}
		int i = 0;
		for (; i < 24; i++) {
			if (d<Math.pow(2, i)) {
				break;
			}
		}
		String res = "";
		for (; i > 0; i--) {
			if (d>=Math.pow(2, i-1)) {
				d-=Math.pow(2, i-1);
				res+= 1;
			}else {
				res+= 0;
			}
		}
		String addLeft = "";
		int left = 24-res.length();
		for (int j = 0; j < left; j++) {
			addLeft+="0";
		}
		res = addLeft+res;
		return res;
	}
	public static int BinToDec(String s) {
		if (s.length()>24) {
			throw new IllegalArgumentException("Argument larger than max limit");
		}
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i)!='0')&&(s.charAt(i)!='1')) {
				throw new IllegalArgumentException("Illegal characters in the argument.");
			}
			res += ((s.charAt(s.length()-i-1))-48)*Math.pow(2, (i));
		}
		return res;
	}
	public static String BitWiseOR(String input1, String input2) {
		String res = "";
		int len;
		
		
		if (input1.length() > input2.length()) {
			len = input1.length();
		}else{
			len = input2.length();
		}
		if (len>24) {
			throw new IllegalArgumentException("Input string cannot be longer than 24 characters, it was " + len);
		}
		
		for (int i = 0; i < len; i++) {
			if ((input1.charAt(i) != '1')&&(input1.charAt(i) != '0')) {
				throw new IllegalArgumentException("Illegal character at space " + i + " in input 1. Error happened while doin BitWiseOR on \"" + input1 + "\" and \"" + input2 + "\".");
			}
			if ((input2.charAt(i) != '1')&&(input2.charAt(i) != '0')) {
				throw new IllegalArgumentException("Illegal character at space " + i + " in input 2. Error happened while doin BitWiseOR on \"" + input1 + "\" and \"" + input2 + "\".");
			}
			if ((input1.charAt(i) == '1')||(input2.charAt(i) == '1')) {
				res += "1";
			}else {
				res += "0";
			}
		}
		
		
		
		return res;
	}
	public static String BitWiseAND(String input1, String input2) {
		String res = "";
		int len;
		
		
		if (input1.length() > input2.length()) {
			len = input1.length();
		}else{
			len = input2.length();
		}
		

		if (len>24) {
			throw new IllegalArgumentException("Input string cannot be longer than 24 characters, it was " + len);
		}
		
		for (int i = 0; i < len; i++) {
			if ((input1.charAt(i) != '1')&&(input1.charAt(i) != '0')) {
				throw new IllegalArgumentException("Illegal character at space " + i + " in input 1. Error happened while doin BitWiseOR on \"" + input1 + "\" and \"" + input2 + "\".");
			}
			if ((input2.charAt(i) != '1')&&(input2.charAt(i) != '0')) {
				throw new IllegalArgumentException("Illegal character at space " + i + " in input 2. Error happened while doin BitWiseOR on \"" + input1 + "\" and \"" + input2 + "\".");
			}
			if ((input1.charAt(i) == '1')&&(input2.charAt(i) == '1')) {
				res += "1";
			}else {
				res += "0";
			}
		}
		return res;
	}
}
