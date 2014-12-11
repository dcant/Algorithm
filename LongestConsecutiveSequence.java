package cn.edu.sjtu.zzang;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int[] num = {100, 4, 200, 1, 3, 2};
		System.out.println(lcs.longestConsecutive(num));
	}
    public int longestConsecutive(int[] num) {
        if (num == null)
        	return 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i : num)
        	set.add(i);
        int max = 1;
        for (int i = 0; i < num.length; i++) {
        	int left = num[i] - 1;
        	int right = num[i] + 1;
        	int count = 1;
        	while (set.contains(left)) {
        		count++;
        		set.remove(left);
        		left--;
        	}
        	while (set.contains(right)) {
        		count++;
        		set.remove(right);
        		right++;
        	}
        	max = Math.max(max, count);
        }
        return max;
    }
}
