package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public static void main(String[] args) {
		BinaryTreePreorderTraversal bt = new BinaryTreePreorderTraversal();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode lr = new TreeNode(3);
		TreeNode right = new TreeNode(4);
		root.left = left;
		root.right = right;
		left.right = lr;
		List<Integer> res = bt.preorderTraversal(root);
		for (int i : res)
			System.out.println(i);
	}
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
        	return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	res.add(node.val);
        	if (node.right != null)
        		stack.push(node.right);
        	if (node.left != null)
        		stack.push(node.left);
        }
        return res;
    }
}
