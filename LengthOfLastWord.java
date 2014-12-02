package cn.edu.sjtu.zzang;

public class LengthOfLastWord {
	public static void main(String[] args) {
		LengthOfLastWord l = new LengthOfLastWord();
		System.out.println(l.lengthOfLastWord("hello a   "));
	}

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
        	return 0;
        int len = s.length();
        int count = 0;
        int pre = 0;
        for (int i = 0; i < len; i++) {
        	if (s.charAt(i) == ' ') {
        		pre = count == 0 ? pre : count;
        		count = 0;
        	}
        	else
        		count++;
        }
        return (count == 0 ? pre : count);
    }
}
