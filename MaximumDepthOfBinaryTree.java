package cn.edu.sjtu.zzang;

public class MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		MaximumDepthOfBinaryTree bt = new MaximumDepthOfBinaryTree();
		TreeNode root = new TreeNode(3);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(5);
		TreeNode r2 = new TreeNode(4);
		TreeNode r3 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		r1.left = r2;
		r1.right = r3;
		System.out.println(bt.maxDepth(root));
	}
    public int maxDepth(TreeNode root) {
        if (root == null)
        	return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
