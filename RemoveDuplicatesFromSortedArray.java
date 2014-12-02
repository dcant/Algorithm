package cn.edu.sjtu.zzang;

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray rd = new RemoveDuplicatesFromSortedArray();
		int[] A = {1, 1, 1, 2, 3, 3};
		System.out.println(rd.removeDuplicates(A));
	}
	
    public int removeDuplicates(int[] A) {
    	if (A.length == 0)
    		return 0;
        int i = 0;
        int j = 0;
        while (j < A.length) {
        	if (A[j] == A[i])
        		j++;
        	else
        		A[++i] = A[j++];
        }
        return i+1;
    }
}
