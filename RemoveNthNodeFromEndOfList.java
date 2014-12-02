package cn.edu.sjtu.zzang;

public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		RemoveNthNodeFromEndOfList rn = new RemoveNthNodeFromEndOfList();
		ListNode r = rn.removeNthFromEnd(one, 1);
		while (r != null) {
			System.out.println(r.val);
			r = r.next;
		}
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int i = 1;
		ListNode fast = head;
		while (i < n) {
			fast = fast.next;
			if (fast == null)
				return null;
			i++;
		}
		ListNode slow = head;
		ListNode pre = null;
		while (fast.next != null) {
			fast = fast.next;
			pre = slow;
			slow = slow.next;
		}
		if (pre == null) {
			head = slow.next;
		}
		else
			pre.next = slow.next;
		return head;
	}
}