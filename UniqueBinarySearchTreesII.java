package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public static void main(String[] args) {
		UniqueBinarySearchTreesII ub = new UniqueBinarySearchTreesII();
		List<TreeNode> res = ub.generateTrees(3);
	}

    public List<TreeNode> generateTrees(int n) {
        return worker(1, n);
    }
    
    private ArrayList<TreeNode> worker(int lo, int hi) {
    	ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    	if (lo > hi) {
    		res.add(null);
    		return res;
    	}
    	for (int i = lo; i <= hi; i++) {
    		ArrayList<TreeNode> lefts = worker(lo, i - 1);
    		ArrayList<TreeNode> rights = worker(i + 1, hi);
    		for (TreeNode left : lefts)
    			for (TreeNode right : rights) {
    				TreeNode node = new TreeNode(i);
    				node.left = left;
    				node.right = right;
    				res.add(node);
    			}
    	}
    	return res;
    }
}
