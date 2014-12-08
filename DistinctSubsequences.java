package cn.edu.sjtu.zzang;

public class DistinctSubsequences {
	public static void main(String[] args) {
    	DistinctSubsequences ds = new DistinctSubsequences();
    	String S = "daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac";
    	String T = "ceadbaa";
    	System.out.println(ds.numDistinct(S, T));
	}

	public int numDistinct(String S, String T) {
		int[][] res = new int[S.length() + 1][T.length() + 1];
	 
		for (int i = 0; i < S.length(); i++)
			res[i][0] = 1;
	 
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					res[i][j] += res[i - 1][j] + res[i - 1][j - 1];
				} else {
					res[i][j] += res[i - 1][j];
				}
			}
		}
	 
		return res[S.length()][T.length()];
	}
	
	// time limit exceeded
//    public int numDistinct(String S, String T) {
//    	return counter(S, T, 0, 0);
//    }
//    
//    private int counter(String S, String T, int indxs, int indxt) {
//    	if (indxt == T.length()) {
//    		return 1;
//    	} else {
//    		int count = 0;
//    		for (int i = indxs; i <= S.length() - T.length() + indxt; i++) {
//    			if (S.charAt(i) == T.charAt(indxt))
//    				count += counter(S, T, i + 1, indxt + 1);
//    		}
//    		return count;
//    	}
//    }
}
