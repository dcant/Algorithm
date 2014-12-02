package cn.edu.sjtu.zzang;

public class SwapNodesInPairs {
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
//		ListNode four = new ListNode(4);
		one.next = two;
		two.next = three;
//		three.next = four;
		SwapNodesInPairs snip = new SwapNodesInPairs();
		ListNode ln = snip.swapPairs(one);
		while (ln != null) {
			System.out.println(ln.val);
			ln = ln.next;
		}
	}
	
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        ListNode res = new ListNode(0);
        ListNode ptr = res;
        while (head != null && head.next != null) {
        	ListNode tmp = head.next.next;
        	head.next.next = head;
        	ptr.next = head.next;
        	head.next = tmp;
        	ptr = head;
        	head = tmp;
        }
        if (head != null)
        	ptr.next = head;
        return res.next;
    }
}