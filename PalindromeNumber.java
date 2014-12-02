package cn.edu.sjtu.zzang;

public class PalindromeNumber {
	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.isPalindrome(10));
		System.out.println(pn.isPalindrome(121));
	}
	
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int factor = 1;
		while (x / factor >= 10) {
			factor *= 10;
		}
		while (x != 0) {
			int hi = x / factor;
			int lo = x % 10;
			if (hi != lo)
				return false;
			x = (x % factor) / 10;
			factor /= 100;
		}
		return true;
	}
}
