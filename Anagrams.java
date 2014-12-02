package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
	public static void main(String[] args) {
		Anagrams a = new Anagrams();
		String[] strs = {"abc", "bca", "acb"};
		List<String> res = a.anagrams(strs);
		for (String str : res) {
			System.out.println(str);
		}
	}

    public List<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        if (strs == null)
        	return res;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
        	char[] tmp = s.toCharArray();
        	Arrays.sort(tmp);
        	if (map.containsKey(String.valueOf(tmp))) {
        		map.get(String.valueOf(tmp)).add(s);
        	} else {
        		ArrayList<String> str = new ArrayList<String>();
        		str.add(s);
        		map.put(String.valueOf(tmp), str);
        	}
        }
        for (ArrayList<String> item : map.values()) {
        	if (item.size() > 1)
        		res.addAll(item);
        }
        return res;
    }
}
