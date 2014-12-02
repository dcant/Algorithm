package cn.edu.sjtu.zzang;

public class FirstMissingPositive {
	public static void main(String[] args) {
		int[] a = {1};
		FirstMissingPositive fm = new FirstMissingPositive();
		System.out.println(fm.firstMissingPositive(a));
	}
    public int firstMissingPositive(int[] A) {
    	int j = 0;
    	for (int i = 0; i < A.length; i++) {
    		if (A[i] <= 0) {
    			int tmp = A[i];
    			A[i] = A[j];
    			A[j] = tmp;
    			j++;
    		}
    	}
    	for (int k = j; k < A.length; k++) {
    		if (Math.abs(A[k]) - 1 < A.length - j && A[j + Math.abs(A[k]) - 1] > 0)
    			A[j + Math.abs(A[k]) - 1] = -A[j + Math.abs(A[k]) - 1];
    	}
    	for (int k = j; k < A.length; k++) {
    		if (A[k] > 0)
    			return k - j + 1;
    	}
    	return A.length - j + 1;
    }
}
