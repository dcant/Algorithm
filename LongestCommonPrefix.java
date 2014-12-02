package cn.edu.sjtu.zzang;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = {"hello", "hell", "helloworld"};
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println(lcp.longestCommonPrefix(strs));
	}
	
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
        	return "";
        for (int i = 0; i < strs[0].length(); i++) {
        	char c = strs[0].charAt(i);
        	for (int j = 0; j < strs.length; j++) {
        		if (i >= strs[j].length() || strs[j].charAt(i) != c)
        			return strs[0].substring(0, i);
        	}
        }
        return strs[0];
    }
}
