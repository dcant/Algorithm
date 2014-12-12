package cn.edu.sjtu.zzang;

public class SumRootToLeafNumbers {
	public static void main(String[] args) {
		SumRootToLeafNumbers sr = new SumRootToLeafNumbers();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode ll = new TreeNode(4);
		root.left = left;
		root.right = right;
		left.left = ll;
		System.out.println(sr.sumNumbers(root));
	}
    public int sumNumbers(TreeNode root) {
        if (root == null)
        	return 0;
        if (root.left == null && root.right == null)
        	return root.val;
        int total = 0;
        String s = String.valueOf(root.val);
        if (root.left != null)
        	total += sum(root.left, s);
        if (root.right != null)
        	total += sum(root.right, s);
        return total;
    }
    
    private int sum(TreeNode node, String s) {
    	s += node.val;
    	if (node.left == null && node.right == null)
    		return Integer.valueOf(s);
    	int total = 0;
    	if (node.left != null)
    		total += sum(node.left, s);
    	if (node.right != null)
    		total += sum(node.right, s);
    	return total;
    }
}
