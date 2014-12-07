package cn.edu.sjtu.zzang;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = builder(head, null);
        return root;
    }
    
    private TreeNode builder(ListNode head, ListNode tail) {
    	if (head == tail)
    		return null;
    	ListNode p = head, q = head;
    	while (q != tail && q.next != tail) {
    		p = p.next;
    		q = q.next.next;
    	}
    	TreeNode parent = new TreeNode(p.val);
    	parent.left = builder(head, p);
    	parent.right = builder(p.next, tail);
    	return parent;
    }
}
