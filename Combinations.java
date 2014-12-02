package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static void main(String[] args) {
		Combinations c = new Combinations();
		ArrayList<ArrayList<Integer>> res = c.combine(4, 2);
		for (ArrayList<Integer> item : res) {
			for (int i : item)
				System.out.print(i + " ");
			System.out.println();
		}
	}

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        worker(1, n - k + 1, 0, k, item, res);
        return res;
    }
    private void worker(int lo, int hi, int count, int k, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
    	if (count == k) {
    		ArrayList<Integer> tmp = new ArrayList<Integer>(item);
    		res.add(tmp);
    		return;
    	} else {
	    	for (int i = lo; i <= hi; i++) {
	    		item.add(item.size(), i);
	    		worker(i + 1, hi + 1, count + 1, k, item, res);
	    		item.remove(item.size() - 1);
	    	}
    	}
    }
}
