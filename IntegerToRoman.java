package cn.edu.sjtu.zzang;

public class IntegerToRoman {
	public static void main(String[] args) {
		IntegerToRoman itr = new IntegerToRoman();
		System.out.println(itr.intToRoman(1899));
	}
	
	public String intToRoman(int num) {
		int [] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] Roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		String str = "";
		for (int i = 0; i < val.length; i++) {
			while (num - val[i] >= 0) {
				str += Roman[i];
				num -= val[i];
			}
		}
		return str;
	}
//    public String intToRoman(int num) {
//        String Roman = "^IVXLCDM";
//        String str = "";
//        int bits = 1;
//        while (num / (int)Math.pow(10, bits) > 0)
//        	bits++;
//        int div = (int)Math.pow(10, bits - 1);
//        while (bits > 0) {
//        	int tmp = num / div;
//        	if (tmp < 4)
//        		while (tmp > 0) {
//        			str += Roman.charAt(2*bits - 1);
//        			tmp--;
//        		}
//        	else if (tmp == 4) {
//        		str += Roman.charAt(2*bits - 1);
//        		str += Roman.charAt(2*bits);
//        	} else if (tmp < 9) {
//        		str += Roman.charAt(2*bits);
//        		while (tmp > 5) {
//        			str += Roman.charAt(2*bits -1);
//        			tmp--;
//        		}
//        	} else {
//        		str += Roman.charAt(2*bits - 1);
//        		str += Roman.charAt(2*bits + 1);
//        	}
//        	bits--;
//        	num %= div;
//        	div /= 10;
//        }
//        return str;
//    }
}