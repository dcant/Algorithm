package cn.edu.sjtu.zzang;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
        	return true;
        if (getDepth(root) == -1)
        	return false;
        return true;
    }
    
    private int getDepth(TreeNode node) {
    	if (node == null)
    		return 0;
    	int left = getDepth(node.left);
    	int right = getDepth(node.right);
    	if (left == -1 || right == -1)
    		return -1;
    	else if (Math.abs(left - right) > 1)
    		return -1;
    	return Math.max(left, right) + 1;
    }
}
