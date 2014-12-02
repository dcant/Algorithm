package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
	public static void main(String[] args) {
		SubsetsII s = new SubsetsII();
		int[] S = {4,1,1};
		ArrayList<ArrayList<Integer>> res = s.subsetsWithDup(S);
		for (ArrayList<Integer> item : res) {
			for (int i : item)
				System.out.print(i);
			System.out.println();
		}
	}

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int l = 1 << num.length;
        for (int i = 0; i < l; i++) {
        	ArrayList<Integer> tmp = new ArrayList<Integer>();
        	for (int j = 0; j < num.length; j++) {
        		if ((i & (1 << j)) != 0)
        			tmp.add(num[j]);
        	}
        	if (!res.contains(tmp))
        		res.add(new ArrayList<Integer>(tmp));
        }
        return res;
    }
	
//	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
//		if (num == null)
//			return null;
//		Arrays.sort(num);
//		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//		ArrayList<ArrayList<Integer>> pre = new ArrayList<ArrayList<Integer>>();
//		for (int i = num.length - 1; i >= 0; i--) {
//			if (i == num.length - 1 || num[i] != num[i + 1] || pre.size() == 0) {
//				pre = new ArrayList<ArrayList<Integer>>();
//				for (ArrayList<Integer> tmp : res)
//					pre.add(new ArrayList<Integer>(tmp));
//			}
//			for (ArrayList<Integer> tmp : pre)
//				tmp.add(0, num[i]);
//			if (i == num.length - 1 || num[i] != num[i + 1]) {
//				ArrayList<Integer> tmp = new ArrayList<Integer>();
//				tmp.add(0, num[i]);
//				pre.add(tmp);
//			}
//			for (ArrayList<Integer> tmp : pre)
//				res.add(new ArrayList<Integer>(tmp));
//		}
//		res.add(new ArrayList<Integer>());
//		return res;
//	}
}
