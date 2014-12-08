package cn.edu.sjtu.zzang;

import java.util.ArrayList;

public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
        	return res;
        if (root.left == null && root.right == null) {
        	if (root.val == sum) {
        		ArrayList<Integer> item = new ArrayList<Integer>();
        		item.add(root.val);
        		res.add(item);
        	}
        	return res;
        }
        ArrayList<Integer> item = new ArrayList<Integer>();
        checker(root, 0, sum, item, res);
        return res;
    }
    
    private void checker(TreeNode root, int csum, int sum, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
    	item.add(root.val);
    	if (root.left == null && root.right == null) {
    		if (csum + root.val == sum) {
    			ArrayList<Integer> tmp = new ArrayList<Integer>(item);
    			res.add(tmp);
    		}
    		item.remove(item.size() - 1);
    		return;
    	} else if (root.left == null) {
    		checker(root.right, csum + root.val, sum, item, res);
    		item.remove(item.size() - 1);
    	} else if (root.right == null) {
    		checker(root.left, csum + root.val, sum, item, res);
    		item.remove(item.size() - 1);
    	} else {
    		checker(root.left, csum + root.val, sum, item, res);
    		checker(root.right, csum + root.val, sum, item, res);
    		item.remove(item.size() - 1);
    	}
    }
}
