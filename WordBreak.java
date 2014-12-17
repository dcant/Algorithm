package cn.edu.sjtu.zzang;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		dict.add("mess");
		System.out.println(wb.wordBreak("leetcode", dict));
	}
    public boolean wordBreak(String s, Set<String> dict) {
    	boolean[] flag = new boolean[s.length() + 1];
    	flag[0] = true;
    	for (int i = 0; i < s.length(); i++) {
    		if (!flag[i])
    			continue;
    		for (String d : dict) {
    			int len = d.length();
    			int hi = i + len;
    			if (hi > s.length())
    				continue;
    			if (flag[hi])
    				continue;
    			if (s.substring(i, hi).equals(d))
    				flag[hi] = true;
    		}
    	}
    	return flag[s.length()];
    }
}
