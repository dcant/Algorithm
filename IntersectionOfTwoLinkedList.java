package cn.edu.sjtu.zzang;

public class IntersectionOfTwoLinkedList {
	public static void main(String[] args) {
		IntersectionOfTwoLinkedList io = new IntersectionOfTwoLinkedList();
		ListNode headA = new ListNode(1);
		ListNode headB = new ListNode(1);
		System.out.println(io.getIntersectionNode(headA, headB).val);
	}

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
        	return null;
        int alen = 0, blen = 0;
        ListNode pa = headA, pb = headB;
        while (pa != null) {
        	alen++;
        	pa = pa.next;
        }
        while (pb != null) {
        	blen++;
        	pb = pb.next;
        }
        int d = 0;
        ListNode big = headA, small = headB;
        if (alen > blen) {
        	big = headA;
        	small = headB;
        	d = alen - blen;
        } else if (alen < blen) {
        	big = headB;
        	small = headA;
        	d = blen - alen;
        }
        return isSame(big, small, d);
    }
    
    private ListNode isSame(ListNode big, ListNode small, int d) {
    	while (d > 0) {
    		big = big.next;
    		d--;
    	}
    	while (big != null && small != null) {
    		if (big.val == small.val)
    			return big;
    		big = big.next;
    		small = small.next;
    	}
    	return null;
    }
}
