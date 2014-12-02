package cn.edu.sjtu.zzang;

public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList rd = new RemoveDuplicatesFromSortedList();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(3);
		ListNode five = new ListNode(4);
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
    	if (head == null)
    		return null;
        ListNode pre = head, p = head.next;
        int val = head.val;
        while (p!= null) {
        	if (p.val == val)
        		p = p.next;
        	else {
        		pre.next = p;
        		pre = p;
        		val = pre.val;
        	}
        }
        pre.next = null;
        return head;
    }
}
