package cn.edu.sjtu.zzang;

public class DivideTwoIntegers {
	public static void main(String[] args) {
		DivideTwoIntegers dti = new DivideTwoIntegers();
		System.out.println(dti.divide(2147483647, 1));
	}
	
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
        	return Integer.MAX_VALUE;
        int res = 0;
        long p = Math.abs((long)dividend);
        long q = Math.abs((long)divisor);
        while (p >= q) {
        	int digits = 0;
        	while (p >= (q << digits))
        		digits++;
        	res += 1 << (digits - 1);
        	p -= q << (digits - 1);
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
        	return -res;
        return res;
    }
}
