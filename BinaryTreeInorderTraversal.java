package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		BinaryTreeInorderTraversal bt = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(3);
		TreeNode r = new TreeNode(1);
		TreeNode rl = new TreeNode(2);
		TreeNode rll = new TreeNode(4);
		root.left = r;
		r.right = rl;
		r.left = rll;
		List<Integer> res = bt.inorderTraversal(root);
		for (int i : res)
			System.out.println(i);
	}

    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
        if (root == null)
        	return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
        	TreeNode cur = stack.peek();
        	if (pre == null || pre.left == cur) {
        		if (cur.left != null)
        			stack.push(cur.left);
        		else {
        			res.add(cur.val);
        			if (cur.right != null)
        				stack.push(cur.right);
        			else
        				stack.pop();
        		}
        	} else if (cur.left == pre){
        		res.add(cur.val);
        		if (cur.right != null)
        			stack.push(cur.right);
        		else
        			stack.pop();
        	} else if (cur.right == pre) {
        		stack.pop();
        	} else {
        		if (cur.left != null)
        			stack.push(cur.left);
        		else {
        			res.add(cur.val);
        			if (cur.right != null)
        				stack.push(cur.right);
        			else
        				stack.pop();
        		}
        	}
        	pre = cur;
        }
        return res;
    }
}
