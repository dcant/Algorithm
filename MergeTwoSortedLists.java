package cn.edu.sjtu.zzang;

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		MergeTwoSortedLists mt = new MergeTwoSortedLists();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(3);
		ListNode three = new ListNode(4);
		ListNode four = new ListNode(2);
		ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		four.next = five;
		ListNode res = mt.mergeTwoLists(one, four);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        while (l1 != null & l2 != null) {
        	if (l1.val <= l2.val) {
        		pointer.next = l1;
        		l1 = l1.next;
        	} else {
        		pointer.next = l2;
        		l2 = l2.next;
        	}
        	pointer = pointer.next;
        }
        while (l1 != null) {
        	pointer.next = l1;
        	l1 = l1.next;
        	pointer = pointer.next;
        }
        while (l2 != null) {
        	pointer.next = l2;
        	l2 = l2.next;
        	pointer = pointer.next;
        }
        return head.next;
    }
}
