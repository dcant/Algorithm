package cn.edu.sjtu.zzang;

public class MaximumSubarray {
	public static void main(String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(ms.maxSubArray(A));
	}

    public int maxSubArray(int[] A) {
        int max = -Integer.MAX_VALUE;
        int curMax = 0;
        for (int i = 0; i < A.length; i++) {
        	if (curMax > 0) {
        		curMax += A[i];
        		if (curMax > max)
        			max = curMax;
        	} else {
        		curMax = A[i];
        		if (curMax > max)
        			max = curMax;
        	}
        }
        return max;
    }
}
