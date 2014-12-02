package cn.edu.sjtu.zzang;

public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int[] a = {6,7,1,2,3,4,5};
		SearchInRotatedSortedArray si = new SearchInRotatedSortedArray();
		System.out.println(si.search(a, 1));
	}
	
    public int search(int[] A, int target) {
        return searchhelper(A, 0, A.length - 1, target);
    }
    private int searchhelper(int[] A, int lo, int hi, int target) {
    	if (lo == hi && A[lo] != target)
    		return -1;
    	int mid = (lo + hi) / 2;
    	if (lo == mid) {
    		if (A[lo] == target)
    			return lo;
    		else if (A[hi] == target)
    			return hi;
    		return -1;
    	}
    	if (A[lo] < A[mid] && A[mid] < A[hi]) {
    		if (A[mid] < target)
    			return searchhelper(A, mid, hi, target);
    		else if (A[mid] > target)
    			return searchhelper(A, lo, mid, target);
    		else
    			return mid;
    	} else if (A[lo] < A[mid] && A[mid] > A[hi]) {
    		if (A[lo] < target && A[mid] > target)
    			return searchhelper(A, lo, mid, target);
    		else if(A[lo] > target || A[mid] < target)
    			return searchhelper(A, mid, hi, target);
    		else if (A[lo] == target)
    			return lo;
    		else if (A[mid] == target)
    			return mid;
    		else
    			return hi;
    	} else {
    		if (A[lo] < target || target < A[mid])
    			return searchhelper(A, lo, mid, target);
    		else if (A[lo] > target && A[mid] < target)
    			return searchhelper(A, mid, hi, target);
    		else if (A[lo] == target)
    			return lo;
    		else if (A[mid] == target)
    			return mid;
    		else
    			return hi;
    	}
    }
}
