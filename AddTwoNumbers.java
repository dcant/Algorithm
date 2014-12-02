package cn.edu.sjtu.zzang;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
        	return l2;
        if (l2 == null)
        	return null;
        ListNode res = null;
        ListNode pre = res;
        ListNode t1 = l1;
        ListNode t2 = l2;
        int carry = 0;
        while (t1 != null && t2 != null) {
        	int t = t1.val + t2.val + carry;
        	carry = t/10;
        	if (res == null) {
        		res = new ListNode(t%10);
        		pre = res;
        	} else {
	        	ListNode tmp = new ListNode(t%10);
	        	pre.next = tmp;
	        	pre = tmp;
        	}
        	t1 = t1.next;
        	t2 = t2.next;
        }
        while (t1 != null) {
        	int t = t1.val + carry;
        	carry = t / 10;
        	ListNode tmp = new ListNode(t%10);
        	pre.next = tmp;
        	pre = tmp;
        	t1 = t1.next;
        }
        while (t2 != null) {
        	int t = t2.val + carry;
        	carry = t / 10;
        	ListNode tmp = new ListNode(t%10);
        	pre.next = tmp;
        	pre = tmp;
        	t2 = t2.next;
        }
        if (carry != 0) {
            ListNode tmp = new ListNode(carry);
            pre.next = tmp;
        }
        return res;
    }
}
