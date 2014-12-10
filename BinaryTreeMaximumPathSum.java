package cn.edu.sjtu.zzang;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null)
        	return 0;
        int[] max = new int[1];
        max[0] = -Integer.MAX_VALUE;
        maxpath(root, max);
        return max[0];
    }
    
    private int maxpath(TreeNode node, int[] max) {
    	if (node == null)
    		return 0;
    	else {
    		int l = maxpath(node.left, max);
    		int r = maxpath(node.right, max);
    		int maxchild = Math.max(l, r);
    		if (maxchild > 0) {
    			int sum = node.val + (l > 0 ? l : 0) + (r > 0 ? r : 0);
    			if (sum > max[0])
    				max[0] = sum;
    			return node.val + maxchild;
    		} else {
    			if (node.val > max[0])
    				max[0] = node.val;
    			return node.val;
    		}
    	}
    }
}
