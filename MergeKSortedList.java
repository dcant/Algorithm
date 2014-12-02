package cn.edu.sjtu.zzang;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MergeKSortedList {
	public static void main(String[] args) {
		
	}
	
    public ListNode mergeKLists(LinkedList<ListNode> lists) {
        if (lists.size() == 0)
        	return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {

			@Override
			public int compare(ListNode arg0, ListNode arg1) {
	        	if (arg0.val < arg1.val)
	        		return -1;
	        	else if (arg0.val == arg1.val)
	        		return 0;
	        	else
	        		return 1;
			}
        });
        for (int i = 0; i < lists.size(); i++) {
        	if (lists.get(i) != null)
        		pq.add(lists.get(i));
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (!pq.isEmpty()) {
        	ListNode tmp = pq.poll();
        	p.next = tmp;
        	if (tmp.next != null)
        		pq.add(tmp.next);
        	p = p.next;
        }
        return head.next;
    }
}
