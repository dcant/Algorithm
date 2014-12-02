package cn.edu.sjtu.zzang;

public class SortColors {
	public static void main(String[] args) {
		SortColors sc = new SortColors();
		int[] A = {1,2,0,0,1,1,2};
		sc.sortColors(A);
		for (int i : A)
			System.out.print(i);
	}

    public void sortColors(int[] A) {
    	int zero = 0, one = 0, two = 0;
    	for (int i = 0; i < A.length; i++) {
    		if (A[i] == 0) {
    			A[two] = 2;
    			A[one] = 1;
    			A[zero] = 0;
    			zero++;
    			one++;
    			two++;
    		} else if (A[i] == 1) {
    			A[two] = 2;
    			A[one] = 1;
    			one++;
    			two++;
    		} else {
    			A[two] = 2;
    			two++;
    		}
    	}
    }
}
