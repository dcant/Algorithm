package cn.edu.sjtu.zzang;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList fb = new FlattenBinaryTreeToLinkedList();
		TreeNode root = new TreeNode(1);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(5);
		TreeNode ll = new TreeNode(3);
		TreeNode lr = new TreeNode(4);
		TreeNode rr = new TreeNode(6);
		root.left = l;
		root.right = r;
		l.left = ll;
		l.right =lr;
		r.right = rr;
		fb.flatten(root);
		while (root != null) {
			System.out.println(root.val);
			root = root.right;
		}
		
	}

	// non recursive version without stack
//	public void flatten(TreeNode root) {
//		while (root != null) {
//			if (root.left != null) {
//				TreeNode tmp = root.left;
//				while (tmp.right != null)
//					tmp = tmp.right;
//				tmp.right = root.right;
//				root.right = root.left;
//				root.left = null;
//			}
//			root = root.right;
//		}
//	}

    public void flatten(TreeNode root) {
        if (root == null)
        	return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	if (node.right != null)
        		stack.push(node.right);
        	if (pre != null)
        		pre.right = node;
        	pre = node;
        	if (node.left != null) {
        		stack.push(node.left);
        		node.left = null;
        	}
        }
    }
}
