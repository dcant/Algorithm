package cn.edu.sjtu.zzang;

public class NumberOf1Bits {
	public static void main(String[] args) {
		NumberOf1Bits n = new NumberOf1Bits();
		System.out.println(n.hammingWeight(11));
	}
	
    public int hammingWeight(int n) {
        int count = 0, bit = 0;
        while (bit < 32) {
        	count += (n & 1);
        	n >>= 1;
        	bit++;
        }
        return count;
    }
}
