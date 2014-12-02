package cn.edu.sjtu.zzang;

public class CountAndSay {
	public static void main(String[] args) {
		CountAndSay cas = new CountAndSay();
		System.out.println(cas.countAndSay(5));
	}
	
    public String countAndSay(int n) {
    	String res = "1";
    	int i = 1;
    	String tmp = "";
    	while (i < n) {
    		char pre = res.charAt(0);
    		int count = 1;
    		for (int j = 1, len = res.length(); j < len; j++) {
    			if (pre == res.charAt(j))
    				count++;
    			else {
    				tmp += String.valueOf(count) + String.valueOf(pre);
    				count = 1;
    				pre = res.charAt(j);
    			}
    		}
    		tmp += String.valueOf(count) + String.valueOf(pre);
    		res = tmp;
    		tmp = "";
    		i++;
    	}
        return res;
    }
}
