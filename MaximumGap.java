package cn.edu.sjtu.zzang;

import java.util.Arrays;
import java.util.HashSet;

public class MaximumGap {
	public static void main(String[] args) {
		MaximumGap mg = new MaximumGap();
		int[] num = {2, 4, 3, 5, 7};
		System.out.println(mg.maximumGap(num));
	}
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2)
        	return 0;
        int min = num[0];
        int max = num[0];
        for (int ele : num) {
        	min = Math.min(min, ele);
        	max = Math.max(max, ele);
        }
        int gap = (int)Math.ceil((double)(max - min) / (num.length - 1));
        int[] bucket_max = new int[num.length - 1];
        int[] bucket_min = new int[num.length - 1];
        Arrays.fill(bucket_min, Integer.MAX_VALUE);
        Arrays.fill(bucket_max, Integer.MIN_VALUE);
        for (int ele : num) {
        	if (ele == min || ele == max)
        		continue;
        	int indx = (ele - min) / gap;
        	bucket_max[indx] = Math.max(bucket_max[indx], ele);
        	bucket_min[indx] = Math.min(bucket_min[indx], ele);
        }
        int maxgap = 0;
        int pre = min;
        for (int i = 0; i < num.length - 1; i++) {
        	if (bucket_max[i] == Integer.MIN_VALUE && bucket_min[i] == Integer.MAX_VALUE)
        		continue;
        	maxgap = Math.max(maxgap, bucket_min[i] - pre);
        	pre = bucket_max[i];
        }
        maxgap = Math.max(maxgap, max - pre);
        return maxgap;
    }
}
