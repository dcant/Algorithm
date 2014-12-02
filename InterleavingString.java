package cn.edu.sjtu.zzang;

public class InterleavingString {
	public static void main(String[] args) {
		InterleavingString is = new InterleavingString();
		String s1 = "ab";
		String s2 = "aa";
		System.out.println(is.isInterleave(s1, s2, "aaab"));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		boolean[][] flag = new boolean[s1.length() + 1][s2.length() + 1];
		flag[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1))
				flag[i][0] = true;
			else
				break;
		}
		for (int j = 1; j <= s2.length(); j++) {
			if (s2.charAt(j - 1) == s3.charAt(j - 1))
				flag[0][j] = true;
			else
				break;
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s3.charAt(i + j - 1))
					flag[i][j] |= flag[i - 1][j];
				if (s2.charAt(j - 1) == s3.charAt(i + j - 1))
					flag[i][j] |= flag[i][j - 1];
			}
		}
		return flag[s1.length()][s2.length()];
	}
	
	// big data set timeout
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s3.length() != s1.length() + s2.length())
//        	return false;
//        if (s3.length() == 0)
//        	return true;
//        if (s1.length() == 0) {
//        	if (s2.charAt(0) != s3.charAt(0))
//        		return false;
//        	else
//        		return isInterleave(s1, s2.substring(1), s3.substring(1));
//        } else if (s2.length() == 0) {
//        	if (s1.charAt(0) != s3.charAt(0))
//        		return false;
//        	else return isInterleave(s1.substring(1), s2, s3.substring(1));
//        } else if (s1.charAt(0) != s3.charAt(0) && s2.charAt(0) != s3.charAt(0))
//        	return false;
//        boolean flag1 = false, flag2 = false;
//        if (s1.charAt(0) == s3.charAt(0))
//        	flag1 = isInterleave(s1.substring(1), s2, s3.substring(1));
//        if (s2.charAt(0) == s3.charAt(0))
//        	flag2 = isInterleave(s1, s2.substring(1), s3.substring(1));
//        return flag1 || flag2;
//    }
}
