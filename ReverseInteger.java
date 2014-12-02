package cn.edu.sjtu.zzang;

public class ReverseInteger {
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
        	x = 0 - x;
        	flag = true;
        }
        if (x == 0)
        	return x;
        int res = 0;
        int p = x;
        while (p > 0) {
        	int mod = p % 10;
        	p /= 10;
        	res = res * 10 + mod;
        }
        if (flag)
        	return 0 - res;
        else
        	return res;
    }
}
