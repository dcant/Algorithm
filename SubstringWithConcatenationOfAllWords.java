package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstringWithConcatenationOfAllWords {
	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords sw = new SubstringWithConcatenationOfAllWords();
		String[] L = {"foo", "bar"};
		ArrayList<Integer> res = sw.findSubstring("barfoothefoobarman", L);
		for (int i = 0; i < res.size(); i++)
			System.out.println(res.get(i));
	}
	
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<String, Integer> lmap = new HashMap<String, Integer>();
        HashMap<String, Integer> smap = new HashMap<String, Integer>();
        if (L.length == 0)
        	return res;
        int slen = S.length();
        int wordlen = L[0].length();
        int dictlen = wordlen * L.length;
        for (String d : L) {
        	if (lmap.containsKey(d))
        		lmap.put(d, lmap.get(d) + 1);
        	else
        		lmap.put(d, 1);
        }
        for (int i = 0; i <= slen - dictlen; i++) {
        	smap.clear();
        	int j = i;
        	for (; j < i + dictlen; j += wordlen) {
        		String tmp = S.substring(j, j + wordlen);
        		if (lmap.containsKey(tmp)) {
        			if (smap.containsKey(tmp))
        				smap.put(tmp, smap.get(tmp) + 1);
        			else
        				smap.put(tmp, 1);
        			if (smap.get(tmp) > lmap.get(tmp))
        				break;
        		} else
        			break;
        	}
        	if (j == i + dictlen)
        		res.add(i);
        }
        return res;
    }
}
