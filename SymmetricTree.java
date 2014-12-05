package cn.edu.sjtu.zzang;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
        	return true;
        else
        	return checker(root.left, root.right);
    }
    
    private boolean checker(TreeNode left, TreeNode right) {
    	if (left == null && right == null)
    		return true;
    	else if (left == null || right == null)
    		return false;
    	else {
    		if (left.val != right.val)
    			return false;
    		else
    			return checker(left.left, right.right) && checker(left.right, right.left);
    	}
    }
}
