package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PascalsTriangle {
	public static void main(String[] args) {
		PascalsTriangle pt = new PascalsTriangle();
		ArrayList<ArrayList<Integer>> res = pt.generate(5);
		for (ArrayList<Integer> item : res) {
			for (int i : item)
				System.out.print(i);
			System.out.println();
		}
	}
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numRows; i++) {
        	ArrayList<Integer> item = new ArrayList<Integer>();
        	int pre = 0;
        	while (!queue.isEmpty()) {
        		int cur = queue.poll();
        		item.add(cur + pre);
        		pre = cur;
        	}
        	item.add(1);
        	for (int k : item)
        		queue.add(k);
        	res.add(new ArrayList<Integer>(item));
        }
        return res;
    }
}
