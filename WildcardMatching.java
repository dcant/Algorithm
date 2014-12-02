package cn.edu.sjtu.zzang;

public class WildcardMatching {
	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();
		System.out.println(wm.isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb",
				"b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
	}
	
//    public boolean isMatch(String s, String p) {
//        if (p.length() == 0)
//        	return s.length() == 0;
//        if (p.length() == 1) {
//        	if (p.charAt(0) == '*')
//        		return s.length() != 0;
//        	else
//        		return s.length() == 1 && (p.charAt(0) == '?' || s.charAt(0) == p.charAt(0));
//        } else {
//        	if (p.charAt(0) == '*') {
//        		int slen = s.length(), plen = p.length();
//        		int i = 1;
//        		while (i < plen && p.charAt(i) == '*')
//        			i++;
//        		if (i == plen)
//        			return true;
//        		int j = 0;
//        		while (j < slen) {
//        			if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) {
//        				if (!checklen(p.substring(i + 1), slen - j))
//        					return false;
//        				if (isMatch(s.substring(j + 1), p.substring(i + 1)))
//        					return true;
//        			}
//        			j++;
//        		}
//        		return false;
//        	} else {
//        		return (s.length() != 0 && s.charAt(0) == p.charAt(0) && isMatch(s.substring(1), p.substring(1)));
//        	}
//        }
//    }
	
	public boolean isMatch(String s, String p) {
		int slen = s.length();
		int plen = p.length();
		if (!checklen(p, slen))
			return false;
		boolean[][] state = new boolean[2][plen + 1];
		boolean[] flag = new boolean[plen + 1];
		state[0][0] = true;
		flag[0] = true;
		for (int i = 0; i < plen && p.charAt(i) == '*'; i++) {
			state[0][i + 1] = true;
			flag[i + 1] = true;
		}
		int pre = 1;
		int cur = 0;
		for (int i = 0; i < slen; i++) {
			pre = (pre == 1 ? 0 : 1);
			cur = (cur == 0 ? 1 : 0);
			state[cur][0] = false;
			for (int j = 0; j < plen; j++) {
				if (p.charAt(j) == '?')
					state[cur][j + 1] = state[pre][j];
				else if (p.charAt(j) == '*') {
					if (j > 0 && p.charAt(j - 1) == '*')
						state[cur][j + 1] = state[cur][j];
					else {
						if (flag[j])
							state[cur][j + 1] = true;
						else
							state[cur][j + 1] = false;
					}
				} else {
					if (s.charAt(i) == p.charAt(j))
						state[cur][j + 1] = state[pre][j];
					else
						state[cur][j + 1] = false;
				}
				if (state[cur][j + 1])
					flag[j + 1] = true;
			}
		}
		return state[cur][plen];
	}
    private boolean checklen(String p, int slen) {
    	int count = 0;
    	for (int i = 0, plen = p.length(); i < plen; i++) {
    		if (p.charAt(i) != '*')
    			count++;
    	}
    	if (count > slen)
    		return false;
    	return true;
    }
}