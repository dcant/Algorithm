package cn.edu.sjtu.zzang;

public class RotateList {
	public static void main(String[] args) {
		RotateList rl = new RotateList();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		one.next = two;
		two.next = three;
		three.next = four;
		ListNode res = rl.rotateRight(one, 5);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0)
        	return head;
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        while (fast != null) {
        	fast = fast.next;
        	len++;
        }
        n = n % len;
        int i = 0;
        fast = head;
        while (i < n && fast.next != null) {
        	fast = fast.next;
        	i++;
        }
        if (i < n)
        	return head;
        while (fast.next != null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
