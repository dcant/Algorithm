package cn.edu.sjtu.zzang;

/* Longest palindromic substring */

public class Lps {
	public static void main(String[] args) {
		String test = "ABCBCDEDFDEDG";
		Lps l = new Lps();
		String longest = l.lps(test);
		System.out.println(longest);
	}
	
	public String lps(String str) {
		if (str == null)
			return null;
		if (str.length() == 1)
			return str;
		String longest = str.substring(0, 1);
		for (int i = 0; i < str.length(); i++) {
			String temp = ps(str, i, i);
			if (temp.length() > longest.length())
				longest = temp;
			temp = ps(str, i, i+1);
			if (temp.length() > longest.length())
				longest = temp;
		}
		
		return longest;
	}
	
	private String ps(String s, int begin, int end) {
		while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin+1, end);
	}
}
