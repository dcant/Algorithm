package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {
	public static void main(String[] args) {
		CombinationSumII cs = new CombinationSumII();
		int[] candidates = {1};
		ArrayList<ArrayList<Integer>> res = cs.combinationSum2(candidates, 1);
		for (ArrayList<Integer> item : res) {
			for (int n : item) {
				System.out.print(n);
			}
			System.out.println();
		}
	}

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0)
        	return res;
        Arrays.sort(num);
        solver(num, 0, target, res, new ArrayList<Integer>());
        return res;
    }
    
    private void solver(int[] num, int lo, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ans) {
    	if (target < 0)
    		return;
    	if (target == 0) {
    		res.add(new ArrayList<Integer>(ans));
    		return;
    	}
    	int i = lo;
    	while (i < num.length) {
    		int count = 1;
    		while (i < num.length - 1 && num[i] == num[i + 1]) {
    			count++;
    			i++;
    		}
    		for (int k = 0; k < count; k++) {
    			for (int m = 0; m < k + 1; m++)
    				ans.add(num[i]);
    			solver(num, i + 1, target - num[i] * (k + 1), res, ans);
    			for (int m = 0; m < k + 1; m++)
    				ans.remove(ans.size() - 1);
    		}
    		i++;
    	}
    }
}
