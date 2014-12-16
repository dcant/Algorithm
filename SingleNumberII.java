package cn.edu.sjtu.zzang;

public class SingleNumberII {
	public static void main(String[] args) {
		SingleNumberII sn = new SingleNumberII();
		int[] A = {1,2,1,1};
		System.out.println(sn.singleNumber(A));
	}
    public int singleNumber(int[] A) {
    	int res = 0;
        for (int i = 0; i < 32; i++) {
        	int d = 1 << i;
        	int count = 0;
        	for (int j = 0; j < A.length; j++)
        		if ((A[j] & d) != 0) count++;
        	if (count % 3 != 0)
        		res |= d;
        }
        return res;
    }
}
