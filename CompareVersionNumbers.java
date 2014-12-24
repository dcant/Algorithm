package cn.edu.sjtu.zzang;

public class CompareVersionNumbers {
	public static void main(String[] args) {
		CompareVersionNumbers cvn = new CompareVersionNumbers();
		System.out.println(cvn.compareVersion("01.0", "1"));
	}
    public int compareVersion(String version1, String version2) {
    	int dot1 = -1, dot2 = -1;
    	int fv = 0, sv = 0;
    	while (dot1 < version1.length() && dot2 < version2.length()) {
    		int i = dot1 + 1;
    		while (i < version1.length() && version1.charAt(i) != '.')
    			i++;
    		fv = Integer.valueOf(version1.substring(dot1 + 1, i));
    		dot1 = i;
    		i = dot2 + 1;
    		while (i < version2.length() && version2.charAt(i) != '.')
    			i++;
    		sv = Integer.valueOf(version2.substring(dot2 + 1, i));
    		dot2 = i;
    		if (fv < sv)
    			return -1;
    		else if (fv > sv)
    			return 1;
    		else
    			continue;
    	}
    	if (dot1 < version1.length()) {
    		while (dot1 < version1.length()) {
    			int i = dot1 + 1;
    			while (i < version1.length() && version1.charAt(i) != '.')
    				i++;
    			if (Integer.valueOf(version1.substring(dot1 + 1, i)) != 0)
    				return 1;
    			dot1 = i;
    		}
    		return 0;
    	}
    	else if (dot2 < version2.length()) {
    		while (dot2 < version2.length()) {
    			int i = dot2 + 1;
    			while (i < version2.length() && version2.charAt(i) != '.')
    				i++;
    			if (Integer.valueOf(version2.substring(dot2 + 1, i)) != 0)
    				return -1;
    			dot2 = i;
    		}
    		return 0;
    	}
    	else
    		return 0;
    }
}
