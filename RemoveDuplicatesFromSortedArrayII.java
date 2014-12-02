package cn.edu.sjtu.zzang;

public class RemoveDuplicatesFromSortedArrayII {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII rd = new RemoveDuplicatesFromSortedArrayII();
		int[] A = {1,1,1,1};
		System.out.println(rd.removeDuplicates(A));
	}

    public int removeDuplicates(int[] A) {
    	if (A == null || A.length == 0)
    		return 0;
    	if (A.length == 1)
    		return 1;
    	int res = 1;
    	int count = 1, i = 1;
        while (i < A.length) {
        	while (i < A.length && A[i - 1] == A[i]) {
        		if (count < 2) {
        			A[res++] = A[i];
        			count++;
        		}
        		i++;
        	}
        	if (i < A.length) {
	        	A[res++] = A[i];
	        	count = 1;
	        	i++;
        	}
        }
        return res;
    }
}
