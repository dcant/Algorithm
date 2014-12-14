package cn.edu.sjtu.zzang;

import java.util.ArrayList;

public class PalindromePartitioning {
	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		ArrayList<ArrayList<String>> res = pp.partition("aab");
		for (ArrayList<String> p : res) {
			for (String s : p)
				System.out.print(s + " ");
			System.out.println();
		}
	}
	
    public ArrayList<ArrayList<String>> partition(String s) {
    	ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s == null || s.length() == 0)
        	return res;
        ArrayList<String> palindromes = new ArrayList<String>();
        worker(s, 0, palindromes, res);
        return res;
    }
    
    private void worker(String s, int lo, ArrayList<String> palindromes, ArrayList<ArrayList<String>> res) {
    	if (lo == s.length()) {
    		res.add(new ArrayList<String>(palindromes));
    		return;
    	}
    	for (int i = lo + 1; i <= s.length(); i++) {
    		String sub = s.substring(lo, i);
    		if (isPalindrome(sub)) {
    			palindromes.add(sub);
    			worker(s, i, palindromes, res);
    			palindromes.remove(palindromes.size() - 1);
    		}
    	}
    }
    
    private boolean isPalindrome(String sub) {
    	int lo = 0;
    	int hi = sub.length() - 1;
    	while (lo < hi) {
    		if (sub.charAt(lo) != sub.charAt(hi))
    			return false;
    		lo++;
    		hi--;
    	}
    	return true;
    }
}
