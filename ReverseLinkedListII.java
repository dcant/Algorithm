package cn.edu.sjtu.zzang;

public class ReverseLinkedListII {
	public static void main(String[] args) {
		ReverseLinkedListII rl = new ReverseLinkedListII();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		ListNode res = rl.reverseBetween(one, 1, 1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (head == null || m == n)
    		return head;
        ListNode res = new ListNode(0); // head of the result;
        ListNode nhead = new ListNode(0); // head of the reversed listnode;
        ListNode ntail, p = head, pr = res, tmp = null; // ntail is the tail of the reversed listnode
        pr.next = head;
        int i = 1;
        while (i < m) {
        	pr = pr.next;
        	p = p.next;
        	i++;
        }
        ntail = p;
        while (i <= n) {
        	tmp = p.next;
        	p.next = nhead.next;
        	nhead.next = p;
        	p = tmp;
        	i++;
        }
        ntail.next = tmp;
        pr.next = nhead.next;
        return res.next;
    }
}
