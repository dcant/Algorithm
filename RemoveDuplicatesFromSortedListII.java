package cn.edu.sjtu.zzang;

public class RemoveDuplicatesFromSortedListII {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII rd = new RemoveDuplicatesFromSortedListII();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		ListNode res = rd.deleteDuplicates(one);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        ListNode res = new ListNode(-Integer.MAX_VALUE), pre = res, cur = head, p = head.next;
        pre.next = cur;
        boolean flag = false;
        while (p != null) {
        	if (p.val == cur.val) {
        		flag = true;
        	} else {
        		if (flag) {
        			flag = false;
        			cur = pre;
        		}
        		cur.next = p;
        		pre = cur;
        		cur = p;
        	}
        	p = p.next;
        }
        if (flag)
        	pre.next = null;
        return res.next;
    }
}
