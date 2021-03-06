package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversalII {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
        	return res;
        queue.addLast(root);
        while (!queue.isEmpty()) {
        	LinkedList<TreeNode> tqueue = new LinkedList<TreeNode>();
        	ArrayList<Integer> tvalue = new ArrayList<Integer>();
        	while (!queue.isEmpty()) {
        		TreeNode tmp = queue.pollFirst();
        		tqueue.add(tmp);
        		tvalue.add(tmp.val);
        	}
        	for (TreeNode tmp : tqueue) {
        		if (tmp.left != null)
        			queue.add(tmp.left);
        		if (tmp.right != null)
        			queue.add(tmp.right);
        	}
        	list.add(tvalue);
        }
        for (int i = list.size() - 1; i >= 0; i--)
        	res.add(list.get(i));
        return res;        
    }
}
