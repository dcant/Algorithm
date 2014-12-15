package cn.edu.sjtu.zzang;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
        	return null;
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        queue.add(node);
        map.put(node, res);
        while (!queue.isEmpty()) {
        	UndirectedGraphNode cur = queue.poll();
        	List<UndirectedGraphNode> neighbors = cur.neighbors;
        	for (UndirectedGraphNode neighbor : neighbors) {
        		if (!map.containsKey(neighbor)) {
        			UndirectedGraphNode tmp = new UndirectedGraphNode(neighbor.label);
        			queue.add(neighbor);
        			map.put(neighbor, tmp);
        			map.get(cur).neighbors.add(tmp);
        		} else 
        			map.get(cur).neighbors.add(map.get(neighbor));
        	}
        }
        return res;
    }
}
