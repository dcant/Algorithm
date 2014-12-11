package cn.edu.sjtu.zzang;

import java.util.LinkedList;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        LinkedList<String> words = new LinkedList<String>();
        LinkedList<Integer> lengths = new LinkedList<Integer>();
        words.add(start);
        lengths.add(1);
        while (!words.isEmpty()) {
        	String word = words.pop();
        	int length = lengths.pop();
        	if (word.equals(end))
        		return length;
        	for (int i = 0; i < word.length(); i++) {
        		char[] chararray = word.toCharArray();
        		for (char c = 'a'; c <= 'z'; c++) {
        			chararray[i] = c;
        			String nword = new String(chararray);
        			if (nword.equals(end))
        				return length + 1;
        			if (dict.contains(nword)) {
        				words.add(nword);
        				dict.remove(nword);
        				lengths.add(length + 1);
        			}
        		}
        	}
        }
        return 0;
    }
}
