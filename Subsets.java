package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] S = {4,1,0};
		ArrayList<ArrayList<Integer>> res = s.subsets(S);
		for (ArrayList<Integer> item : res) {
			for (int i : item)
				System.out.print(i);
			System.out.println();
		}
	}

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        int l = 1 << S.length;
        for (int i = 0; i < l; i++) {
        	ArrayList<Integer> item = new ArrayList<Integer>();
        	for (int j = 0; j < S.length; j++) {
        		if ((i & (1 << j)) != 0)
        			item.add(S[j]);
        	}
        	res.add(new ArrayList<Integer>(item));
        }
        return res;
    }
}
