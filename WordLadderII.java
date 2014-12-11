package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (start == null || end == null)
        	return res;
        ArrayList<String> item = new ArrayList<String>();
        if (start.equals(end)) {
        	item.add(start);
        	item.add(end);
        	res.add(new ArrayList<String>(item));
        	return res;
        }
        
        // use map to store a string's every possible pre string
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String w : dict)
        	map.put(w, new ArrayList<String>());
        
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        while (!queue.isEmpty()) {
        	int levelcount = queue.size();
        	ArrayList<String> curs = new ArrayList<String>();
        	for (int i = 0; i < levelcount; i++) {
        		String word = queue.poll();
        		if (dict.contains(word)) dict.remove(word);
        		curs.add(word);
        	}
        	
        	for (String cur : curs) {
        		for (int i = 0; i < cur.length(); i++) {
        			char[] array = cur.toCharArray();
        			for (char c = 'a'; c <= 'z'; c++) {
        				array[i] = c;
        				String nw = new String(array);
        				if (nw.equals(end)) {
        					map.get(end).add(cur);
        					queue.add(nw);
        				} else if (!nw.equals(cur) && dict.contains(nw)) {
        					if (!queue.contains(nw)) queue.add(nw);
        					map.get(nw).add(cur);
        				}
        			}
        		}
        	}
        	if (queue.contains(end))
        		break;
        }
        item.add(end);
        build(start, end, map, item, res);
        return res;
    }
    
    private void build(String start, String end, HashMap<String, ArrayList<String>> map, ArrayList<String> item, ArrayList<ArrayList<String>> res) {
    	ArrayList<String> tmp = map.get(end);
    	if (end.equals(start)) {
    		ArrayList<String> r = new ArrayList<String>(item);
    		Collections.reverse(r);
    		res.add(r);
    		return;
    	} else {
    		for (String s : tmp) {
    			item.add(s);
    			build(start, s, map, item, res);
    			item.remove(item.size() - 1);
    		}
    	}
    }
}
