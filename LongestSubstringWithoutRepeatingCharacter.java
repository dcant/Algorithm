package cn.edu.sjtu.zzang;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
	   public int lengthOfLongestSubstring(String s) {
	       char[] arr = s.toCharArray();
	       HashMap<Character, Integer> m = new HashMap<Character, Integer>();
	       int max = 0;
	       int pre = -1;
	       int curlen = 0;
	       for (int i = 0; i < arr.length; i++) {
	           if (!m.containsKey(arr[i])) {
	               curlen++;
	           } else {
	               pre = m.get(arr[i]);
	               if (i - curlen > pre)
	            	   curlen++;
	               else {
		               if (curlen > max)
		                   max = curlen;
		               curlen = i - pre;
	               }
	           }
	           m.put(arr[i], i);
	       }
	       if (curlen > max)
	           max = curlen;
	       return max;
	   }
}
