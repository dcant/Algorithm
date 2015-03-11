package cn.edu.sjtu.zzang;

public class FactorialTrailingZeroes {
	public static void main(String[] args) {
		FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
		System.out.println(ftz.trailingZeroes(2147483647));
	}
    public int trailingZeroes(int n) {
        int res = 0;
        long i = 5;
        while (i <= n) {
        	res += n / i;
        	i *= 5;
        }
        return res;
    }
}
