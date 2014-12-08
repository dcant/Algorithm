package cn.edu.sjtu.zzang;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		if (root == null || root.left == null)
			return;
		TreeLinkNode parent = root, child = root.left;
		while (child != null) {
			TreeLinkNode tmp = child;
			while (child != null) {
				child.next = parent.right;
				child = child.next;
				parent = parent.next;
				child.next = parent != null ? parent.left : null;
				child = child.next;
			}
			parent = tmp;
			child = parent.left;
		}
	}
//    public void connect(TreeLinkNode root) {
//        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
//        if (root == null)
//        	return;
//        queue.add(root);
//        while (!queue.isEmpty()) {
//        	Queue<TreeLinkNode> tqueue = new LinkedList<TreeLinkNode>();
//        	TreeLinkNode pre = null;
//        	while (!queue.isEmpty()) {
//        		TreeLinkNode tmp = queue.poll();
//        		if (pre != null)
//        			pre.next = tmp;
//        		pre = tmp;
//        		tqueue.add(tmp);
//        	}
//        	for (TreeLinkNode tmp : tqueue) {
//        		if (tmp.left != null) {
//        			queue.add(tmp.left);
//        			queue.add(tmp.right);
//        		}
//        	}
//        }
//    }
}
