package cn.edu.sjtu.zzang;

public class PartitionList {
	public static void main(String[] args) {
		
	}

    public ListNode partition(ListNode head, int x) {
    	if (head == null)
    		return null;
        ListNode res = new ListNode(0);
        ListNode tmp = new ListNode(0);
        res.next = head;
        ListNode p = head;
        ListNode pre = res;
        ListNode ptr = tmp;
        while (p != null) {
        	if (p.val < x) {
        		p = p.next;
        		pre = pre.next;
        	} else {
        		ptr.next = p;
        		pre.next = p.next;
        		p = p.next;
        		ptr = ptr.next;
        	}
        }
        ptr.next = null;
        pre.next = tmp.next;
        return res.next;
    }
}
