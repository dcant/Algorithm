package cn.edu.sjtu.zzang;

import java.util.LinkedList;

public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		one.next = two;
		two.next = three;
		three.next = four;
		ReverseNodesInKGroup rnikg = new ReverseNodesInKGroup();
		ListNode ln = rnikg.reverseKGroup(one, 3);
		while (ln != null) {
			System.out.println(ln.val);
			ln = ln.next;
		}
	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode res = new ListNode(0);
        ListNode pre = res;
        LinkedList<ListNode> stack = new LinkedList<ListNode>();
        while (ptr != null) {
        	for (int i = 0; i < k; i++) {
        		if (ptr != null) {
        			ListNode tmp = ptr;
        			ptr = ptr.next;
        			tmp.next = null;
	        		stack.push(tmp);
        		} else {
        			while (!stack.isEmpty()) {
        				pre.next = stack.pollLast();
        				pre = pre.next;
        			}
        			return res.next;
        		}
        	}
        	while (!stack.isEmpty()) {
        		pre.next = stack.pop();
        		pre = pre.next;
        	}
        }
        return res.next;
    }
}
