package cn.edu.sjtu.zzang;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int[] tmp = new int[m];
        for (int i = 0; i < m; i++)
        	tmp[i] = A[i];
        int i = 0, j = 0, indx = 0;
        while (i < m && j < n) {
        	if (tmp[i] <= B[j])
        		A[indx++] = tmp[i++];
        	else
        		A[indx++] = B[j++];
        }
        while (i < m)
        	A[indx++] = tmp[i++];
        while (j < n)
        	A[indx++] = B[j++];
    }
}
