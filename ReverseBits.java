package cn.edu.sjtu.zzang;

public class ReverseBits {
	public static void main(String[] args) {
		ReverseBits rb = new ReverseBits();
		System.out.println(rb.reverseBits(43261596));
	}
    public int reverseBits(int n) {
        int x = 0, count = 0;
        while (count < 32) {
        	x <<= 1;
        	x |= (n & 1);
        	n >>= 1;
        	count++;
        }
        return x;
    }
}
