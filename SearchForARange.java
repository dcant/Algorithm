package cn.edu.sjtu.zzang;

public class SearchForARange {
	public static void main(String[] args) {
		int[] A = {5, 7, 7, 8, 8, 10};
		SearchForARange sf = new SearchForARange();
		int[] res = sf.searchRange(A, 6);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
	
    public int[] searchRange(int[] A, int target) {
    	int[] res = {-1, -1};
    	if (A.length == 0)
    		return res;
    	int start = -1, end = -1;
    	int lo = 0, hi = A.length - 1;
    	int mid;
    	while (lo < hi) {
    		mid = (lo + hi) / 2;
    		if (A[mid] < target)
    			lo = mid + 1;
    		else
    			hi = mid;
    	}
    	if (A[lo] == target)
    		start = lo;
    	
    	lo = 0;
    	hi = A.length - 1;
    	while (lo < hi) {
    		mid = (lo + hi) / 2;
    		if (A[mid] < target + 1)
    			lo = mid + 1;
    		else
    			hi = mid;
    	}
    	end = A[lo] == target ? lo : (lo == 0 ? -1 : A[lo - 1] == target ? lo - 1 : -1);
    	res[0] = start;
    	res[1] = end;
    	return res;
    }
}
