package cn.edu.sjtu.zzang;

public class PalindromePartitionningII {
	public static void main(String[] args) {
		PalindromePartitionningII pp = new PalindromePartitionningII();
		System.out.println(pp.minCut("abababa"));
	}
	
	public int minCut(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int len = s.length();
		boolean[][] flag = new boolean[len][len];
		int[] min = new int[len + 1];
		for (int i = 0; i < len; i++)
			min[i] = len - i;
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || flag[i+1][j-1] == true)) {
					flag[i][j] = true;
					min[i] = min[i] < min[j+1] + 1 ? min[i] : min[j+1] + 1;
				}
			}
		}
		return min[0] - 1;
	}
	
	// time limit exceeded
//    public int minCut(String s) {
//        if (s == null || s.length() == 0)
//        	return 0;
//        ArrayList<Integer> cuts = new ArrayList<Integer>();
//        cut(s, 0, 0, cuts);
//        int min = Integer.MAX_VALUE;
//        for (int num : cuts) {
//        	if (num < min)
//        		min = num;
//        }
//        return min;
//    }
//    
//    private void cut(String s, int lo, int num, ArrayList<Integer> cuts) {
//    	if (lo == s.length()) {
//    		cuts.add(num - 1);
//    		return;
//    	}
//    	for (int i = lo + 1; i <= s.length(); i++) {
//    		String sub = s.substring(lo, i);
//    		if (isPalindrome(sub)) {
//    			cut(s, i, num + 1, cuts);
//    		}
//    	}
//    }
//
//    private boolean isPalindrome(String sub) {
//    	int lo = 0;
//    	int hi = sub.length() - 1;
//    	while (lo < hi) {
//    		if (sub.charAt(lo) != sub.charAt(hi))
//    			return false;
//    		lo++;
//    		hi--;
//    	}
//    	return true;
//    }
}
