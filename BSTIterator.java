package cn.edu.sjtu.zzang;

import java.util.Stack;

public class BSTIterator {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode l = new TreeNode(1);
		TreeNode lr = new TreeNode(2);
		TreeNode r = new TreeNode(5);
		TreeNode rl = new TreeNode(4);
		root.left = l;
		l.right = lr;
		root.right = r;
		r.left = rl;
		BSTIterator bst = new BSTIterator(root);
		while (bst.hasNext())
			System.out.println(bst.next());
	}
	
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	private TreeNode current;

	public BSTIterator(TreeNode root) {
		current = root;
	}
	
	public boolean hasNext() {
		return !stack.empty() || current != null;
	}
	
	public int next() {
		while (current != null) {
			stack.push(current);
			current = current.left;
		}
		current = stack.pop();
		int res = current.val;
		current = current.right;
		return res;
	}
}
