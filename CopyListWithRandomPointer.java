package cn.edu.sjtu.zzang;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
        	return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newhead = new RandomListNode(head.label);
        map.put(head, newhead);
        RandomListNode p = head;
        RandomListNode q = newhead;
        p = p.next;
        
        while (p != null) {
        	RandomListNode tmp = new RandomListNode(p.label);
        	map.put(p, tmp);
        	q.next = tmp;
        	q = q.next;
        	p = p.next;
        }
        
        p = head;
        q = newhead;
        while (p != null) {
        	if (p.random != null)
        		q.random = map.get(p.random);
        	else
        		q.random = null;
        	p = p.next;
        	q = q.next;
        }

        return newhead;
    }
}
