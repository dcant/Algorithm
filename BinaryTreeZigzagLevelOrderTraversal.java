package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal bt = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = new TreeNode(3);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(5);
		TreeNode r2 = new TreeNode(4);
		TreeNode r3 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		r1.left = r2;
		r1.right = r3;
		ArrayList<ArrayList<Integer>> res = bt.zigzagLevelOrder(root);
		for (ArrayList<Integer> item : res) {
			for (int i : item)
				System.out.print(i);
			System.out.println();
		}
	}

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean flag = false;
        if (root == null)
        	return res;
        queue.add(root);
        while (!queue.isEmpty()) {
        	ArrayList<Integer> level = new ArrayList<Integer>();
        	Queue<TreeNode> tqueue = new LinkedList<TreeNode>();
        	while (!queue.isEmpty()) {
        		TreeNode node = queue.poll();
        		if (!flag)
        			level.add(node.val);
        		else
        			level.add(0, node.val);
        		tqueue.add(node);
        	}
        	flag = !flag;
        	for (TreeNode node : tqueue) {
        		if (node.left != null)
        			queue.add(node.left);
        		if (node.right != null)
        			queue.add(node.right);
        	}
        	res.add(level);
        }
        return res;
    }
}
