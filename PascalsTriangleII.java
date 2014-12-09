package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PascalsTriangleII {
	public static void main(String[] args) {
		PascalsTriangleII pt = new PascalsTriangleII();
		List<Integer> res = pt.getRow(3);
		for (int i : res) {
			System.out.print(i);
		}
	}
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
        	ArrayList<Integer> item = new ArrayList<Integer>();
        	int pre = 0;
        	while (!queue.isEmpty()) {
        		int cur = queue.poll();
        		item.add(cur + pre);
        		pre = cur;
        	}
        	item.add(1);
        	if (i == rowIndex) {
        		for (int k : item)
        			res.add(k);
        		break;
        	}
        	for (int k : item)
        		queue.add(k);
        }
        return res;
    }
}
