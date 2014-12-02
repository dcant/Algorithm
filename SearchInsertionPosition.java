package cn.edu.sjtu.zzang;

public class SearchInsertionPosition {
	public static void main(String[] args) {
		int[] A = {1, 3, 5, 6};
		SearchInsertionPosition sip = new SearchInsertionPosition();
		System.out.println(sip.searchInsert(A, 7));
	}
	
    public int searchInsert(int[] A, int target) {
        int lo = 0, hi = A.length - 1, mid;
        while (lo < hi) {
        	mid = (lo + hi) / 2;
        	if (A[mid] < target)
        		lo = mid + 1;
        	else
        		hi = mid;
        }
        return A[lo] >= target ? lo : lo + 1;
    }
}
