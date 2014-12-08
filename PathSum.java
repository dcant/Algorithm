package cn.edu.sjtu.zzang;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
        	return false;
        if (root.left == null && root.right == null) {
        	if (root.val == sum)
        		return true;
        	return false;
        } else 
        	return checker(root, 0, sum);
    }
    
    private boolean checker(TreeNode node, int csum, int sum) {
    	if (node.left == null && node.right == null) {
    		if (csum + node.val == sum)
    			return true;
    		return false;
    	} else if (node.left == null)
    		return checker(node.right, csum + node.val, sum);
    	else if (node.right == null)
    		return checker(node.left, csum + node.val, sum);
    	else
    		return checker(node.left, csum + node.val, sum) || checker(node.right, csum + node.val, sum);
    }
}
