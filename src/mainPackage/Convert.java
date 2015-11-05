package mainPackage;

public class Convert {
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
		if (d == 0) {
			return "0";
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
		if(d!=0){
			System.err.println("'d' was not 0, and unexpected algorythm has occurred. " + d);
		}
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
}
