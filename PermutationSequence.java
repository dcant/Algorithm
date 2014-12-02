package cn.edu.sjtu.zzang;

public class PermutationSequence {
	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(4, 3));
	}

    public String getPermutation(int n, int k) {
    	boolean[] flag = new boolean[n];
    	StringBuilder sb = new StringBuilder();
    	int[] num = new int[n];
    	num[0] = 1;
    	for (int i = 1; i < n; i++)
    		num[i] = i * num[i  - 1];
    	for (int i = n - 1; i >= 0; i--) {
    		int s = 1;
    		while (k > num[i]) {
    			s++;
    			k -= num[i];
    		}
    		for (int j = 0; j < n; j++) {
    			if (j < s && flag[j])
    				s++;
    		}
    		flag[s - 1] = true;
    		sb.append(s);
    	}
    	return sb.toString();
    }
}
