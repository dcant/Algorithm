package cn.edu.sjtu.zzang;

public class ImplementStrstr {
	public static void main(String[] args) {
		ImplementStrstr is = new ImplementStrstr();
		System.out.println(is.strStr("helloworld", "world"));
	}
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length())
        	return -1;
        int i = 0;
        for (; i < haystack.length() - needle.length(); i++) {
        	if (haystack.substring(i, i + needle.length()).equals(needle))
        		return i;
        }
        if (haystack.substring(i).equals(needle))
        	return i;
        else
        	return -1;
    }
}
