package cn.edu.sjtu.zzang;

import java.util.Arrays;

public class Sum3Closest {
	public static void main(String[] args) {
		Sum3Closest sc = new Sum3Closest();
		int[] num = {0, 2, 1, -3};
		System.out.println(sc.threeSumClosest(num, 1));
	}
	
    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3)
        	return Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
        	if (i == 0 || num[i] != num[i - 1]) {
        		int lo = i + 1;
        		int hi = num.length - 1;
        		while (lo < hi) {
        			int total = num[i] + num[lo] + num[hi];
        			int diff = Math.abs(total - target);
        			if (diff < min) {
        				min = diff;
        				result = total;
        			}
        			if (total == target) {
        				lo++;
        				hi--;
        			} else if (total < target)
        				lo++;
        			else
        				hi--;
        		}
        	}
        }
        return result;
    }
}
