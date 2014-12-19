package cn.edu.sjtu.zzang;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        boolean flag = false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow == fast) {
        		flag = true;
        		break;
        	}
        }
        if (flag) {
        	slow = head;
        	while (slow != fast) {
        		slow = slow.next;
        		fast = fast.next;
        	}
        	return slow;
        }
        return null;
    }
}
