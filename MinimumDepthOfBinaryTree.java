package cn.edu.sjtu.zzang;

import java.util.LinkedList;

public class MinimumDepthOfBinaryTree {
	public static void main(String[] args) {
		MinimumDepthOfBinaryTree md = new MinimumDepthOfBinaryTree();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode leftl = new TreeNode(4);
		TreeNode leftr = new TreeNode(5);
		root.left = left;
		root.right = right;
		left.left = leftl;
		left.right = leftr;
		System.out.println(md.minDepth(root));
	}
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
 
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
 
        nodes.add(root);
        counts.add(1);
 
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.remove();
            int count = counts.remove();
 
            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
 
            if(curr.left == null && curr.right == null){
                return count;
            }
        }
        return 0;
    }
}
