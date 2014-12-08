package cn.edu.sjtu.zzang;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        if (root == null)
        	return;
        queue.add(root);
        while (!queue.isEmpty()) {
        	Queue<TreeLinkNode> tqueue = new LinkedList<TreeLinkNode>();
        	TreeLinkNode pre = null;
        	while (!queue.isEmpty()) {
        		TreeLinkNode tmp = queue.poll();
        		if (pre != null)
        			pre.next = tmp;
        		pre = tmp;
        		tqueue.add(tmp);
        	}
        	for (TreeLinkNode tmp : tqueue) {
        		if (tmp.left != null) {
        			queue.add(tmp.left);
        			queue.add(tmp.right);
        		}
        	}
        }
    }
}
