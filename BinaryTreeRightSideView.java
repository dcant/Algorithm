package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
	public static void main(String[] args) {
		BinaryTreeRightSideView btrsv = new BinaryTreeRightSideView();
		TreeNode root =  new TreeNode(1);
		TreeNode l = new TreeNode(2);
		TreeNode ll = new TreeNode(3);
		TreeNode lll = new TreeNode(4);
		TreeNode r = new TreeNode(5);
		root.left = l;
		l.left = ll;
		ll.left = lll;
		root.right = r;
		List<Integer> res = btrsv.rightSideView(root);
		for (int i : res)
			System.out.println(i);
	}
	
	private int maxlevel = 0;
	
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        viewhelper(root, 1, list);
        return list;
    }
    
    private void viewhelper(TreeNode node, int curlevel, ArrayList<Integer> list) {
		if (node == null)
			return;
    	if (maxlevel < curlevel) {
    		list.add(node.val);
    		maxlevel = curlevel;
    	}
    	viewhelper(node.right, curlevel + 1, list);
    	viewhelper(node.left, curlevel + 1, list);
    }
}
