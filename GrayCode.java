package cn.edu.sjtu.zzang;

import java.util.ArrayList;

public class GrayCode {
	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		ArrayList<Integer> res = gc.grayCode(3);
		for (int i : res)
			System.out.print(i + " ");
	}

    public ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	res.add(0);
    	for (int i = 0; i < n; i++) {
    		int size = res.size();
    		for (int j = size - 1; j >= 0; j--)
    			res.add(res.get(j) + size);
    	}
    	return res;
    }
}
