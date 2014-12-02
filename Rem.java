package cn.edu.sjtu.zzang;

/* Regular expression matching */

public class Rem {
	public static void main(String[] args) {
		String s, p;
		s = "abbc";
		p = "ab*bbc";
		if (Rem.isMatch(s, p))
			System.out.println("match");
		else
			System.out.println("not match");
	}
	
	public static boolean isMatch(String str, String regx) {
		if (regx.length() == 0)
			return str.length() == 0;
		
		if (regx.length() == 1 || regx.charAt(1) != '*') {
			if (str.length() < 1 || (regx.charAt(0) != '.' && regx.charAt(0) != str.charAt(0)))
				return false;
			else
				return isMatch(str.substring(1), regx.substring(1));
		} else {
			int len = str.length();
			int i = -1;
			while (i < len && (i < 0 || regx.charAt(0) == '.' || regx.charAt(0) == str.charAt(0))) {
				if (isMatch(str.substring(i + 1), regx.substring(2)))
					return true;
				i++;
			}
			return false;
		}		
	}
}
