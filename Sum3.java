package cn.edu.sjtu.zzang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Sum3 {
	public static void main(String[] args) {
		
	}

    public List<LinkedList<Integer>> threeSum(int[] num) {
        List<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
        if (num.length < 3)
        	return result;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
        	if ( i == 0 || num[i] != num[i - 1]) {
        		int tmp = -num[i];
        		int lo = i + 1;
        		int hi = num.length - 1;
        		while (lo < hi) {
        			if (num[lo] + num[hi] == tmp) {
        				LinkedList<Integer> m = new LinkedList<Integer>();
        				m.add(num[i]);
        				m.add(num[lo]);
        				m.add(num[hi]);
        				result.add(m);
        				lo++;
        				hi--;
        				while (lo < hi && num[lo] == num[lo - 1])
        					lo++;
        				while (lo < hi && num[hi] == num[hi + 1])
        					hi--;
        			}else if (num[lo] + num[hi] > tmp)
        				hi--;
        			else
        				lo++;
        		}
        	}
        }
        return result;
    }
}
