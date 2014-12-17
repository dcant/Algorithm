package cn.edu.sjtu.zzang;

import java.util.HashSet;
import java.util.Set;

/* Word Breaker 
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 *  For example, given
 *  s = "leetcode",
 *  dict = ["leet", "code"].
 *
 *  Return true because "leetcode" can be segmented as "leet code". 
 */

public class Wb {
	public static void main(String[] args) {
		String test = "programcreak";
		Set<String> dict = new HashSet<String>();
		dict.add("programcreak");
		dict.add("program");
		dict.add("creak");
		if (Wb.Wbworker(test, dict))
			System.out.println("true");
		else
			System.out.println("false");
	}
	
	public static boolean Wbworker(String str, Set<String> dict) {
		boolean[] helper = new boolean[str.length() + 1];
		helper[0] = true;
		
		for (int i = 0; i < str.length(); i++) {
			if (!helper[i])
				continue;
			for (String a : dict) {
				int len = a.length();
				int end = i + len;
				if (end > str.length())
					continue;
				if (helper[end])
					continue;
				if (str.substring(i, end).equals(a))
					helper[end] = true;
			}
		}
		return helper[str.length()];
	}
}
