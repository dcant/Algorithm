package cn.edu.sjtu.zzang;

public class ValidPalindrome {
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("1e1"));
	}
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
        	return true;
        int len = s.length();
        int i = 0, j = len - 1;
        while (i < j) {
        	while (i < j && !isalphanum(s.charAt(i)))
        		i++;
        	while (i < j && !isalphanum(s.charAt(j)))
        		j--;
        	if (!eq(s.charAt(i), s.charAt(j)))
        		return false;
        	i++;
        	j--;
        }
        return true;
    }
    
    private boolean isalphanum(char c) {
    	if ( (c - 'a' >= 0 && c - 'a' < 26) || (c - 'A' >= 0 && c - 'A' < 26) || (c - '0' >= 0 && c - '0' < 10))
    		return true;
    	else
    		return false;
    }
    
    private boolean eq(char c1, char c2) {
    	int i = 0, j = 0;
    	if (c1 - 'a' >= 0 && c1 - 'a' < 26)
    		i = c1 - 'z';
    	else if (c1 - 'A' >= 0 && c1 - 'A' < 26)
    		i = c1 - 'Z';
    	else
    		i = c1 - '0';
    	if (c2 - 'a' >= 0 && c2 - 'a' < 26)
    		j = c2 - 'z';
    	else if (c2 - 'A' >= 0 && c2 - 'A' < 26) 
    		j = c2 - 'Z';
    	else
    		j = c2 - '0';
    	return i == j;
    }
}
