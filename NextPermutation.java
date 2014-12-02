package cn.edu.sjtu.zzang;

public class NextPermutation {
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] num = {1,3,2};
		np.nextPermutation(num);
		for (int i = 0; i < num.length; i++)
			System.out.println(num[i]);
	}

    public void nextPermutation(int[] num) {
        if (num.length <= 1)
        	return;
        int i = num.length - 1;
        for (; i >0; i--) {
        	if (num[i - 1] < num[i]) {
        		if (i == num.length - 1) {
        			int tmp = num[i];
        			num[i] = num[i - 1];
        			num[i - 1] = tmp;
        			return;
        		}
        		int j = num.length - 1;
        		for (; j > i - 1; j--) {
        			if (num[j] > num[i - 1]) {
        				int tmp = num[j];
        				num[j] = num[i - 1];
        				num[i - 1] = tmp;
        				reverse(num, i, num.length - 1);
        				return;
        			}
        		}
        	}
        }
        reverse(num, 0, num.length - 1);
    }
    private void reverse(int[] num, int lo, int hi) {
        while (lo < hi) {
        	int tmp = num[lo];
        	num[lo] = num[hi];
        	num[hi] = tmp;
        	lo++;
        	hi--;
        }   	
    }
}
