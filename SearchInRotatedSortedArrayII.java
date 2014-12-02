package cn.edu.sjtu.zzang;

public class SearchInRotatedSortedArrayII {
	public static void main(String[] args) {
		SearchInRotatedSortedArrayII sir = new SearchInRotatedSortedArrayII();
		int[] A = {3,1,1};
		System.out.println(sir.search(A, 3));
	}

    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0)
        	return false;
        int lo = 0, hi = A.length - 1;
        while (lo <= hi) {
        	int mid = (lo + hi) >> 1;
        	if (A[mid] == target)
        		return true;
        	if (A[mid] > A[lo]) {
        		if (A[mid] > target && A[lo] <= target) {
        			hi = mid - 1;
        		} else 
        			lo = mid + 1;
        	} else if (A[mid] < A[lo]) {
        		if (A[mid] < target && A[hi] >= target)
        			lo = mid + 1;
        		else
        			hi = mid - 1;
        	} else
        		lo++;
        }
        return false;
    }
}
