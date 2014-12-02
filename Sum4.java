package cn.edu.sjtu.zzang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sum4 {
	public static void main(String[] args) {
		
	}
	
    public List<LinkedList<Integer>> fourSum(int[] num, int target) {
    	if (num.length < 4)
    		return null;
    	List<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
        	for (int j = i + 1; j < num.length - 2; j++) {
        		int lo = j + 1;
        		int hi = num.length - 1;
        		while (lo < hi) {
        			int sum = num[i] + num[j] + num[lo] + num[hi];
        			if (sum == target) {
        				LinkedList<Integer> tmp = new LinkedList<Integer>();
        				tmp.add(num[i]);
        				tmp.add(num[j]);
        				tmp.add(num[lo]);
        				tmp.add(num[hi]);
        				result.add(tmp);
        				lo++;
        				hi--;
        				while (lo < hi && num[lo] == num[lo - 1])
        					lo++;
        				while (lo < hi && num[hi] == num[hi + 1])
        					hi--;
        			} else if (sum < target) {
        				lo++;
        			} else {
        				hi--;
        			}
        		}
        	}
        }
        return result;
    }
}
