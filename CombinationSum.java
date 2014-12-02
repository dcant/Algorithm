package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = {2,3,6,7};
		ArrayList<ArrayList<Integer>> res = cs.combinationSum(candidates, 7);
		for (ArrayList<Integer> item : res) {
			for (int n : item) {
				System.out.print(n);
			}
			System.out.println();
		}
	}

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0)
        	return res;
        Arrays.sort(candidates);
        solver(candidates, 0, target, res, new ArrayList<Integer>());
        return res;
    }
    
    private void solver(int[] candidates, int lo, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ans) {
    	if (target < 0)
    		return;
    	if (target == 0) {
    		res.add(new ArrayList<Integer>(ans));
    		return;
    	}
		for (int i = lo; i < candidates.length; i++) {
			if (i > 0 && candidates[i] == candidates[i - 1])
				continue;
			ans.add(candidates[i]);
			solver(candidates, i, target - candidates[i], res, ans);
			ans.remove(ans.size() - 1);
    	}
    }
}
