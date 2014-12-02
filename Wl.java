package cn.edu.sjtu.zzang;

/* Word Ladder */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Wl {
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dot");
		dict.add("lot");
		dict.add("log");
		int len = Wl.Wlworker(start, end, dict);
		System.out.println(len);
	}
	
	public static int Wlworker(String start, String end, Set<String> dict) {
		if (dict.size() == 0)
			return 0;
		LinkedList<String> words = new LinkedList<String>();
		LinkedList<Integer> lengths = new LinkedList<Integer>();
		words.add(start);
		lengths.add(1);
		
		while (!words.isEmpty()) {
			String word = words.pop();
			Integer length = lengths.pop();
			
			if (word.equals(end))
				return length;
			
			for (int i = 0; i < word.length(); i++) {
				char[] wordarray = word.toCharArray();
				for (char k = 'a'; k <='z'; k++) {
					wordarray[i] = k;
					String nw = new String(wordarray);
					if (nw.equals(end))
						return length + 1;
					if (dict.contains(nw)) {
						words.add(nw);
						lengths.add(length + 1);
						dict.remove(nw);
					}
				}
			}
		}
		return 0;
	}
}
