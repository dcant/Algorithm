package cn.edu.sjtu.zzang;

public class SingleNumber {
	public static void main(String[] args) {
		SingleNumber sn = new SingleNumber();
		int[] A = {1,2,3,1,2,3,4};
		System.out.println(sn.singleNumber(A));
	}
    public int singleNumber(int[] A) {
    	int res = 0;
        for (int i = 0; i < A.length; i++)
        	res ^= A[i];
        return res;
    }
}
