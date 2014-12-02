package cn.edu.sjtu.zzang;

public class TrappingRainWater {
	public static void main(String[] args) {
		TrappingRainWater trw = new TrappingRainWater();
		int[] A = {0};
		System.out.println(trw.trap(A));
	}

    public int trap(int[] A) {
        if (A == null || A.length == 0)
        	return 0;
        int[] maxLeft = new int[A.length - 1];
        int[] maxRight = new int[A.length - 1];
        int max = A[0];
        for (int i = 1; i < A.length - 1; i++) {
        	maxLeft[i - 1] = max;
        	if (A[i] > max)
        		max = A[i];
        }
        max = A[A.length - 1];
        for (int i = A.length - 2; i > 0; i--) {
        	maxRight[i - 1] = max;
        	if (A[i] > max)
        		max = A[i];
        }
        int res = 0;
        for (int i = 1; i < A.length - 1; i++) {
        	int tmp = Math.min(maxLeft[i - 1], maxRight[i - 1]) - A[i];
        	if (tmp > 0)
        		res += tmp;
        }
        return res;
    }
}
