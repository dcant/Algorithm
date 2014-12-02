package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationsII {
	public static void main(String[] args) {
		PermutationsII p = new PermutationsII();
		int[] num = {1,1,3};
		ArrayList<ArrayList<Integer>> res = p.permuteUnique(num);
		for (ArrayList<Integer> item : res) {
			for (int i : item) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<ArrayList<Integer>, Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
        	ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
        	for (ArrayList<Integer> item : res) {
        		for (int k = 0; k < item.size() + 1; k++) {
        			item.add(k, num[i]);
        			if (!map.containsKey(item)) {
        				tmp.add(new ArrayList<Integer>(item));
        				map.put(new ArrayList<Integer>(item), 1);
        			}
        			item.remove(k);
        		}
        	}
        	res = new ArrayList<ArrayList<Integer>>(tmp);
        	map.clear();
        }
        return res;
    }
	
//	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
//		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//		HashMap<ArrayList<Integer>, Integer> map = new HashMap<ArrayList<Integer>, Integer>();
//		worker(num, 0, res, map);
//		return res;
//	}
//	
//	private void worker(int[] num, int lo, ArrayList<ArrayList<Integer>> res, HashMap<ArrayList<Integer>, Integer> map) {
//		if (lo >= num.length) {
//			ArrayList<Integer> item = addToList(num);
//			if (!map.containsKey(item)) {
//				res.add(item);
//				map.put(item, 1);
//			}
//		}
//		for (int i = lo; i < num.length; i++) {
//			swap(num, lo, i);
//			worker(num, lo + 1, res, map);
//			swap(num, lo, i);
//		}
//	}
//	
//	private ArrayList<Integer> addToList(int[] num) {
//		ArrayList<Integer> res = new ArrayList<Integer>();
//		for (int i : num) {
//			res.add(i);
//		}
//		return res;
//	}
//	
//	private void swap(int[] num, int i, int j) {
//		int tmp = num[i];
//		num[i] = num[j];
//		num[j] = tmp;
//	}
}
