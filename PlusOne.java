package cn.edu.sjtu.zzang;

public class PlusOne {
	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		int[] digits = {1,2,3,4};
		int[] r = po.plusOne(digits);
		for (int i : r)
			System.out.print(i);
	}

    public int[] plusOne(int[] digits) {
    	int len = digits.length;
        int[] res = new int[len + 1];
        for (int i = 0; i < len; i++)
        	res[len - 1 - i] = digits[i];
        int carry = 1;
        for (int i = 0; i < len; i++) {
        	int sum = res[i] + carry;
        	res[i] = sum % 10;
        	carry = sum / 10;
        }
        if (carry == 1)
        	res[len] = 1;
        else
        	res[len] = 0;
        int j = len;
        int i = 0;
        if (res[j] == 0)
        	j--;
        int[] r = new int[j + 1];
        while (i < j) {
        	int tmp = res[i];
        	res[i] = res[j];
        	res[j] = tmp;
        	i++;
        	j--;
        }
        for (i = 0; i < r.length; i++)
        	r[i] = res[i];
        return r;
    }
}
