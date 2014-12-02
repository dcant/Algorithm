package cn.edu.sjtu.zzang;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}
	private String preProcess(String s) {
		int len = s.length();
		if (len == 0)
			return "^#$";
		String str = "^#";
		for (int i = 0; i < len; i++)
			str += s.substring(i, i+1) + "#";
		str += "$";
		return str;
	}
    public String longestPalindrome(String s) {
        String tmp = preProcess(s);
        int len = tmp.length();
        int Rightedge = 0;
        int Center = 0;
        int[] Cover = new int[len];
        for (int i = 1; i < len - 1; i++) {
        	int iMirror = 2 * Center - i;
        	Cover[i] = (Rightedge > i) ? Math.min(Cover[iMirror], Rightedge - i) : 0;
        	while (tmp.charAt(i + 1 + Cover[i]) == tmp.charAt(i - 1 - Cover[i]))
        		Cover[i]++;
        	if (i + Cover[i] > Rightedge) {
        		Center = i;
        		Rightedge = i + Cover[i];
        	}
        }
        int maxlen = 0;
        int centerIndx = 0;
        for (int i = 1; i < len - 1; i++) {
        	if (Cover[i] > maxlen) {
        		maxlen = Cover[i];
        		centerIndx = i;
        	}
        }
        System.out.println(s.length());
        System.out.println(maxlen);
        System.out.println(centerIndx);
        int end = (centerIndx -1 + maxlen) / 2;
        System.out.println(end);
        if (end >= s.length())
        	return s.substring((centerIndx - 1 - maxlen) / 2);
        else
        	return s.substring((centerIndx - 1 - maxlen) / 2, end);
    }
}
