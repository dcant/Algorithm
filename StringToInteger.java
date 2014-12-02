package cn.edu.sjtu.zzang;

public class StringToInteger {
    public int atoi(String str) {
        if (str == null || str.length() < 1)
        	return 0;
        str = str.trim();
        int i = 0;
        boolean flag = false;
        if (str.charAt(0) == '+')
        	i++;
        if (str.charAt(0) == '-') {
        	flag = true;
        	i++;
        }
        double res = 0;
        while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
        	res = res * 10 + (str.charAt(i) - '0');
        	i++;
        }
        if (flag)
        	res = -res;
        return (int)res;
    }
}
