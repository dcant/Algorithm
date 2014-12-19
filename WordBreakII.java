package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public static void main(String[] args) {
		WordBreakII wb = new WordBreakII();
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		List<String> res = wb.wordBreak("catsanddog", dict);
		for (String s : res)
			System.out.println(s);
		System.out.println();
		
	}
	
	public List<String> wordBreak(String s, Set<String> dict) {
		if (s == null || dict == null)
			return null;
		ArrayList<String> flag[] = new ArrayList[s.length() + 1];
		flag[0] = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			if (flag[i] == null) continue;
			for (String d : dict) {
				int hi = i + d.length();
				if (hi > s.length())
					continue;
				if (s.substring(i, hi).equals(d)) {
					if (flag[hi] == null)
						flag[hi] = new ArrayList<String>();
					flag[hi].add(d);
				}
			}
		}
		ArrayList<String> res = new ArrayList<String>();
		ArrayList<String> words = new ArrayList<String>();
		if (flag[s.length()] == null)
			return res;
		generator(flag, s.length(), words, res);
		return res;
	}
	
	private void generator(ArrayList<String> flag[], int cur, ArrayList<String> words, ArrayList<String> res) {
		if (cur <= 0) {
			String s = words.get(words.size() - 1);
			for (int i = words.size() - 2; i >= 0; i--) {
				s += (" " + words.get(i));
			}
			res.add(s);
			return;
		}
		for (String word : flag[cur]) {
			words.add(word);
			generator(flag, cur - word.length(), words, res);
			words.remove(words.size() - 1);
		}
	}
	// time limit exceeded
//    public List<String> wordBreak(String s, Set<String> dict) {
//    	if (s == null)
//    		return null;
//        ArrayList<String> res = new ArrayList<String>();
//        ArrayList<String> words = new ArrayList<String>();
//        breaker(s, 0, dict, words, res);
//        return res;
//    }
//    
//    private void breaker(String s, int i, Set<String> dict, ArrayList<String> words, ArrayList<String> res) {
//    	if (i == s.length()) {
//    		StringBuilder sb = new StringBuilder();
//    		boolean flag = false;
//    		for (String word : words) {
//    			if (flag)
//    				sb.append(" ");
//    			else
//    				flag = true;
//    			sb.append(word);
//    		}
//    		res.add(sb.toString());
//    	}
//    	for (String d : dict) {
//    		int len = d.length();
//    		if (i + len > s.length())
//    			continue;
//    		if (s.substring(i, i + len).equals(d)) {
//    			words.add(d);
//    			breaker(s, i + len, dict, words, res);
//    			words.remove(words.size() - 1);
//    		}
//    	}
//    }
}
