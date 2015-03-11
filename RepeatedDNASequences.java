package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {
	public static void main(String[] args) {
		RepeatedDNASequences r = new RepeatedDNASequences();
//		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		String s = "AAAAAAAAAAA";
		List<String> res = r.findRepeatedDnaSequences(s);
		for (String str : res)
			System.out.println(str);
	}
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        List<String> res = new ArrayList<String>();
        if (s == null)
        	return res;
        for (int i = 0, length = s.length(); i < length - 9; i++) {
        	String sub = s.substring(i, i + 10);
        	int val = decode(sub);
        	if (!map.containsKey(val)) {
        		map.put(val, false);
        	} else if (false == map.get(val)) {
        		map.put(val, true);
        		res.add(sub);
        	} else {
        		continue;
        	}
        }
        return res;
    }
    
    private int decode(String str) {
    	int res = 0;
    	for (int i = 0, length = str.length(); i < length; i++) {
    		res <<= 2;
    		res |= translate(str.charAt(i));
    	}
    	return res;
    }
    
    private int translate(char c) {
    	switch (c) {
    	case 'A':
    		return 0;
    	case 'C':
    		return 1;
    	case 'G':
    		return 2;
    	case 'T':
    		return 3;
    	}
    	return 0;
    }
}
