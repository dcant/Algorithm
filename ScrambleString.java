package cn.edu.sjtu.zzang;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
        	return false;
        if (s1.length() == 0)
        	return true;
        boolean[][][] flag = new boolean[s1.length()][s1.length()][s1.length() + 1];
        for (int i = 0; i < s1.length(); i++)
        	for (int j = 0; j < s2.length(); j++)
        		flag[i][j][1] = s1.charAt(i) == s2.charAt(j);
        for (int len = 2; len <= s1.length(); len++) {
        	for (int i = 0; i < s1.length() - len + 1; i++) {
        		for (int j = 0; j < s2.length() - len + 1; j++) {
        			for (int k = 1; k < len; k++) {
        				flag[i][j][len] |= flag[i][j][k] && flag[i + k][j + k][len - k] || flag[i][j + len - k][k] && flag[i + k][j][len - k];
        			}
        		}
        	}
        }
        return flag[0][0][s1.length()];
    }
}